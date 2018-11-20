package educative.io;

public class HashMapImplementation {

    public static void main(String[] args){
        HashMapImpl<Integer, String> tmp = new HashMapImpl<Integer, String>();
        tmp.put(10, "ten");
        tmp.put(24, "twentyFour");
        tmp.put(0, "zero");
        tmp.put(55, "fiftyFive");
        tmp.put(93, "nintyThree");
        tmp.put(108, "oneHundredEight");
        tmp.put(17, "seventeen");
        tmp.put(28, "twentyEight");
        tmp.put(3, "three");
        tmp.put(59, "fiftyNine");
        tmp.put(96, "nintySix");
        tmp.put(101, "oneHundredOne");
        tmp.put(30, "thirty");

        System.out.println(tmp.get(10));
        System.out.println(tmp.get(24));
        System.out.println(tmp.get(0));
        System.out.println(tmp.get(59));
        System.out.println(tmp.get(30));
    }

}

class HashMapImpl<Integer, String> {
    int maxSize = 10;
    Node[] nodeArray = new Node[maxSize];

    public void put(Integer key , String value){
        int index = key.hashCode()%maxSize;
        System.out.println("key: " + key + " ,index: " + index + " ,key.hashCode(): " + key.hashCode());
        if (nodeArray[index] == null){
            nodeArray[index] = new Node(key, value);
        }
        else {
            Node node = nodeArray[index];
            while(node.getNextNode() != null){
                node = node.getNextNode();
            }
            node.setNextNode(new Node(key, value));
        }
    }

    public String get(Integer key){
        int index = key.hashCode()%maxSize;
        //System.out.println("key: " + key + " ,index: " + index + " ,key.hashCode(): " + key.hashCode());
        Node<Integer, String> node = nodeArray[index];
        while(node != null){
            if (node.getKey() == key){
                break;
            }
            node = node.getNextNode();
        }
        if(node == null){
            return null;
        }
        else{
            return node.getValue();
        }
    }

    static class Node<Integer, String> {
        Node nextNode = null;
        Integer key = null;
        String value = null;

        Node(Integer key, String data){
            this.key = key;
            this.value = data;
        }

        Integer getKey(){
            return key;
        }

        String getValue(){
            return value;
        }

        void setNextNode(Node nextNode){
            this.nextNode = nextNode;
        }

        Node getNextNode(){
            return nextNode;
        }
    }
}

