package non.liner.datastructure;


import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxHeap {

    public static int maxElementInMinHeap(int[] inputArray){
        int maxIndex = inputArray.length-1;
        int maxValue = inputArray[maxIndex];
        //int max = inputArray[maxIndex];
        //getParentIndex(maxIndex);
        for(int i = getParentIndex(maxIndex) + 1; i <= maxIndex; i++){
            //if(getLeftChildIndex(inputArray, i, max) == -1 && getRightChildIndex(inputArray, i, max) == -1){
            maxValue = Math.max(maxValue,inputArray[i]);
            //}
        }
        return maxValue;
        //find node which dont have left and right child
        //find max amoung these node
    }

    public static void arrayToHeap(int[] inputArray){
        heapify(inputArray, getParentIndex(inputArray.length - 1));
    }

    //treat heap like max heap
    private static void heapify(int[] inputArray, int parentIndex) {
        if(parentIndex < 0){
            return;
        }
        swipeDown(inputArray, parentIndex,inputArray.length-1);
        heapify(inputArray, getParentIndex(parentIndex));
    }

    private static int getParentIndex(int index){
        if(index == 0){
            return -1;
        }
        int parentIndex = (index-1)/2;
        return parentIndex >= 0 ? parentIndex : -1;
    }

    //input Array is a heap
    public static void sorting(int[] inputArray) {
        if (inputArray == null) {
            throw new IllegalArgumentException("null value");
        }
        if (inputArray.length == 1) {
            return;
        }
        sortImpl(inputArray, inputArray.length-1);
    }

    private static void sortImpl(int[] inputArray, int index) {
        if (index == 0) {
            return;
        }
        swap(inputArray, 0, index);
        //make sure max element is at top
        swipeDown(inputArray, 0, index - 1);
        sortImpl(inputArray, index - 1);
    }

    private static void swap(int[] inputArray, int indexA, int indexB) {
        int tmp = inputArray[indexA];
        inputArray[indexA] = inputArray[indexB];
        inputArray[indexB] = tmp;
    }

    //treat heap like max heap
    private static void swipeDown(int[] inputArray, int index, int maxIndex) {
        int leftIndex = getLeftChildIndex(inputArray, index, maxIndex);
        int rightIndex = getRightChildIndex(inputArray, index, maxIndex);
        if (leftIndex == -1 && rightIndex == -1) {
            return;
        } else if (rightIndex != -1 && leftIndex == -1 && (inputArray[index] < inputArray[rightIndex])) {
            swap(inputArray, rightIndex, index);
            swipeDown(inputArray, rightIndex, maxIndex);
        } else if (leftIndex != -1 && rightIndex == -1 && (inputArray[index] < inputArray[leftIndex])) {
            swap(inputArray, leftIndex, index);
            swipeDown(inputArray, leftIndex, maxIndex);
        } else if (rightIndex != -1 && leftIndex != -1) {
            int swapIndex = (inputArray[rightIndex] > inputArray[leftIndex]) ? rightIndex : leftIndex;
            if (inputArray[index] < inputArray[swapIndex]) {
                swap(inputArray, swapIndex, index);
                swipeDown(inputArray, swapIndex, maxIndex);
            }
        }
    }

    private static int getLeftChildIndex(int[] inputArray, int index, int maxIndex) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex > maxIndex) {
            return -1;
        }
        return 2 * index + 1;
    }

    public static int getRightChildIndex(int[] inputArray, int index, int maxIndex) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex > maxIndex) {
            return -1;
        }
        return 2 * index + 2;
    }

    public static void main(String[] args){
        /*int[] inputArray = new int[]{10, 2, 25, 12, 30, 8, 13, 3};
        arrayToHeap(inputArray);
        System.out.println(Arrays.toString(inputArray));

        //30	13	25	12	8	10	3	2
        //int[] input = new int[]{30,13,25,12,8,10,3,2};
        //System.out.println(Arrays.toString(inputArray));
        sorting(inputArray);
        System.out.println(Arrays.toString(inputArray));*/

        int[] minHeapExample = new int[]{5,8,6,9,12,11,7,15,10};
        System.out.println(maxElementInMinHeap(minHeapExample));

    }

}

class Heap<T extends Comparable> {

    private T[] data;
    private int max_size = 20;
    private int arrayIndex = 0;

