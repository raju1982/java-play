package oops;

/**
 * Created by rkandpal on 9/15/17.
 */
public abstract class Apartment {
    int date;

    int salePrice(){
        return 10;
    }

    protected abstract void dance();
}


class SunnyValeApartment extends Apartment{

    public static void main(String[] args){
        Apartment apt = new SunnyValeApartment();
        System.out.println(apt.salePrice());
    }

    protected void dance(){

    }
}

//abstract class are extended
//abstract class may or may not have abstract method.
//abstract class cannot be instantiated