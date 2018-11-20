package Recursion.DynamicPrograming;

import java.util.*;

public class RecursionPlay {

    public static int factorial(int input){
        if(input < 0){
            throw new IllegalArgumentException("invalid input");
        }

        if(input == 1 || input == 0){
            return input;
        }

        return input * factorial(input -1);
    }

    //0,1,1,2,3,5,8
    //[0 = 1st place]
    //insted of map use array
    static Map<Integer, Integer> cache  = new HashMap<>();
    static int count = 0; //[25]
    public static int fibonacci(int numberPosition){
        count++;
        if(numberPosition < 0){
            throw new IllegalArgumentException("invalid numberPosition.");
        }
        if(numberPosition < 2){
            return numberPosition;
        }
        Integer cachedValue = cache.get(numberPosition);
        if(cachedValue != null){
            return cachedValue;
        }
        else {
            cache.put(numberPosition, fibonacci(numberPosition-1) + fibonacci(numberPosition-2));
        }

        return cache.get(numberPosition);
    }


    public static int powerOfBase(int base, int power){
        if(base < 1 || power < 0){
            throw new IllegalArgumentException("invalid put.");
        }
        if(power == 0){
            return 1;
        }
        else if(power == 1){
            return base;
        }
        return base * powerOfBase(base, power-1);
    }


    //array - dictonary
    //array - input - tocharArray
    /*
    Input:  ilikesamsung
             1   5
Output: true
The string can be segmented as "i like samsung" or "i like sam sung***".
     */

    private static String[] dict = new String[]{"i", "like", "sam", "sung","samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango", "leet", "code"};
    private static Stack<Integer> wordSearchIndex = new Stack<>();
    private static List<String> unmatchedString = new ArrayList<>();

