package corejava;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

/**
 * Created by rkandpal on 9/16/17.
 */
public class InnerClassPlay {

    private int sum;
    private String title;
    private static int panelty = 6;

    InnerClassPlay(int sum, String title){
        this.sum = sum;
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    private int getSum(){
        return this.sum;
    }

    private void setSum(int sum ){
        this.sum = sum;
    }

    // Anonymous class
    private Play name = new Play(){
        private int ticketPrice;
        public void cost(){
            this.ticketPrice = 10;
        }
        public int getTicketPrice(){
            return ticketPrice;
        }
    } ;

    //inner class has access to private members (non-static , static).
    class Smoke{
        int getValue(){
            return getSum() + sum + panelty;
        }
    }

    //static inner class has access to private members (only static).
    static class Drink{
        int getValue(){
            return panelty;
        }
    }

    Comparator<InnerClassPlay> titleComparator = new Comparator<InnerClassPlay>(){
        @Override
        public int compare(InnerClassPlay o1, InnerClassPlay o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    };

    Comparator<InnerClassPlay> sumComparator = new Comparator<InnerClassPlay>(){
        @Override
        public int compare(InnerClassPlay o1, InnerClassPlay o2) {
            return o1.getSum() - o2.getSum();
        }
    };

    @Override
    public String toString(){
        return title + " : " + sum;
    }

    public static void main(String[] args){
        // Anonymous class
        InnerClassPlay one = new InnerClassPlay(20, "one");
        Play sam = one.name;
        sam.cost();
        System.out.println(sam.getTicketPrice());

        //inner class
        Smoke smoke = one.new Smoke();
        System.out.println(smoke.getValue());

        //static inner class
        Drink coke = new InnerClassPlay.Drink();
        System.out.println(coke.getValue());


        //comparator
        InnerClassPlay two = new InnerClassPlay(2, "two");
        InnerClassPlay three = new InnerClassPlay(3, "three");
        InnerClassPlay four = new InnerClassPlay(4, "four");

        InnerClassPlay[] data = new InnerClassPlay[3];
        data[0] = two;
        data[1] = three;
        data[2] = four;

        //Arrays.sort(data, one.sumComparator);
        Arrays.sort(data, one.titleComparator);
        //Collections.sort(ar, new Sortbyroll());

        for(InnerClassPlay x : data){
            System.out.println(x);
        }

    }

}


interface Play{
    void cost();
    int getTicketPrice();
}


//annoymus
//static inner class
//inner class
