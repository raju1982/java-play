package Recursion.DynamicPrograming;

/**
 * Created by rkandpal on 6/18/17.
 */
public class StairClimbVariation {
    //4 = 1* 2* 3* 4
    public static int factorial(int num){
        if(num==1){
            return 1;
        }
        return num * factorial(num-1);
    }

    //https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
    static int stairClimbCounter=0;
    public static int stairClimb(int number){
        if(number<0){
            return 0;
        }
        else if (number == 0){
            return 1;
        }
       stairClimbCounter++;
       return stairClimb(number-1) +  stairClimb(number-2) +  stairClimb(number-3);
    }

    static int[] cache = new int[10];
    static int stairClimbMemoCounter=0;
    public static int stairClimbMemo(int number){
        if(number<0){
            return 0;
        }
        else if (number == 0){
            return 1;
        }
        stairClimbMemoCounter++;
        if(cache[number] == 0) {
            cache[number] = stairClimbMemo(number - 1) + stairClimbMemo(number - 2) + stairClimbMemo(number - 3);
        }
        return cache[number];
    }



    public static void main(String[] args){
        //System.out.println(stairClimb(1));
        System.out.println(stairClimb(7));
        System.out.println(StairClimbVariation.stairClimbCounter);
        System.out.println(stairClimbMemo(7));
        System.out.println(StairClimbVariation.stairClimbMemoCounter);
    }





    //prime number
    //gcd
    //lcd
    //tower of hanoi
    //power

}

