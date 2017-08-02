/**
 * Created by rkandpal on 7/19/17.
 */
public class Node<T extends Comparable> {
    private T data;
    private Node<T> nextNode;

    public Node(T data){
        if(data == null){
            throw new IllegalArgumentException("invalid value.");
        }
        this.data = data;
        nextNode =  null;
    }

    public T getData(){
        return this.data;
    }

    public Node<T> getNextNode(){
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode){
        if(nextNode == null){
            throw new IllegalArgumentException("invalid value.");
        }
        this.nextNode = nextNode;
    }

    @Override
    public String toString(){
        return data.toString();
    }

    public static void main(String[] args){
        Node<Integer> one = new Node<Integer>(1);
        System.out.println(one.getData());
        System.out.println(one.getNextNode());
        one.setNextNode(new Node<Integer>(2));
        System.out.println(one.getNextNode());
        System.out.println(one.getNextNode().getNextNode());
        System.out.println(one.getNextNode().getData());
        System.out.println(one.getData().compareTo(one.getNextNode().getData()));
    }

}
