/**
 * Created by rkandpal on 7/19/17.
 */

import java.lang.Comparable;

public class LinkedList<T extends Comparable<T>> {
    private Node<T> head = null;

    public LinkedList(){};

    //Append a new node to the end of the linked list.
    public void addLast(T data){
    }

    //Append a new node to the end of the linked list.
    public void addFirst(T data){
    }

    //Retrieves, but does not remove, the head (first element) of this list.
    public T peek(){
        return head.getData();
    }

    //Retrieves and removes the head (first element) of this list.
    public T poll(){
        return head.getData();
    }

    //Print all the nodes in the linked list.
    public void print(){

    }

    //Count the number of nodes in the linked list.
    public int count(){
        int count=0;
        return count;
    }




    //Insert at the nth position in the list. Return if the number of nodes is less than n.

    //Insert the data into the correct position in a sorted list. Assume that the list is sorted in ascending order.


    public void removeNode(){

    }

    public static void main(String[] args){
        Node<String> one = new Node<String>("hello");
        System.out.println(one.getData());
        System.out.println(one.getNextNode());
        one.setNode(new Node<String>("world"));
        System.out.println(one.getNextNode());

        LinkedList<String> car = new LinkedList<String>();
        car.addFirst("one");
        car.addLast("two");
        car.addFirst("three");
        car.addLast("four");


    }

}


/*
Append a new node to the end of the linked list.
Print all the nodes in the linked list.
Count the number of nodes in the linked list.
Return the first element in the linked list.
Insert at the nth position in the list. Return if the number of nodes is less than n.
Insert the data into the correct position in a sorted list. Assume that the list is sorted in ascending order.
Append the nodes of the other list to the end of the current list.
Split a linked list into 2 equal parts. If there are an odd number of elements, the extra element should be in the first list. ????
Remove duplicates in a sorted list.
*/


class Node<T extends Comparable<T>>{
    T data;
    Node<T> nextNode;

    public Node(T data){
        this.data = data;
        nextNode = null;
    }

    public Node<T> getNextNode(){
        return nextNode;
    }

    public void setNode(Node<T> nextNode){
        this.nextNode = nextNode;
    }

    public T getData(){
        return data;
    }

    @Override
    public String toString(){
        return data.toString();
    }
}


//generics
//<T> is the data type of class
//class Node<T extends Comparable<T>>{ bound is declared only in class signature, for generics its always extends for both interface and superclass
//<T> is not used in constructor
//<T> is used in variable declaration, return type, input param

