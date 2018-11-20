package educative.io;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.Set;
import java.util.HashSet;

public class StringPlay {

    //97 -> 122 [a to z]
    //48 -> 57 [0 to 9]

    public static Character duplicateChar(String input){
        if(input == null || input.length() <= 1){
            throw new IllegalArgumentException("invalid value");
        }
        input = input.trim().toLowerCase().replaceAll("[\\s]","");
        char[] inputArray = input.toCharArray();
        int[] result = new int[26];
        Character output = null;
        for(char x : inputArray){
            if(result[x-97] == 1){
                output = x;
            }
            result[x-97]++;
        }
        return output;
    }


    public static Number convertStringToInt(String input){
        float output = 0;

        if(input == null || input.length() == 0){
            throw new IllegalArgumentException("invalid value");
        }

        char[] inputArray  = input.toCharArray();
        boolean isFractional = false;

        for(int i=inputArray.length-1, j=1; i>-1; i--,j*=10){
            if(inputArray[i] == '-'){
                output = output * -1;
                continue;
            }
            if(inputArray[i] == '.'){
                output = output/j;
                j = 1;
                isFractional = true;
                continue;
            }
            if(isFractional) {
                //output = output + Integer.valueOf(inputArray[i] + "") * j/10;
                output = output + (Character.valueOf(inputArray[i]) - 48) * j/10;
            }
            else {
                //output = output + Integer.valueOf(inputArray[i] + "") * j;
                output = output + (Character.valueOf(inputArray[i]) - 48) * j;

            }
            //System.out.println(output);
                    //(int) Math.pow(10,j);
        }

        if(isFractional){
            return output;
        }
        return (int)output;
    }


    public static boolean isPalidrome(String input){
        char[] inputArray = input.toCharArray();
        for(int i=0, j=inputArray.length-1; j>=inputArray.length/2; i++, j--){
            if(inputArray[i] != inputArray[j]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        //System.out.println(convertStringToInt("683"));
        //System.out.println(convertStringToInt("-683"));
        //System.out.println(convertStringToInt("683.56"));

        System.out.println(isPalidrome("rakear"));
        System.out.println(isPalidrome("maam"));
        System.out.println(isPalidrome("radedar"));
        System.out.println(isPalidrome("radecar"));

        //System.out.println(duplicateChar("rakesh kandpal"));
        //System.out.println(duplicateChar("rake"));
    }

    /*@TestPrac(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "invalid value")
    public void nullValueTest(){
       duplicateChar(null);
    }

    @TestPrac(expectedExceptions=IllegalArgumentException.class, expectedExceptionsMessageRegExp="invalid value")
    public void inValidStringTest(){
        duplicateChar("");
    }

    @TestPrac(expectedExceptions=IllegalArgumentException.class, expectedExceptionsMessageRegExp="invalid value")
    public void inValidSrring2Test(){
        duplicateChar("a");
    }

    @TestPrac
    public void validString(){
        Assert.assertEquals((Character) 'a', duplicateChar("rakesh kandpal"));
    }*/
}







//****All duplicate, first duplicate in string****
//****String to number****
//****Reverse string****
//****remove duplicate in a string****
//****Reverse words in a sentence****
//Remove white spaces
//Given a dictionary of words and an input string tell whether the input string can be completely segmented into dictionary words.
//palindrome
//anagram
//string permutaion
//laxig0melly smallest or largest substring
//String Permutations
//one away string
//non reapting character


//https://www.educative.io/collection/page/5642554087309312/5679846214598656/160002
// https://www.udemy.com/11-essential-coding-interview-questions/learn/v4/t/lecture/7450632?start=0
//https://www.youtube.com/watch?v=NnD96abizww   <Longest Common Subsequence>
//https://www.youtube.com/watch?v=We3YDTzNXEk   <Minimum Edit Distance Dynamic Programming>
//
