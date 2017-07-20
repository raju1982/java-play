/**
 * Created by rkandpal on 6/18/17.
 */
public class Recursion {
    //4 = 1* 2* 3* 4
    public static int factorial(int num){
        if(num==1){
            return 1;
        }
        return num * factorial(num-1);
    }
    
    
    private static long fibonacciCount = 0;
    //0, 1, 1, 2, 3, 5
    public static long fibonacci(int position) {
        fibonacciCount++;
        if(position==0) { return 0; }
        else if (position==1) { return 1; }
        else return fibonacci(position-1) + fibonacci(position-2);
    }

    //Top-down dynamic programming. In top-down dynamic programming, we store or cache the result of each
    // subproblem that we solve, so that the next time we need to solve the same subproblem
    private static long TopDownFibonacciCount = 0;
    private static long[] TopDownFibonacciCache = new long[10];
    public static long TopDownFibonacci(int position) {
        TopDownFibonacciCount++;
        if(position==0) { return 0; }
        else if (position==1) { return 1; }
        if (TopDownFibonacciCache[position] > 0) return TopDownFibonacciCache[position];
        TopDownFibonacciCache[position] =  TopDownFibonacci(position-1) + TopDownFibonacci(position-2);
        return  TopDownFibonacciCache[position];
    }

    //In bottom-up dynamic programming, we compute solutions to all of the subproblems, starting with the “simplest”
    // subproblem and gradually building up solutions to more and more complicated subproblems.
    public static long BottomUpFibonacci(int n) {
        long[] f = new long[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++)
            f[i] = f[i-1] + f[i-2];
        return f[n];
    }



    public static void main(StringQuiz[] args){
        //System.out.println(Recursion.factorial(4));
        System.out.println(Recursion.fibonacci(5));
        System.out.println("fibonacciCount: " + Recursion.fibonacciCount);

        System.out.println(Recursion.TopDownFibonacci(5));
        System.out.println("TopDownFibonacciCount: "+ Recursion.TopDownFibonacciCount);

        System.out.println(Recursion.BottomUpFibonacci(5));
    }





    //prime number
    //gcd
    //lcd
    //tower of hanoi
    //power

}

