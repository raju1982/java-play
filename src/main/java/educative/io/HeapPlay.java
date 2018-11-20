package educative.io;

import java.util.ArrayDeque;

public class HeapPlay {
}

//Given a large array of integers and a window of size 'w', find the current maximum in the window as the window slides through the entire array.
//Runtime Complexity Linear, O(n).
//Memory Complexity O(w).
class MaxHeap{
    private int[] dataStore;
    private int size = 2;
    private int count = 0;

    public MaxHeap(){
        dataStore = new int[size];
    }

    public int getRootNode() throws HeapUnderFlowException{
        if(isEmpty()){
            throw new HeapUnderFlowException();
        }
        return dataStore[0];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == size;
    }

    public void insert(int data) throws HeapOverFlowException{
        if(isFull()){
            throw new HeapOverFlowException();
        }
        dataStore[count] = data;
        shiftUP(count);
        dataStore[1] = 0;
        count = 1;
    }

    private void shiftUP(int index){
        int parentIndex = getParentIndex(index);
        if(parentIndex != -1 && getValueAtIndex(parentIndex) < getValueAtIndex(index)){
            swap(parentIndex, index);
            shiftUP(parentIndex);
        }
    }

    private void swap(int a, int b){
        int tmp = getValueAtIndex(a);
        dataStore[a] = getValueAtIndex(b);
        dataStore[b] = tmp;
    }

    public int getValueAtIndex(int index){
        return dataStore[index];
    }

    private int getParentIndex(int index){
        int parentIndex = (index-1)/2;
        if(parentIndex < 0) {
            return -1;
        }
        return parentIndex;
    }

    private int getRightChildIndex(int index){
        int childIndex = 2*index + 2;
        if(childIndex >= size) {
            return -1;
        }
        return childIndex;
    }

    private int getLeftChildIndex(int index){
        int childIndex = 2*index + 1;
        if(childIndex >= size) {
            return -1;
        }
        return childIndex;
    }

    public static void main(String[] args) throws HeapUnderFlowException, HeapOverFlowException{
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(3);
        System.out.println(maxHeap.getRootNode());
        maxHeap.insert(5);
        System.out.println(maxHeap.getRootNode());
        maxHeap.insert(0);
        System.out.println(maxHeap.getRootNode());
        maxHeap.insert(13);
        System.out.println(maxHeap.getRootNode());
        maxHeap.insert(-5);
        System.out.println(maxHeap.getRootNode());
        maxHeap.insert(0);
        System.out.println(maxHeap.getRootNode());

        find_max_sliding_window(new int[] {3,5,0,13,-5,0}, 3);
    }

    public class HeapUnderFlowException extends Exception{}
    public class HeapOverFlowException extends Exception{}

    public static void find_max_sliding_window(int[] array, int window_size) {

        if (array.length < window_size) {
            return;
        }

        ArrayDeque<Integer> window = new ArrayDeque<Integer>();

        //find out max for the first window
        for (int i = 0; i < window_size; i++) {
            while (!window.isEmpty() && array[i] >= array[window.peekLast()]) {
                System.out.println(window);
                window.removeFirst();
            }
            window.addLast(i);
            System.out.println(window);
        }

        System.out.println(array[window.peekFirst()] + ", ");

        for (int i = window_size; i < array.length; i++) {
            //remove all numbers that are smaller than current number from the tail of queue
            while (!window.isEmpty() && array[i] >= array[window.peekLast()]) {
                window.removeLast();
            }
            System.out.println(window);
            //remove first number if it doesn't fall in the window anymore
            if (!window.isEmpty() && window.peekFirst() <= i - window_size) {
                window.removeFirst();
            }
            System.out.println(window);
            window.addLast(i);
            System.out.println(array[window.peekFirst()] + ", ");
        }
    }

}
