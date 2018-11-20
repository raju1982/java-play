package non.liner.datastructure;
import java.lang.reflect.Array;

public class HashTablePlay<T,V> {
    private int max_size=20;
    private Node<T,V>[] repository;

    public HashTablePlay(){
        repository =  (Node<T,V>[]) Array.newInstance(Node.class, max_size);
    }

    public HashTablePlay(int size){
        repository =  (Node<T,V>[]) Array.newInstance(Node.class, size);
        max_size = size;
    }

    public void put(T key, V value){
        int hash = key.hashCode()%max_size;
        Node<T,V> data = new Node<T,V>(key, value);
        if (repository[hash] == null){
            repository[hash] = data;
        }
        else{
            Node<T,V> tmp = repository[hash];
            while(tmp.nextNode!=null){
                tmp=tmp.nextNode;
            }
            tmp.nextNode = data;
        }
    }

    public Node<T,V> get(T key){
        int hash = key.hashCode()%max_size;
        if(repository[hash] == null){
            return null;
        }
        else{
            Node<T, V> tmp = repository[hash];
            while(tmp!=null){
                if(tmp.getKey() == key){
                    return tmp;
                }
                tmp=tmp.nextNode;
            }
            return null;
        }
    }

    public static class Node<T,V>{
        private T key;
        private V value;
        private Node<T, V> nextNode;

        public Node(T key, V value){
            this.key = key;
            this.value = value;
        }

        public T getKey(){
            return key;
        }

        public void SetNextNode(Node<T, V> nextNode){
            this.nextNode = nextNode;
        }

        @Override
        public String toString(){
            return key.toString() + ":" + value.toString();
        }
    }



    public static void main(String[] args){
        HashTablePlay<Integer,String> first = new HashTablePlay<Integer,String>();
        first.put(2,"two");
        first.put(3,"three");
        first.put(20,"twenty");
        first.put(21,"twentyOne");
        first.put(22,"twentyTwo");
        first.put(23,"twentyThree");
        first.put(6,"six");

        System.out.println(first.get(2));
        System.out.println(first.get(3));
        System.out.println(first.get(20));
        System.out.println(first.get(21));
        System.out.println(first.get(22));
        System.out.println(first.get(23));
        System.out.println(first.get(60));


        HashTablePlay<Integer,String> second = new HashTablePlay<Integer,String>(25);
    }
    //put
    //get

}
