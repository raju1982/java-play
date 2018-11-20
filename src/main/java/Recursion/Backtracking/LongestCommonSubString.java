package Recursion.Backtracking;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by rkandpal on 8/1/17.
 */
public class LongestCommonSubString {

    public static int find_array_solution(String firstString,  String secondString){
        //null check for firstString and secondString

        int a_size = firstString.length();
        int b_size = secondString.length();
        //first row and column will not be used, they will have default value of 0. this will help us in saving code (if else loop)
        int[][] repo = new int[a_size+1][b_size+1];
        int lcs = 0;
        //start position in firstString
        int x=0;
        //start position in secondString
        int y=0;
        for(int i=1;i<a_size; i++){
            for(int j=1; j<b_size; j++){
                if(firstString.charAt(i-1) == secondString.charAt(j-1)){
                        repo[i][j] = 1 + repo[i-1][j-1];
                        if(repo[i][j]>lcs){
                            lcs=repo[i][j];
                            x=i-1;
                            y=j-1;
                        }
                }
            }
        }
        //end character in secondString
        System.out.println(secondString.charAt(y));
        //first character in secondString
        System.out.println(secondString.charAt(y-lcs+1));
        //storing the entire string
        char[] tmp = new char[lcs];
        for(int i=0; i<lcs ;i++){
            tmp[i]= secondString.charAt(y-lcs+i+1);
        }
        System.out.println(Arrays.toString(tmp));
        return lcs;
    }


    public static void main(String[] args) {
        String A = "tutorialhorizon";
        String B = "dynamictutorialProgramming";
        System.out.println("LCS length : " + find_array_solution(A, B));
        //String str1 = "ABCDGHLQR";
        //String str2 = "AEDPHR";
        //System.out.println("LCS length : " + find(str1, str2));
    }


}
