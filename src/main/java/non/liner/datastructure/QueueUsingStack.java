package non.liner.datastructure;
import java.util.Stack;

public class QueueUsingStack<T extends Comparable> {
    private Stack<T> forwardStack;
    private Stack<T> reverseStack;

    public QueueUsingStack(){
        forwardStack = new Stack<T>();
        reverseStack = new Stack<T>();
    }

    public void enqueue(T data){
        //add to queue tail (queueStack head)
        if(forwardStack.isEmpty()) {
            while(!reverseStack.isEmpty()) {
                forwardStack.push(reverseStack.pop());
            }
        }
        forwardStack.push(data);
    }

    public T dequeue() throws QueueUnderFlowException {
        //add to queue tail (queueStack head)
        if (isEmpty()) {
            throw new QueueUnderFlowException();
        }
        if (reverseStack.isEmpty()) {
            while (!forwardStack.isEmpty()) {
                reverseStack.push(forwardStack.pop());
            }
        }
        return reverseStack.pop();
    }

    public boolean isEmpty(){
        return reverseStack.isEmpty() && forwardStack.isEmpty();
    }

    public static void main(String[] args) throws QueueOverFlowException,QueueUnderFlowException {
        QueueUsingStack<Integer> bank = new QueueUsingStack<Integer>();
        bank.enqueue(10);
        bank.enqueue(20);
        bank.enqueue(30);
        System.out.println(bank.dequeue());
        System.out.println(bank.dequeue());
        System.out.println(bank.dequeue());
        //System.out.println(bank.dequeue());
        bank.enqueue(30);
        System.out.println(bank.dequeue());
    }
}