    public Heap(Class<T> clazz) {
        data = (T[]) Array.newInstance(clazz, max_size);
    }

    public Heap(Class<T> clazz, int size) {
        data = (T[]) Array.newInstance(clazz, size);
        max_size = size;
    }

    public int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex >= arrayIndex) {
            return -1;
        }
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex >= arrayIndex) {
            return -1;
        }
        return 2 * index + 2;
    }

    public int getParentIndex(int index) {
        if (index >= arrayIndex) {
            return -1;
        }
        return (index - 1) / 2;
    }

    public T getElementAtIndex(int index) {
        if (index >= arrayIndex) {
            return null;
        }
        return data[index];
    }

    public void printHeapArray() {
        for (int i = 0; i < arrayIndex; i++) {
            System.out.print(data[i] + "\t");
        }
    }

    public boolean isEmpty() {
        return arrayIndex == 0;
    }

    public boolean isFull() {
        return arrayIndex == data.length;
    }

    public T getMaxPriorityNode() throws EmptyHeapException {
        if (isEmpty()) {
            throw new EmptyHeapException();
        }
        return data[0];
    }

    private void swap(int indexA, int indexB) {
        T tmp = getElementAtIndex(indexA);
        data[indexA] = getElementAtIndex(indexB);
        data[indexB] = tmp;
    }

    //treat heap like max heap
    public void swipeDown(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);
        if (leftIndex == -1 && rightIndex == -1) {
            return;
        } else if (rightIndex != -1 && leftIndex == -1 && getElementAtIndex(index).compareTo(getElementAtIndex(rightIndex)) < 0) {
            swap(rightIndex, index);
            swipeDown(rightIndex);
        } else if (leftIndex != -1 && rightIndex == -1 && getElementAtIndex(index).compareTo(getElementAtIndex(leftIndex)) < 0) {
            swap(leftIndex, index);
            swipeDown(leftIndex);
        } else if (rightIndex != -1 && leftIndex != -1) {
            int swapIndex = getElementAtIndex(rightIndex).compareTo(getElementAtIndex(leftIndex)) > 0 ? rightIndex : leftIndex;
            if (getElementAtIndex(index).compareTo(getElementAtIndex(swapIndex)) < 0) {
                swap(swapIndex, index);
                swipeDown(swapIndex);
            }
        }
    }

    //treat heap like max heap
    public T removeHighPriorityNode() throws EmptyHeapException {
        if (isEmpty()) {
            throw new EmptyHeapException();
        }
        T highPriorityNode = getMaxPriorityNode();
        if (arrayIndex == 1) {
            arrayIndex--;
        } else {
            data[0] = getElementAtIndex(arrayIndex - 1);
            arrayIndex--;
            swipeDown(0);
        }
        return highPriorityNode;
    }

    //insert and remove for max heap
    public void insert(T input) throws HeapOverflowException {
        if (input == null) {
            throw new IllegalArgumentException("null value");
        }
        if (isFull()) {
            throw new HeapOverflowException();
        }
        data[arrayIndex] = input;
        arrayIndex++;
        if (arrayIndex == 1) {
            return;
        }
        swipeUP(arrayIndex - 1);
    }

    //treat heap like max heap
    public void swipeUP(int index) {
        if (index == 0) {
            return;
        }
        int parentIndex = getParentIndex(index);
        if (getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) > 0) {
            swap(parentIndex, index);
            swipeUP(parentIndex);
        }
    }


    public static void main(String[] args) throws EmptyHeapException, HeapOverflowException {
        Heap<Integer> bank = new Heap<Integer>(Integer.class);
        bank.insert(10);
        bank.insert(2);
        bank.insert(25);
        bank.insert(12);
        bank.insert(8);
        bank.insert(30);
        bank.insert(3);
        bank.insert(13);

        bank.printHeapArray();

        System.out.println("\n");

        /*while(!bank.isEmpty()){
            System.out.println(bank.removeHighPriorityNode());
        }*/


        bank.printHeapArray();
    }

}

class EmptyHeapException extends Exception {
}

class HeapOverflowException extends Exception {
}


//create heap class
//get parent
//get left child
//get right child
//heapfullexception [insert]
//heapemptyexception [remove]


//create maxheap class

//crete min heap class

//insert/remove

//hepify - setupup / stepdown

//sort
