package Recursion.DynamicPrograming;

public class EggProblem {

    public static int eggSolution(int noOfEggs, int noOfFloor){

        if(noOfFloor < 1){
            throw new IllegalArgumentException("invalid parameter: noOfFloor");
        }

        //int noOfEggs = 2;
        int[][] Demo = new int[noOfEggs+1][noOfFloor+1];

        // one engg
        for(int j=1; j<=noOfFloor; j++){
            Demo[1][j] = j;
        }
        // k is no. of eggs (incrementing)
        for(int k=2; k<=noOfEggs; k++) {
            // J is no. of floor (incrementing)
            for (int j = 1; j <= noOfFloor; j++) {
                int min = Integer.MAX_VALUE;
                for (int i = 1; i <= j; i++) {
                    min = Math.min(min, (1 + Math.max(Demo[k - 1][i - 1], Demo[k][j - i])));
                }
                Demo[k][j] = min;
            }
        }

        return Demo[noOfEggs][noOfFloor];
    }

    public static void main(String[] args){
        System.out.println(eggSolution(2,100));

        System.out.println(eggSolution(3,100));
    }

}
