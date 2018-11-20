package educative.io;
import java.util.Arrays;

public class Play{



    public static void quickSort(int[] inputArray, int start, int end){
        if(start >= end){
            return;
        }
        int pivot = inputArray[start];
        int i = start;
        int j = end;
        while(i<j){
            while(i<=j && inputArray[i] <= pivot){
                i++;
            }
            while(inputArray[j] > pivot){
                j--;
            }
            if(i<j && inputArray[i] > pivot && inputArray[j] < pivot){
                swap(inputArray, i, j);
                i++;
                j--;
            }
        }
        swap(inputArray, start, j);
        quickSort(inputArray, 0, j-1);
        quickSort(inputArray, j+1, end);
    }

    private static void swap(int[] inputArray, int start, int end){
        int tmp = inputArray[start];
        inputArray[start] = inputArray[end];
        inputArray[end] = tmp;
    }

    public static void main(String[] args){
        int[] inputArray = new int[]{53,23,26,2,25};
        quickSort(inputArray, 0, inputArray.length-1);
        System.out.println(Arrays.toString(inputArray));
    }

}