package educative.io;
import java.util.Arrays;

//binarySearch [recursive]
//Runtime Complexity Logarithmic, O(logn)
//Memory Complexity Logarithmic, O(logn).

//binarySearch Iterative solution
//Runtime Complexity Logarithmic, O(logn)
//Memory Complexity Logarithmic, O(1).

//interpolationSearch is modified version of Binary Search , it;s good if data set is evenly distributed, its not skewed.

//find an element in a sorted and rotated array

//Runtime Complexity	Linear, O(n).
//Memory Complexity		Constant, O(1).
//Given three integer arrays sorted in ascending order, find the smallest number that is common in all three arrays.

//Runtime Complexity	Linear, O(n).
//Memory Complexity	Constant, O(1).
//Given an array of integers, rotate the array by 'N' elements.

//Given a sorted array of integers, return the low and high index of the given key. Return -1 if not found. The array length can be in millions with lots of duplicates.

//Given an integer array, move all elements containing '0' to the left while maintaining the order of other elements in the array.

//Given a list of stock prices for n days, find the maximum profit with a single buy/sell activity.

//find a sub array with max sum

//quick sort

//find kth smallest element in array

//max heap to find n smallest element

//min heap to find n largest element.

public class ArrayPlay {

    //search
    public static int binarySearch(int[] inputArray, int searchValue){
        return search(inputArray, searchValue, 0, inputArray.length-1);
    }

    private static int search(int[] inputArray, int searchValue, int min, int max){
        if(min > max){
            return -1;
        }

        int mid = (min + max)/2;

        if(inputArray[mid] == searchValue){
            return mid;
        }
        else if(inputArray[mid] < searchValue){
            return search(inputArray, searchValue, mid+1, max);
        }
        else{
            return search(inputArray, searchValue, min, mid-1);
        }
    }

    //find an element in a sorted and rotated array
    public static int binary_search(int[] arr,  int start, int end,  int key) {
        // assuming all the keys are unique.
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        int midElementValue = arr[mid];
        int startElementValue = arr[start];
        int endElementValue = arr[end];

        if (midElementValue == key) {
            return mid;
        }

        /* // binary search logic
        if(key < midElementValue){
            return search(arr, key, start, mid-1);
        }
        else{
            return search(arr, key, mid+1, end);
        }
        */
            //first half is sorted and search value lies in first half
        if (startElementValue < midElementValue && key < midElementValue && key >= startElementValue) {
            return binary_search(arr, start, mid - 1, key);
        } else if (midElementValue < endElementValue && key > midElementValue && key <= endElementValue) {
            //second half is sorted and search value lies in first half
            return binary_search(arr, mid + 1, end, key);
        } else if (startElementValue > midElementValue) {
            //first half is un-sorted and search value lies in first half
            return binary_search(arr, start, mid - 1, key);
        } else if (endElementValue < midElementValue) {
            //second half is un-sorted and search value lies in second half
            return binary_search(arr, mid + 1, end, key);
        }

        return -1;
    }

    static int binary_search_rotated(int[] arr, int key) {
        return binary_search(arr, 0, arr.length - 1, key);
    }

    public static int findMinCommonValue(int[] firstArray, int[] secondArray, int[] thirdArray) {

        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        int thirdArrayIndex = 0;

        while (firstArrayIndex < firstArray.length && secondArrayIndex < secondArray.length && thirdArrayIndex < thirdArray.length) {
            if (firstArray[firstArrayIndex] == secondArray[secondArrayIndex] && secondArray[secondArrayIndex] == thirdArray[thirdArrayIndex]) {
                return firstArray[firstArrayIndex];
            } else {
                if ((firstArray[firstArrayIndex] < secondArray[secondArrayIndex]) && (firstArray[firstArrayIndex] < thirdArray[thirdArrayIndex])) {
                    firstArrayIndex++;
                } else if ((secondArray[secondArrayIndex] < firstArray[firstArrayIndex]) && (secondArray[secondArrayIndex] < thirdArray[thirdArrayIndex])) {
                    secondArrayIndex++;
                } else {
                    thirdArrayIndex++;
                }
            }
        }
        return -1;
    }



    //Given a sorted array of integers, return the low and high index of the given key. Return -1 if not found. The array length can be in millions with lots of duplicates.
    public static void lowAndHighIndexSearch(int[] inputArray, int search, Index min, Index max){
        min.setValue(lowIndexSearch(inputArray, search, 0, inputArray.length-1));
        max.setValue(highIndexSearch(inputArray, search,0, inputArray.length-1));
    }

    private static int lowIndexSearch(int[] inputArray, int search, int min, int max){
        while(min<=max){
            int mid = (min+max)/2;
            if(inputArray[mid] >= search){
                max = mid-1;
            }
            else{
                min=mid+1;
            }
        }

        if(inputArray[min] == search){
            return min;
        }

        return -1;
    }

    private static int highIndexSearch(int[] inputArray, int search, int min, int max){
        while(min<=max){
            int mid = (min+max)/2;
            if(inputArray[mid] <= search){
                min = mid+1;
            }
            else{
                max = mid-1;
            }
        }

        if(inputArray[max] == search){
            return max;
        }

        return -1;
    }

