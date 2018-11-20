package oops;

import java.util.Map;

/**
 * Created by rkandpal on 9/15/17.
 */
public interface House {
    int cost = 0;

    abstract int insurenceAmount();

    default int saleAmount(){
        return 56788;
    }

    static void callout(){

    }



}

interface BayHouse extends House, Map{

}




//interface variable are by default public and final (you need to provide a value)
//interface method are by default public
//interface cannot have method with body
//interface reference variable can hold an object of class that has implemented interface
//interface cannot be instantiated


