package Recursion.Backtracking;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by rkandpal on 8/1/17.
 */
public class LongestCommonSubString {

    //words of input_a will be matchd to input_b
    //each word of input_a will be matched till the end of b if no. of remaining words are more than the length of matched String
    public static void find(String input_a, String input_b, Set<String> matchedStrings){
        char[] inputACharArray = input_a.toCharArray();
        char[] inputBCharArray = input_b.toCharArray();
        for(int i=0; i<inputACharArray.length;i++){
            for(int j=0; j<inputBCharArray.length;j++){
                if(inputACharArray[i] == inputBCharArray[j]){
                    //increase i and j both get the entire sequence that can be matched and store it in matchedStrings
                }
            }
        }
    }

    public static int find(char [] A, char [] B){
        int [][]LCS = new int [A.length+1][B.length+1];
        // if A is null then LCS of A, B =0
        for(int i=0;i<=B.length;i++){
            LCS[0][i]=0;
        }

        // if B is null then LCS of A, B =0
        for(int i=0;i<=A.length;i++){
            LCS[i][0]=0;
        }

        //fill the rest of the matrix
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B.length;j++){
                if(A[i-1]==B[j-1]){
                    LCS[i][j] =  LCS[i-1][j-1] +1;
                }else{
                    LCS[i][j] = 0;
                }
            }
        }
        int result = -1;
        for(int i=0;i<=A.length;i++){
            for(int j=0;j<=B.length;j++){
                if(result<LCS[i][j]){
                    result = LCS[i][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String A = "tutorialhorizon";
        String B = "dynamictutorialProgramming";
        System.out.println("LCS length : " + find(A.toCharArray(), B.toCharArray()));
    }


}
