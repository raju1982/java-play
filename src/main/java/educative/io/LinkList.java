package educative.io;

import java.util.HashSet;

public class LinkList<T extends Comparable> {
    private Node<T> head;

    public void addNode(T data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node<T> node = head;
            while (node.getNextNode() != null) {
                node = node.getNextNode();
            }
            node.setNextNode(new Node(data));
        }
    }

    public void printLinkList(){
        if (head == null) {
            return;
        }
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNextNode();
        }
    }

    public void deleteNode(T key){
        if(head.getData() == key){
            head = head.getNextNode();
            return;
        }
        Node<T> node = head;
        while(node.getNextNode() != null){
            if(node.getNextNode().getData() == key){
                node.setNextNode(node.getNextNode().getNextNode());
                return;
            }
            node = node.getNextNode();
        }
    }


    public static void main(String[] args){
        LinkList<Integer> data = new LinkList<Integer>();
        data.addNode(2);
        data.addNode(4);
        data.addNode(6);
        data.addNode(8);
        data.addNode(10);
        //data.addNode(4);
        data.addNode(12);
        //data.addNode(8);
        //data.addNode(10);
        data.printLinkList();
        data.deleteNode(12);
        data.deleteNode(4);
        System.out.println();
        data.printLinkList();
    }
}

class Node<T extends Comparable> {
    private T data;
    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<T> getNextNode() {
        return this.nextNode;
    }
}