package Recursion.DynamicPrograming;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DynamicProgramingPlay {

    //This problem exhibits the properties of 'overlapping subproblems' and 'optimal substructure' and can be solved using dynamic programming.

    //Fibonacci Numbers
    //0,1,1,2,3,5,8,13 [element at nth location] [0 is at 0th position]
    //Runtime Complexity
    //Linear, O(n).
    //Memory Complexity
    //Constant, O(1).
    public static int fibonacciSeries(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("invalid input.");
        }
        //i-1 output
        int lastOutput = 1;
        //i-2 output
        int secondLastOutput = 0;
        //final result
        int output = lastOutput + secondLastOutput;
        if (position < 2) {
            return position;
        }
        for (int i = 2; i <= position; i++) {
            output = lastOutput + secondLastOutput;
            secondLastOutput = lastOutput;
            lastOutput = output;
        }
        return output;
    }

    //Given an array, find the contiguous subarray with the largest sum.
    //Runtime Complexity
    //Linear, O(n).
    //Memory Complexity
    //Constant, O(1).
    public static int maxSumInASubarray(int[] input) {
        if (input == null || input.length < 2) {
            throw new IllegalArgumentException("invalid data");
        }

        int globalMax = input[0];
        int currentMAx = input[0];

        for (int i = 0; i < input.length; i++) {
            if (currentMAx < 0) {
                currentMAx = input[i];
            } else {
                currentMAx = currentMAx + input[i];
            }
            if (globalMax < currentMAx) {
                globalMax = currentMAx;
            }
        }
        return globalMax;
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "invalid input.")
    public void testInvalidInput() {
        fibonacciSeries(-1);
    }

    @Test
    public void testValidInput() {
        assertEquals(5, fibonacciSeries(5));
    }

    //Find an efficient algorithm to find maximum sum of a subsequence in an array such that no consecutive elements are part of this subsequence.
    //Runtime Complexity
    //Linear, O(n).
    //Memory Complexity
    //Linear, O(n)
    public static int maxSumSubsequenceNonAdjacentElements(int[] input) {
        if (input == null || input.length < 2) {
            throw new IllegalArgumentException("invalid data");
        }
        int length = input.length;
        int[] solution = new int[length];
        solution[0] = input[0];
        solution[1] = Math.max(input[1], solution[0]);

        for (int i = 2; i < length; i++) {
            solution[i] = Math.max((solution[i-2] + input[i]), solution[i-1]);
        }
        return solution[length-1];
    }

    //Imagine a game (like baseball) where a player can score 1, 2 or 4 runs. Given a score "n", find the total number of ways score "n" can be reached.
    /*
    Runtime Complexity
    Linear, O(n).
    Memory Complexity
    Linear, O(n).
    */
    public static int numberOfWaysPlayerCanScore(int score) {
        int[] solution = new int[score+1];
        int[] runs = new int[] {1, 2, 4};

        for(int i=1; i<=score; i++){
            for(int j=0; j<runs.length; j++){
                if(i==runs[j]){
                    solution[i] = solution[i] + 1;
                }
                else if(i>runs[j]){
                    solution[i] = solution[i] + solution[i-runs[j]];
                }
            }
        }
        return solution[score];
    }

    //Given coin denominations and the total amount, find out the number​ of ways to make the change.
    //we have coin denominations 1, 2 and 5 and the total amount is 7.
    //Runtime Complexity
    //O(m n) where m is number of denominations and n is amount.

    //Memory Complexity
    //Linear, O(n) where n is the amount.
    static int solve_coin_change_dp(int[] denominations, int amount) {
        // this solution requires O(amount) space to store solution until current amount.
        int[] solution = new int[amount + 1];
        solution[0] = 1;

        for (int den : denominations) {
            for (int i = den; i < (amount + 1); ++i) {
                solution[i] += solution[i - den];
            }
        }
        return solution[solution.length - 1];
    }

    private static int min(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }

    //min no. of coin for an amount.
    //we have coin denominations 1, 2 and 5 and the total amount is 7.
    //1 = 1
    public static int minCoinChange(int[] coins, int amount){
        //if below 1 throw exception
        int[] solution = new int[amount+1];

        for(int i=1; i<solution.length; i++){
            if(i==1){
                solution[i] = 1;
            }
            else if(i<5){
                solution[i] = 1 + Math.min(solution[i-1] , solution[i-2]);
            }
            else{
                solution[i] = 1 + min(solution[i-1] , solution[i-2] , solution[i-5]);
            }
        }

        return solution[amount];
    }

    //There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.
    //0 -> 0
    //1-> 1
    //2 -> 2
    //3 -> 2 + 1 = 3
    //4 -> 3 + 2 = 5
    public static int stairCombination(int stairNumber){
        int solution = 0;
        int lastSolution = 2;
        int secondLastSolution =1;
        if(stairNumber < 0){
            //throw exception
        }
        if(stairNumber<3) {
            return stairNumber;
        }
        for(int i=3; i<=stairNumber; i++){
                solution = lastSolution + secondLastSolution;
                secondLastSolution = lastSolution;
                lastSolution = solution;
        }
        return solution;
    }


    public static int editDistance(String firstInputString, String secondInputString){

        return 0;
    }


    public static void main(String[] args) {
        /*System.out.println(fibonacciSeries(0));
        System.out.println(fibonacciSeries(1));
        System.out.println(fibonacciSeries(2));
        System.out.println(fibonacciSeries(3));
        System.out.println(fibonacciSeries(4));
        System.out.println(fibonacciSeries(5));*/

        //System.out.println(maxSumInASubarray(new int[]{-4, 2, -5, 1, 2, 3, 6, -5, 1}));
        //System.out.println(maxSumSubsequenceNonAdjacentElements(new int[]{-4, 2, -5, 1, 2, 3, 6, -5, 1}));

       /* System.out.println("1 : " + numberOfWaysPlayerCanScore(1));
        System.out.println("2 : " + numberOfWaysPlayerCanScore(2));
        System.out.println("3 : " + numberOfWaysPlayerCanScore(3));
        System.out.println("4 : " + numberOfWaysPlayerCanScore(4));
        System.out.println("5 : " + numberOfWaysPlayerCanScore(5));
        System.out.println("6 : " + numberOfWaysPlayerCanScore(6));*/

        /*
        System.out.println("1 : " + solve_coin_change_dp(new int[] {1, 2, 5}, 1));
        System.out.println("2 : " + solve_coin_change_dp(new int[] {1, 2, 5}, 2));
        System.out.println("3 : " + solve_coin_change_dp(new int[] {1, 2, 5}, 3));
        System.out.println("4 : " + solve_coin_change_dp(new int[] {1, 2, 5}, 4));
        System.out.println("5 : " + solve_coin_change_dp(new int[] {1, 2, 5}, 5));
        System.out.println("6 : " + solve_coin_change_dp(new int[] {1, 2, 5}, 6));
        */

        /*System.out.println("1 : " + minCoinChange(new int[] {1, 2, 5}, 1));
        System.out.println("2 : " + minCoinChange(new int[] {1, 2, 5}, 2));
        System.out.println("3 : " + minCoinChange(new int[] {1, 2, 5}, 3));
        System.out.println("4 : " + minCoinChange(new int[] {1, 2, 5}, 4));
        System.out.println("5 : " + minCoinChange(new int[] {1, 2, 5}, 5));
        System.out.println("6 : " + minCoinChange(new int[] {1, 2, 5}, 6));
        System.out.println("7 : " + minCoinChange(new int[] {1, 2, 5}, 7));
        System.out.println("8 : " + minCoinChange(new int[] {1, 2, 5}, 8));
        System.out.println("9 : " + minCoinChange(new int[] {1, 2, 5}, 9));*/

        System.out.println("0 : " + stairCombination(0));
        System.out.println("1 : " + stairCombination(1));
        System.out.println("2 : " + stairCombination(2));
        System.out.println("3 : " + stairCombination(3));
        System.out.println("4 : " + stairCombination(4));
        System.out.println("5 : " + stairCombination(5));
        System.out.println("6 : " + stairCombination(6));
        System.out.println("7 : " + stairCombination(7));
        System.out.println("8 : " + stairCombination(8));
    }
}