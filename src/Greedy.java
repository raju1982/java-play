import java.util.Arrays;

/**
 * The greedy approach is only optimal if the problem has "optimal substructure,"
 * which means stitching together optimal solutions to subproblems yields an optimal solution.
 *
 *
 */
public class Greedy {

    //Problem: Write an efficient function that takes stockPricesYesterday and returns the best profit
    // I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.

   //n+(n−1)+(n−2)...+2+1 ↴ , which is still O(n^2) time.
    static int getMaxProfit(int[] stockPricesYesterday){
        int maxProfit = 0;
        for(int earlierTime=0; earlierTime<stockPricesYesterday.length-1; earlierTime++){
            int earlierPrice = stockPricesYesterday[earlierTime];
            for(int laterTime=earlierTime+1; laterTime<stockPricesYesterday.length; laterTime++){
                int tmp = stockPricesYesterday[laterTime]-earlierPrice;
                if (tmp > maxProfit || (earlierTime==0 && laterTime==1)) {
                    maxProfit = tmp;
                }
            }
        }
        return maxProfit;
    }

    //O(n) time, 0(1) space
    static int optimized_getMaxProfit(int[] stockPricesYesterday){
        // make sure we have at least 2 prices
        if (stockPricesYesterday.length < 2) {
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }
        int minPrice = stockPricesYesterday[0];
        int maxProfit = stockPricesYesterday[1] - minPrice;
        for(int i=1; i<stockPricesYesterday.length; i++){
            int currentPrice = stockPricesYesterday[i];
            int tmp = currentPrice - minPrice;
            if (tmp > maxProfit || i==1) {
                maxProfit = tmp;
            }
            if(currentPrice<minPrice) {
                minPrice = currentPrice;
            }
        }
        return maxProfit;
    }









    //Problem: You have an array of integers, and for each index you want to find the product of every integer
    // except the integer at that index.
    static int[] getProductsOfAllIntsExceptAtIndex(int[] products){
        int[] result = new int[products.length];
        for(int i=0; i<products.length; i++){
            int tmp = 1;
            for(int j=0; j<products.length; j++){
                if (j==i){
                    continue;
                }
                tmp = tmp * products[j];
            }
            result[i] = tmp;
        }
        return result;
    }

    public static long factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n-1);
    }

    //O(n) time, 0(n) space
    static int[] optimized_getProductsOfAllIntsExceptAtIndex(int[] products){
        if(products.length < 2){
            throw new IllegalArgumentException("array should have at least two element.");
        }
        System.out.println(Arrays.toString(products));
        //before index
        int[] productsOfAllIntsBeforeIndex = new int[products.length];
        int productSoFar=1;
        for(int i=0; i < products.length; i++){
            productsOfAllIntsBeforeIndex[i]=productSoFar;
            productSoFar=productSoFar*products[i];
        }
        System.out.println(Arrays.toString(productsOfAllIntsBeforeIndex));
        //after index
        productSoFar=1;
        for(int i=products.length-1 ; i >= 0; i--){
            productsOfAllIntsBeforeIndex[i]=productsOfAllIntsBeforeIndex[i] * productSoFar;
            productSoFar=productSoFar*products[i];
        }
        System.out.println(Arrays.toString(productsOfAllIntsBeforeIndex));
        return productsOfAllIntsBeforeIndex;
    }







    //Problem: Given an array of integers, find the highest product you can get from three of the integers.
    //We can do this in O(n) time and O(1) space.
    public static int highestProductOf3(int[] arrayOfInts) {
        if (arrayOfInts.length < 3) {
            throw new IllegalArgumentException("Less than 3 items!");
        }

        // We're going to start at the 3rd item (at index 2)
        // so pre-populate highests and lowests based on the first 2 items.
        // we could also start these as null and check below if they're set
        // but this is arguably cleaner
        int highest = Math.max(arrayOfInts[0], arrayOfInts[1]);
        int lowest  = Math.min(arrayOfInts[0], arrayOfInts[1]);

        int highestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
        int lowestProductOf2  = arrayOfInts[0] * arrayOfInts[1];

        // except this one--we pre-populate it for the first *3* items.
        // this means in our first pass it'll check against itself, which is fine.
        int highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];

        // walk through items, starting at index 2
        for (int i = 2; i < arrayOfInts.length; i++) {
            int current = arrayOfInts[i];

            // do we have a new highest product of 3?
            // it's either the current highest,
            // or the current times the highest product of two
            // or the current times the lowest product of two
            highestProductOf3 = Math.max(Math.max(
                    highestProductOf3,
                    current * highestProductOf2),
                    current * lowestProductOf2);

            // do we have a new highest product of two?
            highestProductOf2 = Math.max(Math.max(
                    highestProductOf2,
                    current * highest),
                    current * lowest);

            // do we have a new lowest product of two?
            lowestProductOf2 = Math.min(Math.min(
                    lowestProductOf2,
                    current * highest),
                    current * lowest);

            // do we have a new highest?
            highest = Math.max(highest, current);

            // do we have a new lowest?
            lowest = Math.min(lowest, current);
        }
        return highestProductOf3;
    }




    public static void main(StringQuiz[] args){
        int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};
        System.out.println(getMaxProfit(stockPricesYesterday));
        System.out.println(optimized_getMaxProfit(stockPricesYesterday));
        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(stockPricesYesterday)));
        optimized_getProductsOfAllIntsExceptAtIndex(stockPricesYesterday);
        optimized_getProductsOfAllIntsExceptAtIndex(new int[]{10,0,2});
        //System.out.println(Arrays.toString(optimized_getProductsOfAllIntsExceptAtIndex(stockPricesYesterday)));

        stockPricesYesterday = new int[]{10, 3, 5, 8, 11, 5};
        System.out.println(getMaxProfit(stockPricesYesterday));
        System.out.println(optimized_getMaxProfit(stockPricesYesterday));

        stockPricesYesterday = new int[]{10, 5, 4, 3, 2, 1};
        System.out.println(getMaxProfit(stockPricesYesterday));
        System.out.println(optimized_getMaxProfit(stockPricesYesterday));


        System.out.println(Greedy.highestProductOf3(new int[]{1, 10, -5, 1, -100}));

    }
}
