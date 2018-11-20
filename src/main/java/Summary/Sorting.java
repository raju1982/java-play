package Summary;

import java.util.Arrays;

public class Sorting {
    //time : o(n2)
    //space : o(1)
    //not a stable sort
    //not a adaptive sort
    public static void selectionSort(int[] input){
        for(int i=0; i<input.length; i++){
            for(int j=i+1;j<input.length; j++){
                if(input[i]>input[j]){
                    int tmp = input[i];
                    input[i] = input[j];
                    input[j] = tmp;
                }
            }
        }
    }

    //time : o(n2)
    //space : o(1)
    //stable sort
    //adaptive sort (nearly sorted list is sorted very fast.)
    public static void bubbleSort(int[] input){
        for(int i=0; i<input.length-1; i++){
            boolean isSwapped=false;
            for(int j=input.length-1; j>i;j--){
                if (input[j] < input[j-1]){
                    int tmp = input[j-1];
                    input[j-1] = input[j];
                    input[j] = tmp;
                    isSwapped=true;
                }
            }
            if(!isSwapped){
                break;
            }
        }
    }


    //time : o(n2)
    //space : o(1)
    //stable sort
    //adaptive sort (nearly sorted list is sorted very fast.)
    //divide and conquer use this code a lot.
    //better than bubble sort, fewer comparision to break loop as the list is sorted.
    //insertionSort has less swap than bubble sort
    public static void insertionSort(int[] input){
        for(int i=1; i<input.length; i++){
            for(int j=i; j>0; j--){
                if(input[j] < input[j-1]){
                    int tmp = input[j-1];
                    input[j-1] = input[j];
                    input[j] = tmp;
                }
                else{
                    break;
                }
            }

        }
    }




    //THE COMPLEXITY OF MERGE SORT IS O(NLOGN)
    //IT TAKES O(N) EXTRA SPACE WHEN WE USE ARRAYS (ALL THE SMALLER LISTS WE CREATE IN THE DIVIDE PHASE)
    // not adaptive - do not perform better with nearly sorted array.
    public static void mergeSort(int[] input){
        if(input.length < 2){
            return;
        }

        int half = input.length/2 + input.length%2;
        int[] rightInputArray = new int[half];
        int[] leftInputArray =  new int[input.length-half];
        int count = 0;
        for(int val: input){
            if(count<half){
                rightInputArray[count] = val;
            }
            else{
                leftInputArray[count-half] = val;
            }
            count++;
        }
        mergeSort(rightInputArray);
        mergeSort(leftInputArray);
        merge(input, rightInputArray, leftInputArray);
    }


    private static void merge(int[] input, int[] rightInputArray, int[] leftInputArray){
        int index=0;
        int rightInputArrayIndex = 0;
        int leftInputArrayIndex = 0;

        while(index<input.length && rightInputArrayIndex<rightInputArray.length && leftInputArrayIndex<leftInputArray.length ){
            if(rightInputArray[rightInputArrayIndex] < leftInputArray[leftInputArrayIndex]){
                input[index]=rightInputArray[rightInputArrayIndex];
                rightInputArrayIndex++;
            }
            else{
                input[index]=leftInputArray[leftInputArrayIndex];
                leftInputArrayIndex++;
            }
            index++;
        }

        while(rightInputArrayIndex<rightInputArray.length && index<input.length){
            input[index]=rightInputArray[rightInputArrayIndex];
            rightInputArrayIndex++;
            index++;
        }

        while(leftInputArrayIndex<leftInputArray.length && index<input.length){
            input[index]=leftInputArray[leftInputArrayIndex];
            leftInputArrayIndex++;
            index++;
        }
    }

    public static void quickSort(int[] input, int low, int high){
        if(low>=high){
            return;
        }
        int pivot = getPivot(input, low, high);
        quickSort(input, low, pivot-1);
        quickSort(input, pivot+1, high);
    }


    private static int getPivot(int[] listToSort, int low, int high){
        int l=low;
        int h=high;
        int pivot = listToSort[low];
        while(l<h) {
            while (l < h && listToSort[l] <= pivot) {
                l++;
            }
            while (listToSort[h] > pivot){
                h--;
            }
            if(l < h) {
                int tmp = listToSort[l];
                listToSort[l] = listToSort[h];
                listToSort[h] = tmp;
            }
        }
        int tmp = listToSort[low];
        listToSort[low] = listToSort[h];
        listToSort[h] = tmp;
        return low;
    }



    public static void main(String[] args){
        int[] input = new int[]{10, 12, 5, 1, 0, 8, 23, 56, 67, 25, 11};
        selectionSort(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{10, 12, 5, 1, 0, 8, 23, 56, 67, 25, 11};
        bubbleSort(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{10, 12, 5, 1, 0, 8, 23, 56, 67, 25, 11};
        insertionSort(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{10, 12, 5, 1, 0, 8, 23, 56, 67, 25, 11};
        mergeSort(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{10, 12, 5, 1, 0, 8, 23, 56, 67, 25, 11};
        quickSort(input,0, input.length-1);
        System.out.println(Arrays.toString(input));

    }

}
