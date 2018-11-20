package Recursion.DynamicPrograming;

/**
 * Created by rkandpal on 7/29/17.
 */
public class Fibonacci {

    public static int fibonacciBasic(int num){
        if(num<0){
            throw new IllegalArgumentException("invalid value");
        }
        if(num <= 1 ){
            return num;
        }
        return fibonacciBasic(num-1) + fibonacciBasic(num-2);
    }

    static int[] cache = new int[10];
    public static int fibonacciTopDown(int num){
        if(num<0){
            throw new IllegalArgumentException("invalid value");
        }
        if(num == 1 && cache[1] == 0){
            cache[1] = 1;
        }
        if(num <= 1 ){
            return cache[num];
        }
        if(cache[num] != 0){
            return cache[num];
        }
        else {
            cache[num] = fibonacciBasic(num - 1) + fibonacciBasic(num - 2);
        }
        return cache[num];
    }

    public static int fibonacciBottumUP(int num){
        if(num == 0){
            return 0;
        }
        int[] cache = new int[num+1];
        cache[1] = 1;
        for(int i=2; i<=num; i++){
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[num];
    }

    public static void main(String[] args){
        for(int i=0; i<10; i++) {
            System.out.print(fibonacciBasic(i) + "\t");
        }
        System.out.println("\n");
        for(int i=0; i<10; i++) {
            System.out.print(fibonacciTopDown(i) + "\t");
        }
        System.out.println("\n");
        //System.out.print(fibonacciBottumUP(0));
        //System.out.print(fibonacciBottumUP(1));
        //System.out.print(fibonacciBottumUP(2));
        for(int i=0; i<10; i++) {
            System.out.print(fibonacciBottumUP(i) + "\t");
        }
    }
}
