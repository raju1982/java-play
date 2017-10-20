package corejava;

/**
 * Created by rkandpal on 9/17/17.
 */
public class EnumPlay {

    public static void check(Season season){
        switch (season){
            case WINTER:
                System.out.println("winter");
        }
    }

    public static void main(String[] args) {
        Season xcv = Season.WINTER;

        if (xcv == Season.WINTER) {
            System.out.println("Winter season");
        }

        check(Season.WINTER);

        for(Season season: Season.values()){
            System.out.println(season);
        }
    }
}

enum Season {
    WINTER, SPRING, SUMMER, FALL
}


//enum in if condition
//enum as method input parameter
//enum with method