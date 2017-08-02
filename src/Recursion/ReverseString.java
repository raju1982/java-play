package Recursion;

/**
 * Created by rkandpal on 7/25/17.
 */
public class ReverseString {

    public static String reverseString(String input){
        StringBuilder sb = new StringBuilder();
        char[] inputArray = input.toCharArray();
        for(int i=inputArray.length-1; i>-1 ; i--){
            sb.append(inputArray[i]);
        }
        return sb.toString();
    }

    public static String reverseStringRecursion(String input){
            if(input.length() == 1){
                return input;
            }
            return input.substring(0,1) + reverseStringRecursion(input.substring(1));
    }

    public static void main(String[] args){
        System.out.println(reverseString("rakesh"));
        System.out.println(reverseStringRecursion("rakesh"));
    }

}
