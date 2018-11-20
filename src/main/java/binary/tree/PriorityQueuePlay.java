package binary.tree;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class PriorityQueuePlay {

    public static void main(String[] args){
        Queue<String> nameList = new PriorityQueue<String>();
        nameList.add("one");
        nameList.add("two");
        nameList.add("three");
        nameList.add("four");

        //System.out.println(nameList.isEmpty());
        //System.out.println(nameList.peek());
        //System.out.println(nameList.poll());
        //System.out.println(nameList.peek());


        while(!nameList.isEmpty()){
            System.out.println(nameList.size());
            System.out.println(nameList.peek());
            System.out.println(nameList.poll());
        }

        System.out.println("\n\n\n");

        Comparator<String> comp =  new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return b.compareTo(a);
            }
        };

        Queue<String> nameList_1 = new PriorityQueue<String>(comp);
        nameList_1.add("one");
        nameList_1.add("two");
        nameList_1.add("three");
        nameList_1.add("four");

        while(!nameList.isEmpty()){
            System.out.println(nameList.size());
            System.out.println(nameList.peek());
            System.out.println(nameList.poll());
        }

    }

}
