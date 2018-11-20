package corejava;

/**
 * Created by rkandpal on 9/17/17.
 */
public class initializerPlay extends DB{
    int i = 3;

    {
        System.out.println("Play initializer block" + i);
    }

    static {
        System.out.println("Play static initializer block");
    }

    initializerPlay(){
        System.out.println("Play constructor");
    }

    public static void main(String[] args){
        initializerPlay intializerPlay = new initializerPlay();
    }

}


class DB{

    {
        System.out.println("DB initializer block");
    }

    static {
        System.out.println("DB static initializer block");
    }

    DB(){
        System.out.println("DB constructor");
    }

}

/*
Initialization Blocks - Code which runs when an object is created or a class is loaded
Only static variables can be accessed in a static initializer.

super class static block
child class static block
super class initializer block
super class constructor
child class initializer block
child class constructor
*/