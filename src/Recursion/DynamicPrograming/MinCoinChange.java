package Recursion.DynamicPrograming;

//if coin value is less than amount, solution is 1 + best solution for (amount-coin value)
public class MinCoinChange {

    public static int minCoinSolution(int finalAmount, int[] coinList){
        //best solution (min coin)
        int[] cache = new int[finalAmount+1];
        cache[0] = 0;
        //solution for each amount (1 to finalAmount)
        int[] solutions =  new int[coinList.length];

        for(int amount=1; amount<=finalAmount; amount++){
            //reset the solution array
            for(int j=0; j<solutions.length; j++){
                solutions[j] = 0;
            }
            //load all solutions
            for(int j=0; j<coinList.length; j++){
                //if coin value is less than amount, solution is 1 + best solution for (amount-coin value)
                if(coinList[j] <= amount){
                    solutions[j] = 1 + cache[amount-coinList[j]];
                }
            }
            //update cache with best solution (min coin)
            for(int j=0; j<solutions.length && solutions[j] > 0; j++){
                if(cache[amount] == 0){
                    cache[amount] = solutions[j];
                }
                else{
                    cache[amount] = Math.min(cache[amount], solutions[j]);
                }
            }
        }
        return cache[finalAmount];
    }

    public static void main(String[] args){
        System.out.println(minCoinSolution(63, new int[]{1,5,10,25}));
    }

}