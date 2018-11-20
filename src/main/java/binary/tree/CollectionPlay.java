package binary.tree;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class CollectionPlay {

    public static void main(String[] args){
        Queue<String> queueBank = new LinkedList<String>();
        queueBank.add("one");
        queueBank.add("two");
        queueBank.add("three");

        while(!queueBank.isEmpty()) {
            System.out.println(queueBank.size());
            System.out.println(queueBank.peek());
            System.out.println(queueBank.poll());
        }





        /*
        Stack<String> stackBank = new Stack<String>();
        stackBank.push("one");
        stackBank.push("two");
        stackBank.push("three");
        stackBank.push("four");
        while(!stackBank.isEmpty()){
            System.out.println(stackBank.peek());
            System.out.println(stackBank.pop());
        }
        */


        /*
         Set<String> setBank = new HashSet<>();
        setBank.add("one");
        setBank.add("one");
        setBank.add("three");
        setBank.add("two");
        setBank.add("four");
        setBank.add("five");
        setBank.add("six");
        setBank.add("seven");
        setBank.add("eight");
        for(String gh: setBank){
            System.out.println(gh);
        }

        System.out.println("\n\n");


        setBank.remove(1);
        for(String gh: setBank){
            System.out.println(gh);
        }*/



        /*
        Set<String> treeBank = new TreeSet<>();
        treeBank.add("one");
        treeBank.add("one");
        treeBank.add("three");
        treeBank.add("two");
        treeBank.add("four");
        treeBank.add("five");
        treeBank.add("six");
        treeBank.add("seven");
        treeBank.add("eight");
        for(String gh: treeBank){
            System.out.println(gh);
        }

        //treeBank.remove("one");
        //for(String gh: treeBank){
            //System.out.println(gh);
        //}
        */



        /*
        Map<Integer, String> bank = new HashMap<Integer, String>();
        bank.put(1, "one");
        bank.put(2, "two");
        bank.put(3, "three");
        System.out.println(bank.remove(1));
        bank.put(1, "o");

        for(int key: bank.keySet()){
            System.out.println(bank.get(key));
        }

        System.out.println(bank.containsKey(1));
        System.out.println(bank.containsValue("two"));

        for(Map.Entry<Integer, String> data :bank.entrySet()){
            System.out.println(data.getKey() + " " + data.getValue());
        }

        System.out.println(bank.keySet());*/
    }

}
