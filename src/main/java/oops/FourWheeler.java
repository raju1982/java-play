package oops;

/**
 * Created by rkandpal on 9/15/17.
 */
public class FourWheeler extends Vehicle {

    /*
    public FourWheeler(){
        super("toyota");
        System.out.println("FourWheeler + name");
    }

    public FourWheeler(String name){
        super("toyota");
        System.out.println("FourWheeler " + name);
    }*/

    public void dance(String car){
        super.promote();
        System.out.println(super.name);
    }

    public static void main(String[] args){
        FourWheeler xcb = new FourWheeler();
        xcb.dance("toto");
    }

}
