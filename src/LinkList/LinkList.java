package LinkList;

/**
 * Created by rkandpal on 8/3/17.
 */
public class LinkList<T extends Comparable<T>> {
    Node<T> head;

    LinkList(){}

    public void addNode(T data){
        if(data == null){
            throw new IllegalArgumentException("invalid value");
        }
        Node<T> node = new Node<T>(data);
        if(head == null){
            head=node;
        }
        else{
            node.setNode(head);
            head=node;
        }
    }

    public void deleteNode(T data){
        if(data == null){
            throw new IllegalArgumentException("invalid value");
        }
        for(Node node = head, beforeNode = null;node!=null; beforeNode=node, node=node.getNode()){
            if(node.getData() == data){
                if(beforeNode != null){
                    beforeNode.setNode(node.getNode());
                }
                else{
                    head=null;
                }
            }
        }
    }

    public void appendNodeToEnd(T data){
        if(data == null){
            throw new IllegalArgumentException("invalid value");
        }
        Node tmp = new Node<T>(data);
        if(head == null){
            head=tmp;
            return;
        }
        for(Node node = head; node!=null; node=node.getNode()){
            if(node.getNode() == null){
                node.setNode(tmp);
                return;
            }
        }
    }
    public void delete(T data){

    }


    @Override
    public String toString(){
        StringBuffer tmp = new StringBuffer();
        for(Node node = head;node!=null;node=node.getNode()){
            tmp.append(node + " ");
        }
        return tmp.toString();
    }

    public static void main(String[] args){
        LinkList<Integer> intList = new LinkList<Integer>();
        intList.addNode(2);
        intList.addNode(5);
        intList.addNode(16);
        intList.addNode(9);
        intList.addNode(null);

        System.out.println(intList);

        intList.deleteNode(5);
        intList.deleteNode(2);
        intList.deleteNode(16);
        System.out.println(intList);

        intList.deleteNode(9);
        System.out.println(intList);

        intList.appendNodeToEnd(2);
        intList.appendNodeToEnd(5);
        intList.appendNodeToEnd(16);
        intList.appendNodeToEnd(9);
        System.out.println(intList);
    }
}
