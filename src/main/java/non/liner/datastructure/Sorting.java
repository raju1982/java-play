package non.liner.datastructure;

import java.util.Arrays;

public class Sorting {

    //merge sort
    //split length using recursion, end when length is 1.
    //in each recursion populate array for next iteration - left array/right array
    //merge sorted left and right array to main array
    public static void mergeSort(int[] input) {
        int len = input.length;
        if (len < 2) {
            return;
        }
        //create new array of half size
        int halfLength = len / 2 + len % 2;
        int[] leftInput = new int[halfLength];
        int[] rightInput = new int[input.length - halfLength];
        int count = 0;
        //populate array
        for (int val : input) {
            if (count < halfLength) {
                leftInput[count] = val;
            } else {
                rightInput[count - halfLength] = val;
            }
            count++;
        }
        mergeSort(leftInput);
        mergeSort(rightInput);
        merge(input, leftInput, rightInput);
    }

    private static void merge(int[] input, int[] leftInput, int[] rightInput) {
        //System.out.println(Arrays.toString(input) + " "  + Arrays.toString(leftInput) + " " + Arrays.toString(rightInput));
        int mergeIndex = 0;
        int leftInputIndex = 0;
        int rightInputIndex = 0;

        while (mergeIndex < input.length && leftInputIndex < leftInput.length && rightInputIndex < rightInput.length) {
            if (leftInput[leftInputIndex] < rightInput[rightInputIndex]) {
                input[mergeIndex] = leftInput[leftInputIndex];
                leftInputIndex++;
            } else {
                input[mergeIndex] = rightInput[rightInputIndex];
                rightInputIndex++;
            }
            mergeIndex++;
        }
        //System.out.println(Arrays.toString(input) + " mergeIndex: "  + mergeIndex + " leftInputIndex: " + leftInputIndex);
        while (leftInputIndex < leftInput.length) {
            input[mergeIndex] = leftInput[leftInputIndex];
            leftInputIndex++;
            mergeIndex++;
        }
        //System.out.println(Arrays.toString(input) + " mergeIndex: "  + mergeIndex + " leftInputIndex: " + rightInputIndex);
        while (rightInputIndex < rightInput.length) {
            input[mergeIndex] = rightInput[rightInputIndex];
            rightInputIndex++;
            mergeIndex++;
        }

        //System.out.println(Arrays.toString(input) + " "  + Arrays.toString(leftInput) + " " + Arrays.toString(rightInput));
    }

    //quick sort
    //pick first element of array as pivot
    //start parsing element from both side toward center, move element smaller to pivot on one side
    //stop when start becomes equal to end (all elements are compared to pivot)
    //swap last smaller element to pivot
    //pivot is at it;s correct location, smaller element on one side and larger element on another side
    //now pick first elment for right hand side array and left hand side array
    //do this till array size is 2. [swap if element is smaller than pivot]

    public static void rakesgQuickSort(int[] input, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = findPivotIndex(input, low, high);
        rakesgQuickSort(input, low, pivotIndex - 1);
        rakesgQuickSort(input, pivotIndex + 1, high);
    }

    public static int findPivotIndex(int[] listToSort, int low, int high) {
        int pivot = listToSort[low];
        int l = low;
        int h = high;
        while (l < h) {
            while (listToSort[l] <= pivot && l < h) {
                l++;
            }
            while (listToSort[h] > pivot) {
                h--;
            }
            if (l < h) {
                swap(listToSort, l, h);
            }
        }
        swap(listToSort, low, h);
        return h;
    }

    private static void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
    //heap sort
    //create max heap
    //swap top element with last index element

    public static void main(String[] args) {
        int[] input = new int[]{10, 12, 5, 1, 0, 8, 23, 56, 67, 25, 11};
        mergeSort(input);
        System.out.println(Arrays.toString(input));
        input = new int[]{10, 12, 5, 1, 0, 8, 23, 56, 67, 25, 11};
        rakesgQuickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

}
