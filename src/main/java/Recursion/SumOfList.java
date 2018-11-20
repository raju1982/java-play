package Recursion;

import java.util.Stack;
/**
 * Created by rkandpal on 7/24/17.
 */
public class SumOfList {

    public static int sum(int[] input){
        int sum = 0;
        for(int i=0; i<input.length; i++){
            sum = sum + input[i];
        }
        return sum;
    }

    public static int queue_sum(Stack<Integer> input){
        if(input.size() == 1){
            return input.pop();
        }
        return input.pop() + queue_sum(input);
    }

    public static void main(String[] args){
        System.out.println(sum(new int[] {2,3,4,6,9,1}));
        Stack<Integer> input =  new Stack<Integer>();
        input.push(2);
        input.push(3);
        input.push(4);
        input.push(6);
        input.push(9);
        input.push(1);
        System.out.println(queue_sum(input));
    }
}
