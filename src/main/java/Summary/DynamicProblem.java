package Summary;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class DynamicProblem {

    //There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.

    //stair solution and fibonacci solution is same
    static int stairsSolution(int noOfStairs){
        if(noOfStairs<=0){
            throw new IllegalArgumentException();
        }
        if (noOfStairs<=2) {
            return noOfStairs;
        }

        int n1=1;
        int n2=2;
        int combinations = 0;
        for(int n=3; n<=noOfStairs; n++){
            combinations = n1 + n2;
            n2=n1;
            n1=combinations;
        }

        return combinations;
    }

    //fibonacci solution
    static int fibonacci(int position){
        if(position<0){
            throw new IllegalArgumentException();
        }
        int n1=1;
        int n2=0;
        int combinations = 0;
        if (position<2) {
            return position;
        }
        for(int n=2; n<=position; n++){
            combinations = n1 + n2;
            n2=n1;
            n1=combinations;
        }

        return n1;
    }

    //Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
    // Determine the maximum value obtainable by cutting up the rod and selling the pieces
    public static int rodCutterSolution(int[] price, int length){
        int[] solution = new int[length+1];
        solution[0] = 0;

        for(int rodLength=1; rodLength<=length; rodLength++){
            int max = 0;
            for(int cutLength=1; cutLength<=rodLength; cutLength++){
                max = Math.max(max, (price[cutLength] + solution[rodLength-cutLength]));
            }
            solution[rodLength] = max;
        }
        System.out.println(Arrays.toString(solution));
        return solution[length];
    }


    public static int maxValue(int price[], int length){
        int solution[] = new int[length+1];
        for(int rodLength=1; rodLength <= length; rodLength++){
            for(int cutLength=rodLength; cutLength <= length; cutLength++){
                solution[cutLength] = Math.max(solution[cutLength], solution[cutLength-rodLength] + price[rodLength-1]);
            }
        }
        System.out.println(Arrays.toString(solution));
        System.out.println(length);
        return solution[length];
    }

    public static void main(String[] args){
        /*System.out.println(stairsSolution(10));
        System.out.println(stairsSolution(4));
        System.out.println(stairsSolution(3));
        System.out.println(stairsSolution(2));
        System.out.println(stairsSolution(1));*/

        /*
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));*/


        //index server as the length (key-value) (1mm size rod has $2, 2mm rod has $4, 3mm rod has $7)
        //int[] cost = {0, 2, 4, 7, 8, 10, 11};
        int[] price = {0,3,5,8,9,10,20,22,25,30};
        int size = 8;
        System.out.println(rodCutterSolution(price, size));

        System.out.println(maxValue(new int[]{3,5,8,9,10,20,22,25,30}, 8));



        //int hval[] = {6, 7, 1, 3, 8, 2, 4};
        //int n = hval.length;
        //System.out.println("Maximum loot value : " + maxLoot(hval, n));
    }


    // Function to calculate the maximum stolen value
    static int maxLoot(int hval[], int n)
    {
        if (n == 0)
            return 0;

        int value1 = hval[0];
        if (n == 1)
            return value1;

        int value2 = Math.max(hval[0], hval[1]);
        if (n == 2)
            return value2;

        // contains maximum stolen value at the end
        int max_val = 0;

        // Fill remaining positions
        for (int i=2; i<n; i++)
        {
            max_val = Math.max(hval[i]+value1, value2);
            value1 = value2;
            value2 = max_val;
        }

        return max_val;
    }


    public static int steal(int[] num) {
        if(num==null || num.length==0){
            return 0;
        }
        int[] dp= new int[num.length+1];
        dp[0]=0;
        dp[1]=num[0];
        for(int i=2; i<=num.length;i++){
            dp[i] =Math.max(dp[i-1],num[i-1]+dp[i-2]);
        }
        return dp[num.length];
    }

}
