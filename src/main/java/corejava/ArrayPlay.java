package corejava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/**
 * Created by rkandpal on 9/17/17.
 */
public class ArrayPlay {

    public int sum(Item[] data){
        int sum = 0;
        for(Item item: data){
            sum = sum  + item.getPrice();
        }
        return sum;
    }

    public static void main(String[] args){
        Item[] item = new Item[3];
        item[0] = new Item(100, 3);
        item[1] = new Item(200, 1);
        item[2] = new Item(300, 2);

        ArrayPlay play = new ArrayPlay();
        System.out.println(play.sum(item));

        //print array
        System.out.println(Arrays.toString(item));
        Arrays.sort(item);
        System.out.println(Arrays.toString(item));

        //anonymous class
        Comparator<Item> comparePrice = new Comparator<Item>(){
            @Override
            public int compare(Item a, Item b){
                return a.getPrice() - b.getPrice();
            }
        };

        Arrays.sort(item, comparePrice);
        System.out.println(Arrays.toString(item));

        List<Item> cart = Arrays.asList(item);
        System.out.println(cart.size());

        //Arrays.deepToString()
        //Arrays.equals();

    }

}

class Item implements Comparable<Item>{
    private int price;
    private int weight;

    public Item(int price, int weight){
        this.price=price;
        this.weight=weight;
    }

    public int getPrice(){
        return this.price;
    }

    public int getWeight(){
        return this.weight;
    }

    @Override
    public String toString(){
        return String.format("price : %s , weight : %s", price, weight);
    }

    @Override
    public int compareTo(Item a){
        return this.weight-a.weight;
    }

}

/*
New Arrays are always initialized with default values.
byte,short,int,long 0
float,double 0.0
boolean false
object null
 */