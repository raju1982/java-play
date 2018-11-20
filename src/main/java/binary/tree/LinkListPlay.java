package binary.tree;

import java.util.LinkedList;
import java.util.Stack;

public class LinkListPlay {

    public static void main(String[] args){
        LinkedList<Integer> counterOne = new LinkedList<Integer>();
        counterOne.add(1);
        counterOne.add(5);
        counterOne.add(10);
        counterOne.add(15);
        counterOne.add(20);

        for(Integer pro : counterOne){
            System.out.println(pro);
        }

        LinkedList<Integer> counterTwo = new LinkedList<Integer>();
        counterTwo.add(5);
        counterTwo.add(11);
        counterTwo.add(12);
        counterTwo.add(13);
        counterTwo.add(14);

        Stack<Integer> dataLake = new Stack<Integer>();
        for(Integer data: counterTwo){
            dataLake.push(data);
        }



    }
}
