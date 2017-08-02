package Recursion;

/**
 * Created by rkandpal on 7/30/17.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

/*
Take one character at a time and fix it at the first position. (use swap to put every character at the first position)
make recursive call to rest of the characters.
use swap to revert the string back to its original form fo next iteration.
*/
public class StringPermutations {
    private char[] arrA;

    public static void permutation(char[] arrA, int left, int size) {
        int x;
        if (left == size) {
            for (int i = 0; i < arrA.length; i++) {
                System.out.print(arrA[i]);
            }
            System.out.print(" ");
        } else {
            for (x = left; x < size; x++) {
                swap(arrA, left, x);
                permutation(arrA, left + 1, size);
                swap(arrA, left, x);
            }
        }
    }
    //swap letters at position i and j
    public static void swap(char[] arrA, int i, int j) {
        char temp = arrA[i];
        arrA[i] = arrA[j];
        arrA[j] = temp;
    }

    public static String[] play(String input){
        if(input.length() < 2){
            throw new IllegalArgumentException("invalid input.");
        }
        char[] inputArray = input.toCharArray();
        if(input.length() == 2){
            return new String[] {input, ""+inputArray[1]+inputArray[0]};
        }
        List<String> output = new ArrayList<String>();
        for(int i=0; i<inputArray.length; i++){
            String[] tmpArray = play(new StringBuffer(input).deleteCharAt(i).toString());
            for(int j=0; j<tmpArray.length; j++){
                output.add(inputArray[i]+ tmpArray[j]);
            }
        }
        return  output.toArray(new String[output.size()]);
    }

    //a
    //ab , ba [swap position]
    //a -> [bc] , b -> [ca] , c -> [ab]

    public static void main(String[] args) throws java.lang.Exception {
        String s = "abcd";
        char[] arrCh = s.toCharArray();
        permutation(arrCh, 0, arrCh.length);
        System.out.println("\n\n");
        for(String tmp : play("abcd")){
            System.out.println(tmp);
        }
    }
}