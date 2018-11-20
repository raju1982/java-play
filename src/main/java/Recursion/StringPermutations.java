package Recursion;

/**
 * Created by rkandpal on 7/30/17.
 */
import java.util.*;
import java.lang.*;
import java.io.*;



/*
 -> permutation (character array , leftIndex{0} , length)
    -> for (int x = leftIndex{0}; x < size; x++) {
        -> swap(arrA, left, x) { swap left and x index in array }
        -> permutation (character array , leftIndex{0+1} , length)
 }
 */

/*
Take one character at a time and fix it at the first position. (use swap to put every character at the first position)
make recursive call to rest of the characters.
use swap to revert the string back to its original form for next iteration.
*/
public class StringPermutations {
    private char[] arrA;
    //array, startIndex, array length
    public static void permutation(char[] arrA, int left, int size, Set<String> result) {
            for (int x = left; x < size; x++) {
                //System.out.println("swap_0(arrA, left, x), arrA: " + Arrays.toString(arrA) + ", left: " + left + ", x: " + x);
                swap(arrA, left, x);
                System.out.println(Arrays.toString(arrA));
                result.add(Arrays.toString(arrA));
                permutation(arrA, left + 1, size, result);
                //System.out.println("swap_1(arrA, left, x), arrA: " + Arrays.toString(arrA) + ", left: " + left + ", x: " + x);
                swap(arrA, left, x);
                System.out.println(Arrays.toString(arrA));
                result.add(Arrays.toString(arrA));
                //System.out.println("swap_1(arrA, left, x), arrA: " + Arrays.toString(arrA) + ", left: " + left + ", x: " + x);
            }
    }

    //swap letters at position i and j [array, position a, position b]
    public static void swap(char[] arrA, int i, int j) {
        char temp = arrA[i];
        arrA[i] = arrA[j];
        arrA[j] = temp;
    }


    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private static void permute(char[] str, int l, int r)
    {
        if (l == r)
            System.out.println(Arrays.toString(str));
        else
        {
            for (int i = l; i <= r; i++)
            {
                swap(str,l,i);
                System.out.println(Arrays.toString(str));
                permute(str, l+1, r);
                swap(str,l,i);
                System.out.println(Arrays.toString(str));
            }
        }
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
    //a -> [bc] , a [cb]
    //b -> [ac], b [ca]
    //c -> [ab], c->[ba]

    public static void main(String[] args) throws java.lang.Exception {
        String s = "abc";
        char[] arrCh = s.toCharArray();
        //Set<String> result = new HashSet<String>();
        //permutation(arrCh, 0, arrCh.length, result);
        //System.out.println(result);
        permute(arrCh, 0, arrCh.length-1);
    }
}


/*
 -> permutation (character array , leftIndex{0} , length)
    -> for (int x = leftIndex{0}; x < size; x++) {
        -> swap(arrA, left, x) { swap left and x index in array }
        -> permutation (character array , leftIndex{0+1} , length)
 }
 */
