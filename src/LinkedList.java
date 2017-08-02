/**
 * Created by rkandpal on 7/19/17.
 */
public class LinkedList<T extends Comparable<T>> implements Cloneable{
    private Node<T> head;
    public LinkedList(){}

    public void addNodeToHead(T data){
        if(data == null){
            throw new IllegalArgumentException("invalid value.");
        }
        Node<T> node  = new Node(data);
        if (head != null) {
            node.setNextNode(head);
            head=node;
        }
        else{
            head=node;
        }
    }

    public void addNodeToTail(T data){
        if(data == null){
            throw new IllegalArgumentException("invalid value.");
        }
        Node<T> node  = new Node(data);
        if (head != null) {
            Node tail=head.getNextNode();
            for(;tail.getNextNode()!=null;tail=tail.getNextNode()){ }
            tail.setNextNode(node);
        }
        else{
            head=node;
        }
    }

    public int count(){
        Node node=head;
        int count = 0;
       do{
           count++;
       }while(node.getNextNode()!=null);
        return 1;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        Node node=head;
        do{
            sb.append(node.getData() + " ");
        } while(node.getNextNode()!=null);

        //for(Node node=head;node.getNextNode()!=null;node=node.getNextNode()){}
        return sb.toString();
    }

    public void addNodeToNthPosition(T data){
        Node<T> node  = new Node(data);
    }

    public static void main(String[] args){

        LinkedList<Integer> bus = new LinkedList<Integer>();

    }
}

//FIND AN ELEMENT IN A LINKED LIST
//DELETING A RANDOM ELEMENT IN A LINKED LIST(nth element or find ut and delete)
//COUNT THE NUMBER OF NODES IN A LINKED LIST
/*
Operations-
        Append a new node to the end of the linked list.
        Print all the nodes in the linked list.
        Count the number of nodes in the linked list.
        Return the first element in the linked list.
        Insert at the nth position in the list. Return if the number of nodes is less than n.
        Insert the data into the correct position in a sorted list. Assume that the list is sorted in ascending order.
        Append the nodes of the other list to the end of the curren list.
        Split a linked list into 2 equal parts. If there are an odd number of elements, the extra element should be in the first list. ????
        Remove duplicates in a sorted list.
*/