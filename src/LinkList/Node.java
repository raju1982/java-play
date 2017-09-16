package LinkList;

/**
 * Created by rkandpal on 8/3/17.
 */

public class Node<T extends Comparable<T>>{
    T data;
    Node<T> node;

    Node(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }

    public void setNode(Node<T> node){
        this.node = node;
    }

    public Node<T> getNode(){
        return node;
    }

    @Override
    public String toString(){
        return data.toString();
    }

}

