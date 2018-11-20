package Recursion;

public class Practice {


    /*
    /* greatest common divisor (gcd) is the largest positive integer that divides each of the integers.
       For example, the gcd of 8 and 12 is 4.
        If p > q, the gcd of p and q is the same as the gcd of q and p % q.*/

    public static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        else if(b == 0 ){
            return a;
        }
        if(b > a) {
            return gcd(b%a, a);
        }
        else{
            return gcd(b, a%b);
        }
    }

    //LCM is the smallest integer that is evenly divisible by both a and b. For example, LCM (2,3) = 6 and LCM (6,10) = 30
    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }




         /*
Take one character at a time and fix it at the first position. (use swap to put every character at the first position)
make recursive call to rest of the characters.
use swap to revert the string back to its original form fo next iteration.
*/

    //a
    //ab , ba [swap position]
    //a -> [bc] , b -> [ca] , c -> [ab]




    public static String stringReverse(String inputString){
        int length = inputString.length();
        if(length == 1){
            return inputString;
        }
        return inputString.charAt(length-1) + stringReverse(inputString.substring(0, length-1));
    }




    public static void main(String[] args){
        System.out.println(stringReverse("rakesh"));
        System.out.println(gcd(8, 12));
        System.out.println(lcm(2, 3));
    }

}