    public static boolean wordBreak(String input, int index) {
        for (int j = index; j < input.length(); j++) {
            //tmp string to match
            String tmp = input.substring(index, j+1);
            //check if tmp string is part of unmatched group or if it is matched but the letters immediately after it are unmatched.
            if (unmatchedString.contains(tmp) || unmatchedString.contains(input.substring(j+1))) {
                continue;
            }
            for (int i = 0; i < dict.length; i++) {
                if (tmp.equals(dict[i])) {
                    //if matched, save the start index of new search.
                    wordSearchIndex.push(j+1);
                    //if we have matched till the end return true.
                    if (j == input.length()-1) {
                        return true;
                    } //call again the wordbreak method with new index.
                    else if (wordBreak(input, j+1)) {
                        return true;
                    }
                }
            }
            unmatchedString.add(tmp);
            if(j == input.length()-1) {
                while (!wordSearchIndex.isEmpty()) {
                    if (wordBreak(input, wordSearchIndex.pop())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static int minCoinChange(int[] coins, int value){
        int[] bestSolution = new int[value+1];
        bestSolution[0] = 0;
        int[] solution = new int[coins.length];
        //start storing solution from lowest value.
        for(int i=1; i<=value; i++){
            //get solution for value
            for(int j=0; j<coins.length; j++){
                int coinValue = coins[j];
                if(coinValue <= i){
                    solution[j] = 1 + bestSolution[i-coinValue];
                }
            }
            //find best solution for value and store the same
            for(int j=0; j<coins.length && solution[j]>0; j++){
                if(bestSolution[i] == 0){
                    bestSolution[i] = solution[j];
                }
                else{
                    bestSolution[i] = Math.min(bestSolution[i], solution[j]);
                }
            }
        }
        //return best solution of value.
        return bestSolution[value];
    }

    //value[] = {60, 100, 120}
    //weight[] = {10, 20, 30}
    //W = 50
    //assumption is that we have lot of quantities of each item.
    public static int knapsack(int[] weights, int[] value, int maxWeight){
        int[] bestSolution = new int[maxWeight+1];
        int[] solution = new int[weights.length];

        for(int i=0; i<bestSolution.length; i++){
            //find solution
            //weight should be less than or equal to max weight
            for(int j=0; j<solution.length && weights[j] <= i; j++){
                solution[j] = value[j] + (bestSolution[i-weights[j]]);
            }

            for(int j=0; j<solution.length; j++){
                if( bestSolution[i] == 0 && solution[j]!= 0) {
                    bestSolution[i] = solution[j];
                }
                else if( bestSolution[i] != 0 && solution[j]!= 0) {
                    bestSolution[i] = Math.max(solution[j], bestSolution[i]);
                }
            }
            //find best solution based on value
        }
        return bestSolution[maxWeight];
    }

    // A utility function that returns maximum of two integers
    static int max(int a, int b) { return (a > b)? a : b; }

    //int n = value.length;
    // Returns the maximum value that can be put in a knapsack of capacity weight
    static int knapSack1(int weight, int[] weights, int[] value)
    {
        int i, w;
        int valueArraySize  = value.length;
        int K[][] = new int[valueArraySize+1][weight+1];

        // Build table K[][] in bottom up manner
        //rows have values
        for (i = 0; i <= valueArraySize; i++)
        {
            //column has weight
            for (w = 0; w <= weight; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;  //weight is less than w
                else if (weights[i-1] <= w)
                    K[i][w] = max(value[i-1] + K[i-1][w-weights[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }

        return K[valueArraySize][weight];
    }


//1 -> 1==1 -> 1
//2 -> {n-1 (1)} + {2==2 (1)} -> 2
//3 -> {n-1 (2)} + {n-2 (1)} -> 3
//4 -> {n-1 (3)} + {n-2 (2)} -> 5
//5 -> {n-1 (5)} + {n-2 (3)} -> 8

    public static int stairClimbCombination(int[] steps, int value){
        int[] solution = new int[value+1];
        for(int i=1; i<=value; i++){
            for(int x : steps){
                if (x == i) {
                    solution[i] = solution[i] + 1 ;
                }
                else if (x < i){
                    solution[i] = solution[i] + solution[i-x];
                }
            }

        }
        return solution[value];
    }

    private static int min(int a, int b, int c){
        if(a<b && a<c){
            return a;
        }
        else if(b<a && b<c){
            return b;
        }
        return c;
    }


    public static int editDistance_2(String a, String b, int lenA, int lenB){
       int[][] result = new int[lenA+1][lenB+1];
       for(int i=0; i<=lenA; i++){
           for(int j=0; j<=lenB; j++){
               // If first string is empty, only option is to
               // insert all characters of second string
               if(i == 0){
                   result[i][j] = j;
               }
               else if(j == 0){
                   // If second string is empty, only option is to
                   // remove all characters of second string
                   result[i][j] = i;
               }
               else if(a.charAt(i-1) == b.charAt(j-1)){
                   // If last characters are same, ignore last char
                   // and recur for remaining string
                   result[i][j] = result[i-1][j-1];
               }
               else{
                   // If last character are different, consider all
                   // possibilities and find minimum
                   result[i][j] = 1 + min(result[i-1][j-1], result[i][j-1], result[i-1][j]);
               }
           }
       }
       return result[lenA][lenB];
    }

    public static int longestCommonSubString(String firstString,  String secondString){
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






    public static void main(String[] args){
        //System.out.println(factorial(4));
        //System.out.println(factorial(-1));

        // System.out.println(powerOfBase(2,0));
       // System.out.println(powerOfBase(2,1));
        //System.out.println(powerOfBase(2,3));
        //System.out.println(powerOfBase(3,4));

        //System.out.println(fibonacci(0));
        //System.out.println(fibonacci(1));
        //System.out.println(fibonacci(6));
        //System.out.println(count);

        //System.out.println(wordBreak("ilikesamsung", 0));
        //while (!wordSearchIndex.isEmpty()) {
            //System.out.println(wordSearchIndex.pop());
        //}

        //int[] coins = new int[]{1, 5, 10, 25};
        //System.out.println(minCoinChange(coins, 63));

        //System.out.println(stairClimbCombination(new int[] {1, 2}, 10));

        //System.out.println(editDistance_2("geek", "gesek", "geek".length(), "gesek".length()));
        //System.out.println(editDistance_2("cat", "cut", "cat".length(), "cut".length()));
        //System.out.println(editDistance_2("sunday", "saturday", "sunday".length(), "saturday".length()));

        int[] value = {60, 100, 120};
        int[] weights = {10, 20, 30};
        System.out.println(knapsack(weights, value, 10));
        System.out.println(knapsack(weights, value, 15));
        System.out.println(knapsack(weights, value, 20));
        System.out.println(knapsack(weights, value, 30));
        System.out.println(knapsack(weights, value, 50));

        //int n = value.length;
        System.out.println(knapSack1(10, weights, value));
        System.out.println(knapSack1(15, weights, value));
        System.out.println(knapSack1(20, weights, value));
        System.out.println(knapSack1(30, weights, value));
        System.out.println(knapSack1(50, weights, value));

        //static int knapSack1(int W, int wt[], int val[], int n)
    }

}
/*
    int val[] = new int[]{60, 100, 120};
    int wt[] = new int[]{10, 20, 30};
    int  W = 50;
    int n = val.length;
    System.out.println(knapSack(W, wt, val, n));
 */
//str1 = "sunday", str2 = "saturday"