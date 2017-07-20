/**
 * Created by rkandpal on 5/30/17.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//"big O analysis" is sometimes called "asymptotic analysis."
public class BigO {


    //Big O notation is the language we use for articulating how long an algorithm takes to run.
    //It's how we compare the efficiency of different approaches to a problem.
    //With big O notation we express the runtime in terms how quickly it grows relative to the input, as the input gets arbitrarily large.

    //This function runs in O(1) time (or "constant time") relative to its input.
    public void printFirstItem(int[] arrayOfItems) {
        System.out.println(arrayOfItems[0]);
    }


    //This function runs in O(n) time (or "linear time"), where n is the number of items in the array.
    public void printAllItems(int[] arrayOfItems) {
        for (int item : arrayOfItems) {
            System.out.println(item);
        }
    }

    // this function runs in O(n^2)O(n​2) time (or "quadratic time").
    public void printAllPossibleOrderedPairs(int[] arrayOfItems) {
        for (int firstItem : arrayOfItems) {
            for (int secondItem : arrayOfItems) {
                int[] orderedPair = new int[]{firstItem, secondItem};
                System.out.println(Arrays.toString(orderedPair));
            }
        }
    }

    //N could be the actual input, or the size of the input
    //Both of these functions have O(n) runtime, even though one takes an integer as its input and the other takes an array:
    //So sometimes nn is an actual number that's an input to our function, and other times nn is the number of items in an input array (or an input map, or an input object, etc.).

    public void sayHiNTimes(int n) {
        for (int x = 0; x < n; x++) {
            System.out.println("hi");
        }
    }

    public void printAllItemsInArray(int[] theArray) {
        for (int item : theArray) {
            System.out.println(item);
        }
    }

    //Drop the constants, Drop the less significant terms
    //This is O(2n), which we just call O(n).
    public void printAllItemsTwice(int[] theArray) {
        for (int item : theArray) {
            System.out.println(item);
        }
        // once more, with feeling
        for (int item : theArray) {
            System.out.println(item);
        }
    }

    //Drop the constants, Drop the less significant terms
    //This is O(1 + n/2 + 100), which we just call O(n).
    public void printFirstItemThenFirstHalfThenSayHi100Times(int[] theArray) {
        System.out.println(theArray[0]);

        int middleIndex = theArray.length / 2;
        int index = 0;

        while (index < middleIndex) {
            System.out.println(theArray[index]);
            index++;
        }

        for (int x = 0; x < 100; x++) {
            System.out.println("hi");
        }
    }

    //Here our runtime is O(n + n^2), which we just call O(n^2)
    public void printAllNumbersThenAllPairSums(int[] arrayOfNumbers) {

        System.out.println("these are the numbers:");
        for (int number : arrayOfNumbers) {
            System.out.println(number);
        }

        System.out.println("and these are their sums:");
        for (int firstNumber : arrayOfNumbers) {
            for (int secondNumber : arrayOfNumbers) {
                System.out.println(firstNumber + secondNumber);
            }
        }
    }





    //Space complexity
    //Sometimes we want to optimize for using less memory instead of (or in addition to) using less time.

    //Talking about memory cost (or "space complexity") is very similar to talking about time cost.
    //We simply look at the total size (relative to the size of the input) of any new variables we're allocating.


    //This function takes O(1) space (or "constant time") (we aren't allocating any new variables):
    //This functions have O(n) runtime
    public void sayHelloNTimes(int n) {
        for (int x = 0; x < n; x++) {
            System.out.println("hello");
        }
    }

    //This function takes O(n) space
    //This functions have O(n) runtime
    public String[] arrayOfHiNTimes(int n) {
        String[] hiArray = new String[n];
        for (int i = 0; i < n; i++) {
            hiArray[i] = "hi";
        }
        return hiArray;
    }

    //This function takes O(1) space (or "constant time")
    //This functions have O(n) runtime
    public int getLargestItem(int[] arrayOfItems) {
        int largest = Integer.MIN_VALUE;
        for (int item : arrayOfItems) {
            if (item > largest) {
                largest = item;
            }
        }
        return largest;
    }

    //space complexity analysis
    //function call stack in memory (implicit stack is growing in memory) [saving the state of method in memory]

    //print position of element in fibonacci
    // 0,1,1,2,3,5,8,13
    private static int fibonacciRecursionCounter = 0;
    public static int fibonacciRecursion(int position){
        if(position <= 1){
            return position;
        }
        fibonacciRecursionCounter++;
        return fibonacciRecursion(position-1) + fibonacciRecursion(position-2);
    }

    //Top-down dynamic programming. In top-down dynamic programming, we store or cache the result of each
    // subproblem that we solve, so that the next time we need to solve the same subproblem
    private static int topDownFibonacciCounter = 0;
    private static int[] cache = new int[10];
    public static int topDownFibonacci(int position){
        if(position <= 1){
            return position;
        }
        if(cache[position] > 0){
            return cache[position];
        }
        cache[position] = topDownFibonacci(position-1) + topDownFibonacci(position-2);
        topDownFibonacciCounter++;
        return cache[position];
    }

    //In bottom-up dynamic programming, we compute solutions to all of the subproblems, starting with the “simplest”
    // subproblem and gradually building up solutions to more and more complicated subproblems.
    private static int bottomUpFibonacciCounter = 0;
    public static int bottomUpFibonacci(int position){
        int[] data = new int[position+1];
        data[0] = 0;
        data[1] = 1;
        for(int i=2; i<=position; i++){
            data[i] = data[i-1] + data[i-2];
            bottomUpFibonacciCounter++;
        }
        return data[position];
    }


    //This functions have O(n) space
    //This functions have O(n) runtime
    public static int factorialRecursive(int number){
        if(number == 0){
            return 1;
        }
        return factorialRecursive(number-1) * number;
    }

    //This function takes O(1) space (or "constant time")
    //This functions have O(n) runtime
    public static int factorial(int number){
        int output = 1;
        for(int i=number;i>1;i--){
            output = output * i;
        }
        return output;
    }

    public static void main(String[]  args){
        System.out.println(fibonacciRecursion(8) + " " + fibonacciRecursionCounter);
        System.out.println(topDownFibonacci(8) + " " + topDownFibonacciCounter);
        System.out.println(bottomUpFibonacci(8) + " " + bottomUpFibonacciCounter);
    }
}



