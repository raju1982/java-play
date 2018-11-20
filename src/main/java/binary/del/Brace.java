package binary.del;
import java.lang.Comparable;

public class Brace<T extends Comparable> {

    public Node<T> linkListInsertionSort(Node<T> head){
        Node<T> sortedLinkListHead = new Node(head.getData());
        Node<T> node = head.getNextNode();
        Node<T> sortedLinkListNode;

        while(node != null){
            //System.out.println("data to be compared: " + node.getData());
            sortedLinkListNode = sortedLinkListHead;
            if(node.getData().compareTo(sortedLinkListHead.getData()) < 0){
                Node<T> tmp = sortedLinkListHead;
                sortedLinkListHead = new Node(node.getData());
                sortedLinkListHead.setNextNode(tmp);
            }
            else{
                while(sortedLinkListNode.getNextNode() != null && (node.getData().compareTo(sortedLinkListNode.getNextNode().getData())) > 0){
                    sortedLinkListNode = sortedLinkListNode.getNextNode();
                }
                if(sortedLinkListNode.getNextNode() == null){
                    sortedLinkListNode.setNextNode(new Node(node.getData()));
                }
                else{
                    Node<T> tmp = sortedLinkListNode.getNextNode();
                    sortedLinkListNode.setNextNode(new Node(node.getData()));
                    sortedLinkListNode.getNextNode().setNextNode(tmp);
                }
            }

            node = node.getNextNode();
        }
        return sortedLinkListHead;
    }

    public static void main(String[] args){
        Node<Integer> node = new Node<Integer>(3);
        node.setNextNode(new Node<Integer>(5));
        node.getNextNode().setNextNode(new Node<Integer>(2));
        node.getNextNode().getNextNode().setNextNode(new Node<Integer>(7));
        node.getNextNode().getNextNode().getNextNode().setNextNode(new Node<Integer>(0));
        node.getNextNode().getNextNode().getNextNode().getNextNode().setNextNode(new Node<Integer>(1));
        node.getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().setNextNode(new Node<Integer>(8));
        node.getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().getNextNode().setNextNode(new Node<Integer>(6));

        Node<Integer> bigNode = node;
        while(bigNode != null) {
            System.out.println(bigNode.getData());
            bigNode = bigNode.getNextNode();
        }

        System.out.println("\n\n");

        Brace<Integer> brace = new Brace<Integer>();
        Node<Integer> sortedNode = brace.linkListInsertionSort(node);

        System.out.println("\n\n");

        bigNode = sortedNode;
        while(bigNode != null) {
            System.out.println(bigNode.getData());
            bigNode = bigNode.getNextNode();
        }
    }

}


class Node<T extends Comparable> {
    private T data;
    private Node<T> nextNode;

    public Node(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void setNextNode(Node<T> nextNode){
        this.nextNode = nextNode;
    }

    public Node<T> getNextNode(){
        return nextNode;
    }
}




/*

public Node<T> linkListInsertionSort(Node<T> head){
        Node<T> sortedLinkListHead = new Node(head.getData());
        Node<T> node = head.getNextNode();
        Node<T> sortedLinkListNode;

        while(node != null){
            //System.out.println("data to be compared: " + node.getData());
            sortedLinkListNode = sortedLinkListHead;
            if(node.getData().compareTo(sortedLinkListHead.getData()) < 0){
                Node<T> tmp = sortedLinkListHead;
                sortedLinkListHead = new Node(node.getData());
                sortedLinkListHead.setNextNode(tmp);
            }
            else{
                while(sortedLinkListNode.getNextNode() != null && (node.getData().compareTo(sortedLinkListNode.getNextNode().getData())) > 0){
                    sortedLinkListNode = sortedLinkListNode.getNextNode();
                }
                if(sortedLinkListNode.getNextNode() == null){
                    sortedLinkListNode.setNextNode(new Node(node.getData()));
                }
                else{
                    Node<T> tmp = sortedLinkListNode.getNextNode();
                    sortedLinkListNode.setNextNode(new Node(node.getData()));
                    sortedLinkListNode.getNextNode().setNextNode(tmp);
                }
            }

            node = node.getNextNode();
        }
        return sortedLinkListHead;
}

public static LinkedListNode sorted_insert(LinkedListNode head, LinkedListNode node) {

    if (node == null) {
      return head;
    }

    if (head == null || node.data <= head.data) {
      node.next = head;
      return node;
    }

    LinkedListNode curr = head;

    while (curr.next != null && (curr.next.data < node.data)) {
      curr = curr.next;
    }

    node.next = curr.next;
    curr.next = node;

    return head;
  }

  public static LinkedListNode insertion_sort(LinkedListNode head) {

    LinkedListNode sorted = null;
    LinkedListNode curr = head;

    while (curr != null) {
      LinkedListNode temp = curr.next;
      sorted = sorted_insert(sorted, curr);
      curr = temp;
    }

    return sorted;
  }
*/