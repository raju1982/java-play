package Recursion;

/**
 * Created by rkandpal on 7/28/17.

 */
public class GCDAndLCM {

     /* greatest common divisor (gcd) is the largest positive integer that divides each of the integers.
       For example, the gcd of 8 and 12 is 4.
        If p > q, the gcd of p and q is the same as the gcd of q and p % q.*/
    public static int gcd(int num1, int num2){
        if (num1==0){
            return num2;
        }
        return gcd(num2%num1, num1);
    }

    //LCM is the smallest integer that is evenly divisible by both a and b. For example, LCM (2,3) = 6 and LCM (6,10) = 30
    public static int lcm(int num1, int num2){
        return (num1*num2/gcd(num1, num2));
    }

    public static void main(String[] args){
        System.out.println(gcd(68, 102));
        System.out.println(gcd(102, 68));
        System.out.println(gcd(-102, 68));

        System.out.println(lcm(65, 10));
        System.out.println(lcm(140, 72));
    }

}

//65, 10, 5

