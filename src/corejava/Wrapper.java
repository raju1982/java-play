package corejava;

/**
 * Created by rkandpal on 9/13/17.
 */
public class Wrapper {

    public static void main(String[] args){
        // The difference is that using the Constructor you will always create a new object,
        // while using valueOf() static method, it may return you a cached value with-in a range.
        // For example : The cached values for long are between [-128 to 127].
        Integer one = new Integer("1");
        Integer two = new Integer(1);

        System.out.println(one==two);
        System.out.println(one.equals(two));

        Integer three = Integer.valueOf(1);
        Integer four = Integer.valueOf(1);

        System.out.println(three==four);
        System.out.println(three.equals(four));

        one.intValue();
        one.floatValue();

        int x = Integer.parseInt("1");
    }

}
