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

    public static String stringReverse(String inputString){
        int length = inputString.length();
        if(length == 1){
            return inputString;
        }
        return inputString.charAt(length-1) + stringReverse(inputString.substring(0, length-1));
    }

    public static void main(String[] args){
        System.out.println(reverseString("rakesh"));
        System.out.println(stringReverse("rakesh"));
    }

}
