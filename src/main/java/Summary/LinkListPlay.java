package Summary;

import LinkList.Node;

public class LinkListPlay {

    private Node head;

    public void addNode(int data){
        Node node =  new Node(data);
        if (head != null) {
            node.setNextNode(head);
        }
        head = node;
    }

    public void deleteNode(int data){
        if (head == null) {
            throw new IllegalArgumentException("empty list.");
        }
        Node tmp = head;
        while(tmp.getNextNode()!=null){
            if(tmp.getNextNode().getValue() == data){
                tmp.setNextNode(tmp.getNextNode().getNextNode());
                break;
            }
        }
    }

    public void appendNodeToEnd(int data){
        Node node =  new Node(data);
        if(head == null){
            head = node;
            return;
        }
        Node tmp = head;
        while(tmp.getNextNode() != null){
            tmp = tmp.getNextNode();
        }
        tmp.setNextNode(node);
    }

    public class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value=value;
        }

        public Node getNextNode(){
            return this.next;
        }

        public void setNextNode(Node next){
            this.next=next;
        }

        public int getValue(){
            return this.value;
        }

        @Override
        public String toString(){
            return Integer.toString(value);
        }
    }

    @Override
    public String toString(){
        StringBuffer strBuffer = new StringBuffer();
        if(head ==  null){
            return strBuffer.toString();
        }
        Node tmp = head;
        while(tmp != null){
            strBuffer.append(tmp + "  ");
            tmp = tmp.getNextNode();
        }
        return strBuffer.toString();
    }

    public static void main(String[] args){
        LinkListPlay linkList = new LinkListPlay();
        linkList.addNode(5);
        linkList.addNode(8);
        linkList.addNode(10);
        linkList.addNode(15);

        System.out.println(linkList);

        linkList.deleteNode(10);

        System.out.println(linkList);

        linkList.appendNodeToEnd(17);
        linkList.appendNodeToEnd(20);

        System.out.println(linkList);

        linkList.addNode(2);
        System.out.println(linkList);
    }
}
