import java.util.Arrays;

/**
 * Created by rkandpal on 5/31/17.
 */
public class Sort {
    //time : o(n2)
    //space : o(1)
    //not a stable sort
    //not a adaptive sort
    public static int[] selectionSort(int[] input){
        int swap;
        for(int i=0; i<input.length; i++){
            for(int j=i+1; j<input.length; j++) {
                if (input[i] > input[j]) {
                    swap = input[j];
                    input[j] = input[i];
                    input[i] = swap;
                }
                //System.out.println(Arrays.toString(input));
            }
        }
        return input;
    }

    //time : o(n2)
    //space : o(1)
    //stable sort
    //adaptive sort (nearly sorted list is sorted very fast.)
    public static int[] bubbleSort(int[] input){
        int swap;
        int count=0 ;
        for(int i=0; i<input.length; i++) {
            boolean swapped = false;
            for (int j=input.length-1; j>i; j--) {
                if (input[j] < input[j - 1]) {
                    swap = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = swap;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
            //System.out.println(++count);
        }
        return input;
    }


    //time : o(n2)
    //space : o(1)
    //stable sort
    //adaptive sort (nearly sorted list is sorted very fast.)
    //divide and conquer use this code a lot.
    //better than bubble sort, fewer comparision to break loop as the list is sorted.
    //less swap than bubble sort
    public static int[] insertionSort(int[] input){
        int swap;
        for(int i=1; i<input.length; i++){
            for(int j=i; j>0; j--){
                if (input[j] < input[j - 1]) {
                    swap = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = swap;
                }
                else{
                    break;
                }
            }
        }
        return input;
    }


    //time : between o(n) and o(n2)
    //space : o(1)
    //stable sort
    //adaptive sort (nearly sorted list is sorted very fast.)
    //THE COMPLEXITY OF SHELL SORT IS BETTER THAN INSERTION SORT AS THE FINAL ITERATION WITH INCREMENT = 1 HAS TO WORK WITH A NEARLY SORTED LIST
    //shell sort (modified insertion sort)
    public static int[] shellSort2(int[] listToSort) {
        int increment = listToSort.length/2;
        while(increment >= 1){
            for(int i=0; i<increment;i++) {
                insert2(listToSort, increment, i);
                System.out.println(Arrays.toString(listToSort));
            }
            increment = increment/2;
        }
        return listToSort;
    }

    private static int[] insert2(int[] listToSort, int increment, int start){
        int swap;
        for(int i=start; i<listToSort.length; i=i+increment){
            for(int j=i+increment; j>start && j<listToSort.length; j=j-increment){
                System.out.println("j=" + j + "\ti(sorted list index)=" + i + "\tstart=" + start + "\tincrement=" + increment);
                if(listToSort[j]<listToSort[j-increment]){
                    swap = listToSort[j];
                    listToSort[j] = listToSort[j-increment];
                    listToSort[j-increment] = swap;
                    System.out.println(Arrays.toString(listToSort));
                } else {
                    break;
                }
            }
        }
        return listToSort;
    }
/*
    public static void insertionSort(int[] listToSort, int startIndex, int increment) {
        for (int i = startIndex; i < listToSort.length; i = i + increment) {
            for (int j = Math.min(i + increment, listToSort.length - 1); j - increment >= 0; j = j - increment) {
                if (listToSort[j] < listToSort[j - increment]) {
                    swap(listToSort, j, j - increment);
                } else {
                    break;
                }
                //print(listToSort);
            }
        }
    }

    public static void shellSort(int[] listToSort) {
        int increment = listToSort.length / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSort(listToSort, startIndex, increment);
            }
            increment = increment / 2;
        }
    }
*/


//merge sort
    public static int[] mergeSort(int[] input){
        int size = input.length/2;



        return input;
    }


    public static void main(StringQuiz[] args){
        //System.out.println(Arrays.toString(Sort.selectionSort(new int[] {4,1,5,-1,0,10,2})));
        //System.out.println(Arrays.toString(Sort.bubbleSort(new int[] {4,1,5,-1,0,10,2})));
        //System.out.println(Arrays.toString(Sort.insertionSort(new int[] {4,1,5,-1,0,10,2})));
        System.out.println(Arrays.toString(Sort.shellSort2(new int[] {4,1,5,-1,0,10,2,3,2,4,20,-5,2})));
    }


//power, string reverse,

}

