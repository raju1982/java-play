package Recursion.Backtracking;

import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

dictionary =
[i, like, sam, sung, samsung, mobile, ice,
  cream, icecream, man, go, mango, leet, code]

Input: "leetcode",
Output: true

Input:  ilike
Output: true
The string can be segmented as "i like".

Input:  ilikesamsung
Output: true
The string can be segmented as "i like samsung" or "i like sam sung".

Input:  ilikessamsung
Output: true

*/


public class WordBreak {

    static int findMethodCounter = 0;
    public static boolean find(String inputString, Set<String> dict, String answer) {
        findMethodCounter++;
        if (inputString.length() == 0) {
            System.out.println(answer);
            return true;
        } else {
            String word = "";
            for(int index=0; index < inputString.length();){
                // add one char at a time
                word += inputString.charAt(index);
                // check if word exists in dictionary
                if (dict.contains(word)) {
                    //add word to the answer and make a recursive call
                    if (find(inputString.substring(index + 1), dict, answer + word + " ")) {
                        return true;
                    } else {
                        // backtracking [start again]
                        index++;
                    }
                }
                else {
                    //add one more char
                    index++;
                }
            }
            return false;
        }
    }

    public static boolean findwithDP(String inputString, Set<String> dict, Set<String> unMatchedString, String answer) {
        if (inputString.length() == 0) {
            System.out.println(answer);
            return true;
        }
        if(unMatchedString.contains(inputString)){
            return false;
        }
        else {
            String word = "";
            for(int index=0; index < inputString.length();){
                // add one char at a time
                word += inputString.charAt(index);
                // check if word exists in dictionary
                if (dict.contains(word)) {
                    //add word to the answer and make a recursive call
                    if (findwithDP(inputString.substring(index + 1), dict, unMatchedString, answer + word + " ")) {
                        return true;
                    } else {
                        // backtracking [start again]
                        index++;
                    }
                }
                else {
                    //add one more char
                    index++;
                }
            }
            //if we reached till end of string and nothing is matched.= to dictionary.
            unMatchedString.add(word);
            return false;
        }
    }


    public static boolean findUsingDP(String s, Set<String> dict,
                               Set<String> memory, String answer) {
        if (s.length() == 0) {
            System.out.println(answer);
            return true;
        } else if (memory.contains(s)) {
            return false;
        } else {

            int index = 0;
            String word = "";
            while (index < s.length()) {
                word += s.charAt(index);// add one char at a time
                // check if word already being solved
                if (dict.contains(word)) {
                    if (findUsingDP(s.substring(index + 1), dict, memory,
                            answer + word + " ")) {
                        return true;
                    } else {
                        System.out.println("backtrack");
                        index++;
                    }
                } else {
                    index++;
                }
            }
            memory.add(s);// memoization for future;
            return false;
        }
    }



    public static void main(String[] args){
        Set<String> unMatchedStrings = new HashSet<String>();
        Set<String> dict = new HashSet<String>();
        dict.add("i");
        dict.add("like");
        dict.add("likes");
        dict.add("sam");
        dict.add("sams");
        dict.add("sung");
        dict.add("samsung");
        dict.add("mobile");
        dict.add("ice");
        dict.add("cream");
        dict.add("icecream");
        dict.add("man");
        dict.add("go");
        dict.add("mango");
        dict.add("leet");
        dict.add("code");

        /*System.out.println(find("leetcode", dict, ""));
        System.out.println(find("ilikesamsung", dict, ""));
        System.out.println(find("ilikessamsung", dict, ""));
        System.out.println(find("ilikessamssung", dict, ""));
        findMethodCounter = 0;
        System.out.println(find("ilikeandroidmobile", dict, ""));
        System.out.println(findMethodCounter);
        System.out.println("\n\n");
        System.out.println(findwithDP("leetcode", dict, unMatchedStrings, ""));
        System.out.println(findwithDP("ilikesamsung", dict, unMatchedStrings, ""));
        System.out.println(findwithDP("ilikessamsung", dict, unMatchedStrings, ""));
        System.out.println(findwithDP("ilikessamssung", dict, unMatchedStrings, ""));
        System.out.println(findwithDP("ilikeandroidmobile", dict, unMatchedStrings, ""));*/

        System.out.println(findUsingDP("ilikessamsung", dict, unMatchedStrings, ""));
        System.out.println(findUsingDP("ilikessamssung", dict, unMatchedStrings, ""));

    }

}
