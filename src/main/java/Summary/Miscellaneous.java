package Summary;

public class Miscellaneous {

    //time complexity : log(n)
    public static int GCD(int a, int b){
        //invalid argument error
        while(b!=0){
            int tmp = b;
            b=a%b;
            a=tmp;
        }
        return a;
    }

    public static void main(String[] args){
        System.out.println(GCD(357,234));
    }
}
