package Recursion;

/**
 * Created by rkandpal on 7/28/17.
 */
public class TowersOfHanoi {

    public static void moveTower(int height,String fromPole, String toPole, String withPole){
        if (height >= 1) {
            //we move all but the bottom disk on the initial tower to an intermediate pole.
            moveTower(height - 1, fromPole, withPole, toPole);
            moveDisk(fromPole, toPole);
            moveTower(height - 1, withPole, toPole, fromPole);
        }
    }

    public static void moveDisk(String fromPole, String toPole){
        System.out.println("moving disk from" + fromPole + " to " + toPole);
    }

    public static void main(String[] args) {

        moveTower(1, "Tower A", "Tower c", "Tower B");
        System.out.println("\n\n\n\n");
        moveTower(2, "Tower A", "Tower c", "Tower B");
        System.out.println("\n\n\n\n");
        moveTower(3, "Tower A", "Tower c", "Tower B");
    }

}

