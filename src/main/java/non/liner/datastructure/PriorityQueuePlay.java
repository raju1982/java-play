package non.liner.datastructure;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Comparator;

public class PriorityQueuePlay {

    public static void main(String[] args){

        Queue<String> queueBank = new LinkedList<String>();
        queueBank.add("one");
        queueBank.add("two");
        queueBank.add("three");
        queueBank.add("four");
        queueBank.add("five");
        while(!queueBank.isEmpty()){
            System.out.println(queueBank.poll());
        }

        System.out.println("\n\n");

        PriorityQueue<String> bank = new PriorityQueue<String>();
        bank.add("one");
        bank.add("two");
        bank.add("three");
        bank.add("four");
        bank.add("five");
        while(!bank.isEmpty()){
            System.out.println(bank.poll());
        }

        System.out.println("\n\n");

        PriorityQueue<String> reverse = new PriorityQueue<String>(new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return b.compareTo(a);
            }
        });
        reverse.add("one");
        reverse.add("two");
        reverse.add("three");
        reverse.add("four");
        reverse.add("five");
        while(!reverse.isEmpty()){
            System.out.println(reverse.poll());
        }

    }

}
