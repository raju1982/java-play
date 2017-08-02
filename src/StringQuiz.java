/**
 * Created by rkandpal on 7/16/17.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class StringQuiz {

    public static void basicOperations(String a, String b){
        //sorted alphabetically/lexicographically
        System.out.println(a.charAt(0)>b.charAt(0)?"YES":"NO");
        System.out.println("rakesh".compareTo("rakesh"));
        System.out.println("rakesh".compareTo("kandpal"));
        System.out.println("kandpal".compareTo("rakesh"));

        System.out.println(a.length() + b.length());
        //first letter of string.
        a = a.substring(0,1).toUpperCase() + a.substring(1,a.length());
        b = b.substring(0,1).toUpperCase() + b.substring(1,b.length());
        System.out.println( a + " " + b);
    }

    public static void LexicographicallySmallestAndLargestSubstrings(String input, int length){
        String highest = input.substring(0,length);
        String lowest = input.substring(0,length);
        for(int i=1 ; i<input.length()-2;i++){
            String tmp = input.substring(i,i+length);
            if(highest.compareTo(tmp) < 0){
                highest = tmp;
            }
            if(lowest.compareTo(tmp) > 0){
                lowest = tmp;
            }
        }
        System.out.println(highest);
        System.out.println(lowest);
    }

    public static boolean palindrome(String input){
        if(input == null || input.length() < 2){
            throw new IllegalArgumentException("incorrect value.");
        }

        for(int i=0; i<input.length()/2; i++){
            if(input.charAt(i) != input.charAt(input.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    //o(n) space and time
    public static String reverse_recursive(String input){
        if(input == null){
            throw new IllegalArgumentException("invalid value.");
        }

        if(input.length() == 1){
            return input;
        }
        return reverse_recursive(input.substring(1,input.length())) + input.charAt(0);
    }

    //O(1) space , time O(n)
    public static String reverse_StringBuilder(String input){
        if(input == null){
            throw new IllegalArgumentException("invalid value.");
        }

        StringBuilder sb = new StringBuilder("");
        for(int i=input.length()-1; i>=0; i--){
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    private static boolean anagrams(String a, String b){
        char[] aArr = a.toLowerCase().toCharArray(), bArr = b.toLowerCase().toCharArray();
        if (aArr.length != bArr.length)
            return false;
        int[] counts = new int[26]; // An array to hold the number of occurrences of each character
        for (int i = 0; i < aArr.length; i++){
            counts[aArr[i]-97]++;  // Increment the count of the character at i
            counts[bArr[i]-97]--;  // Decrement the count of the character at i
        }
        // If the strings are anagrams, the counts array will be full of zeros
        for (int i = 0; i<26; i++)
            if (counts[i] != 0)
                return false;
        return true;
    }


    public static void main(String[] args){
        StringQuiz.basicOperations("rakesh",  "kandpal");
        StringQuiz.LexicographicallySmallestAndLargestSubstrings("welcometojava", 3);
        System.out.println(palindrome("rakesh"));
        System.out.println(palindrome("kandpak"));
        System.out.println(palindrome("madam"));
        System.out.println(palindrome("maam"));
        //System.out.println(palindrome("m"));

        System.out.println(reverse_recursive("rakesh"));
        System.out.println(reverse_recursive("kandpal"));
        System.out.println(reverse_recursive("k"));

        System.out.println(reverse_StringBuilder("rakesh"));
        System.out.println(reverse_StringBuilder("kandpal"));
        System.out.println(reverse_StringBuilder("k"));

        //System.out.println(isAnagram("rakesh", "rakesh"));
        //System.out.println(isAnagram("rakesh", "karhse"));

        //System.out.println(isAnagram("rakess", "karhse"));
    }

}
