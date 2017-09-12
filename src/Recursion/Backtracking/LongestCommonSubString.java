package Recursion.Backtracking;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by rkandpal on 8/1/17.
 */
public class LongestCommonSubString {

    public static int find(String A,  String B){
        int a_size = A.length();
        int b_size = B.length();
        //first row and column will not be used, they will have default value of 0. this will help us in saving code (if else loop)
        int[][] repo = new int[a_size+1][b_size+1];
        int lcs = 0;
        int x=0,y=0;
        for(int i=1;i<a_size; i++){
            for(int j=1; j<b_size; j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    //if(i-1>=0 && j-1>=0){
                        repo[i][j] = 1 + repo[i-1][j-1];
                        if(repo[i][j]>lcs){
                            lcs=repo[i][j];
                            x=i-1;
                            y=j-1;
                        }
                    //}
                    /*else{
                        repo[i][j] = 1;
                        if(repo[i][j]>lcs){
                            lcs=repo[i][j];
                            x=i;
                            y=j;
                        }
                    }*/
                }
            }
        }

        for (int j = 0; j < b_size; j++) {
            System.out.print(B.charAt(j) + " ");
        }
        for(int i=0;i<a_size+1; i++) {
            System.out.println("");
            for (int j = 0; j < b_size+1; j++) {
                System.out.print(repo[i][j] + " ");
            }
        }
        System.out.println("");
        System.out.println("x " + x + " , " + A.charAt(x));
        for(int i=x+1-lcs; i<=x; i++){
            System.out.print(A.charAt(i));
        }
        char[] tmp = new char[lcs];
        for(int i=lcs-1; i>0 ;i--){
            tmp[i]= B.charAt(y-i);
        }
        System.out.println("");
        return lcs;
    }


    public static void main(String[] args) {
        String A = "tutorialhorizon";
        String B = "dynamictutorialProgramming";
        System.out.println("LCS length : " + find(A, B));
        //String str1 = "ABCDGHLQR";
        //String str2 = "AEDPHR";
        //System.out.println("LCS length : " + find(str1, str2));
    }


}
