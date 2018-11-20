package non.liner.datastructure;

public class StackPlay<T extends Comparable> {
    private int maxSize;
    private int currentSize=0;
    private Node<T> head;

    public StackPlay(int maxSize){
        this.maxSize = maxSize;
    }

    public T pop() throws StackUnderFlowException{
        if(isEmpty()){
            throw new StackUnderFlowException();
        }
        T tmp = head.getData();
        head = head.getNextNode();
        currentSize--;
        return tmp;
    }

    public T peek() throws StackUnderFlowException{
        if(currentSize==0){
            throw new StackUnderFlowException();
        }
        return head.getData();
    }

    public void push(T data) throws StackOverflowException{
        if (isFull()){
            throw new StackOverflowException();
        }
        currentSize++;
        Node tmp = new Node(data);
        tmp.setNextNode(head);
        head = tmp;
    }

    public boolean isFull(){
        return currentSize == maxSize;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    private static class Node<T extends Comparable>{
        private T data;
        private Node<T> node;

        Node(T data){
            this.data = data;
        }

        T getData(){
            return data;
        }

        void setNextNode(Node<T> node){
            this.node = node;
        }

        Node<T> getNextNode(){
            return node;
        }

    }

    public static void main(String[] args) throws StackOverflowException, StackUnderFlowException{
        StackPlay<Integer> bank = new StackPlay<Integer>(4);
        //bank.peek();
        //bank.pop();
        System.out.println(bank.isFull());
        System.out.println(bank.isEmpty());
        bank.push(10);
        bank.push(20);
        bank.push(30);
        bank.push(40);
        System.out.println(bank.isFull());
        System.out.println(bank.isEmpty());

        while(!bank.isEmpty()){
            System.out.println(bank.pop());
        }

        //System.out.println(bank.pop());

    }

}


class StackOverflowException extends Exception{}

class StackUnderFlowException extends Exception{}