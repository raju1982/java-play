package object;

import java.util.Objects;

/**
 * Created by rkandpal on 9/15/17.
 */
public class ObjectMethodImpl {

    private String type;
    private String brand;
    private int topSpeed;

    public ObjectMethodImpl(String type, String brand, int topSpeed){
        this.type = type;
        this.brand = brand;
        this.topSpeed = topSpeed;
    }

    public String getType(){
        return this.type;
    }

    public String getBrand(){
        return this.brand;
    }

    public int getTopSpeed(){
        return this.topSpeed;
    }

    @Override
    public String toString(){
        //three object in memory
        //return this.type.toString() + " " + this.brand.toString() + " " + this.topSpeed;
        return String.format("%s : %s : %x", this.type, this.brand, this.topSpeed);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(!(obj instanceof ObjectMethodImpl)){
            return false;
        }
        //if(obj.getClass() != this.getClass()){
            //return false;
        //}
        ObjectMethodImpl tmp = (ObjectMethodImpl) obj;
        if(tmp.getBrand() == this.brand && tmp.getType() == this.type){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(type, brand, topSpeed);
    }

    public static void main(String[] args){
        ObjectMethodImpl zamba = new ObjectMethodImpl("car", "honda", 135);
        ObjectMethodImpl boze = new ObjectMethodImpl("car", "honda", 235);

        String printOut = zamba.toString();
        System.out.println(printOut);

        System.out.println(zamba.equals(boze));
        System.out.println(zamba.equals(null));

        System.out.println(zamba.hashCode());
        System.out.println(boze.hashCode());
    }

}
