package Math;

/**
 * Created by rkandpal on 7/28/17.
 */
public class PrimeNumber {

    public static boolean isPrime(int number){
        for(int i=2 ; i<=number/2; i++){
            if(number%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        for(int i=2; i<15; i++) {
            System.out.println(i + " : " + isPrime(i));
        }
    }
}
