import java.util.*;
import java.io.*;

public class AlgoTmp {

    public static int getMaxPairwiseProduct(int[] input) {
        int max = input[0];
        int maxIndex = 0;
        for (int i = 1; i < input.length; i++) {
            max = Math.max(max, input[i]);
            if (max == input[i]) {
                maxIndex = i;
            }
        }

        int secondMax = input[0];
        for (int i = 1; i < input.length; i++) {
            if (i == maxIndex) {
                continue;
            }
            secondMax = Math.max(secondMax, input[i]);
        }

        return max * secondMax;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        //int[] data = new int[tokenizer.countTokens()];
        int[] data = new int[Integer.valueOf(tokenizer.nextToken())];
        for(int i=0; i<data.length && tokenizer.hasMoreTokens(); i++){
            data[i] = Integer.valueOf(tokenizer.nextToken());
        }
        System.out.println(getMaxPairwiseProduct(data));
    }


}