    public static class Index {
        private int value;

        public void setValue(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    //max stock price
    public static int maxDifferenceInArray(int[] inputArray){
        int min = Math.min(inputArray[0], inputArray[1]);
        int maxDifference = inputArray[1]-inputArray[0];
        int index = 2;
        while(index < inputArray.length){
            if(inputArray[index]-min > maxDifference){
                maxDifference = inputArray[index]-min;
            }
            if(inputArray[index] < min){
                min = inputArray[index];
            }
            index++;
        }
        return maxDifference;
    }

    //[1,2,0,0,5,13,8,20,8,0,6]
    //[0,0,0,1,2,5,13,8,20,8,6]
    //move all number with zeros on one side
    public static void moveNumbersToLeft(int[] inputArray){
        int readIndex = inputArray.length-1;
        int writeIndex = readIndex;

        while(readIndex>=0){
            if(inputArray[readIndex] != 0){
                inputArray[writeIndex] = inputArray[readIndex];
                writeIndex--;
            }
            readIndex--;
        }

        while(writeIndex>=0){
            inputArray[writeIndex] = 0;
            writeIndex--;
        }
    }

    public static int maxSumSubArray(int[] inputArray){
        int max_ending_here = 0;
        int max_so_far = 0;
        int start_index = 0;
        int end_index = 0;
        int maxStartIndex = 0;

        for(int index = 0; index < inputArray.length; index++){
            max_ending_here = max_ending_here + inputArray[index];
            if(max_ending_here < 0){
                max_ending_here = 0;
                start_index = index+1;
            }
            else if(max_so_far < max_ending_here){
                max_so_far = max_ending_here;
                end_index = index;
                maxStartIndex=start_index;
            }
        }
        System.out.println("sum=" + max_ending_here + " ,maxStartIndex=" + maxStartIndex + " ,end_index=" + end_index);
        return max_so_far;
    }

    public static int getPivot(int[] input, int startIndex, int endIndex){
        int l = startIndex;
        int h = endIndex;

        while(l<h){
            while(input[l] <= input[startIndex] && l < h){
                l++;
            }
            while(input[h] > input[startIndex]){
                h--;
            }
            swap(input, h, l);
        }
        swap(input, startIndex, h);
        return h;
    }

    public static int find(int[] input, int startIndex, int endIndex, int searchIndex){
        int pivot = getPivot(input, startIndex, endIndex);
        System.out.println("index: " + pivot + " ,startIndex: " + startIndex + " ,endIndex: " + endIndex + " " + Arrays.toString(input));

        if(pivot == searchIndex){
            return input[pivot];
        }

        if(pivot<searchIndex){
            return find(input, pivot+1, endIndex, searchIndex);
        }
        else{
            return find(input, startIndex, pivot-1, searchIndex);
        }
    }

    private static void swap(int[] input, int j, int k){
        int tmp = input[j];
        input[j] = input[k];
        input[k] = tmp;
    }

    public static void main(String[] args){

        int[] input = new int[] {3,1,6,9,0,2,12,8,14};
        System.out.println(find(input, 0, input.length-1,4));

        /*
        int[] input = new int[] {3,-1,-1,-1,-1,-1,2,0,0,0};
        //maxSumSubArray(input);
        System.out.println(maxSumSubArray(input));
        input = new int[] {-2,-3,4,-1,-2,1,5,-3};
        //maxSumSubArray(input);
        System.out.println(maxSumSubArray(input));
        */

        /*
        int[] intArr={3, -1, -1, -1, -1, -1, 2, 0, 0, 0 };
        //int[] intArr = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
        //int[] intArr={-6,-2,-3,-4,-1,-5,-5};
         */


        /*int[] input = new int[] {1,2,3,4,5,6,7};
        moveNumbersToLeft(input);
        System.out.println(Arrays.toString(input));

        input = new int[] {1,10,20,0,59,63,0,88,0};
        moveNumbersToLeft(input);
        System.out.println(Arrays.toString(input));*/

       // System.out.println(maxDifferenceInArray(new int[] {8,5,12,9,19,1}));
       // System.out.println(maxDifferenceInArray(new int[] {8,5,12,2,9,19,1}));
       // System.out.println(maxDifferenceInArray(new int[] {21,12,11,9,6,3}));

        /*System.out.println(binarySearch(new int[] {1,2,3,4,5,6,7}, 4));
        System.out.println(binarySearch(new int[] {1,2,3,4,5,6,7}, 1));
        System.out.println(binarySearch(new int[] {1,2,3,4,5,6,7}, 7));
        System.out.println(binarySearch(new int[] {1,2,3,4,5,6,7}, 8));

        int[] firstArray = new int[]{4, 12, 18, 24, 30, 36};
        int[] secondArray = new int[]{6, 10, 24, 28, 30};
        int[] thirdArray = new int[]{0, 5, 7, 10, 24, 36};
        System.out.println(findMinCommonValue(firstArray, secondArray, thirdArray));*/
    }
}
//min = 0,  min = 2, min = 4, min = 7