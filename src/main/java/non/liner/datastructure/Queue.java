package non.liner.datastructure;

import java.lang.reflect.Array;

public class Queue<T> {
    private T[] data;
    private static final int SPECIAL_EMPTY_VALUE = -1;
    private int maxSize;
    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    Queue(int size, Class<T> clazz){
        data = (T[]) Array.newInstance(clazz, size);
        maxSize = size;
    }

    public void enque(T inputData) throws QueueOverFlowException{
        if(inputData == null){
            throw new IllegalArgumentException("invalid data");
        }
        if(isFull()){
            throw new QueueOverFlowException();
        }
        tailIndex = (tailIndex+1) % data.length;
        data[tailIndex] = inputData;
        if(headIndex == SPECIAL_EMPTY_VALUE){
            headIndex = tailIndex;
        }
    }

    public T deque() throws QueueUnderFlowException{
        if(isEmpty()){
            throw new QueueUnderFlowException();
        }
        T val = data[headIndex];
        if(headIndex == tailIndex){
            headIndex = SPECIAL_EMPTY_VALUE;
        }
        else{
            headIndex = (headIndex + 1) % data.length;
        }
        return val;
    }

    public boolean isFull(){
        int nextIndex = (tailIndex + 1) % data.length;
        return nextIndex == headIndex;
    }

    public boolean isEmpty(){
        return headIndex == SPECIAL_EMPTY_VALUE;
    }

    public T peek() throws QueueUnderFlowException{
        if(isEmpty()){
            throw new QueueUnderFlowException();
        }
        return data[(headIndex + 1) % data.length];
    }

    public static void main(String[] args) throws QueueOverFlowException,QueueUnderFlowException {
        Queue<Integer> bank = new Queue<Integer>(3, Integer.class);
        bank.enque(10);
        System.out.println(bank.isFull());
        bank.enque(20);
        bank.enque(30);
        System.out.println(bank.isFull());
        System.out.println(bank.deque());
        System.out.println(bank.deque());
        bank.enque(30);
        System.out.println(bank.isEmpty());
    }


}

class QueueOverFlowException extends Exception{

}

class QueueUnderFlowException extends Exception{

}