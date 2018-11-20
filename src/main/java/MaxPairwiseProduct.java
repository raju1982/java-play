
import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class MaxPairwiseProduct {

    public static BigInteger getMaxPairwiseProduct(int[] input) {
        int max = input[0];
        int maxIndex = 0;
        for (int i = 1; i < input.length; i++) {
            max = Math.max(max, input[i]);
            if (max == input[i]) {
                maxIndex = i;
            }
        }
        int secondMax;
        if(maxIndex == 0){
            secondMax = input[1];
        }
        else{
            secondMax = input[0];
        }

        for (int i = 1; i < input.length; i++) {
            if (i == maxIndex) {
                continue;
            }
            secondMax = Math.max(secondMax, input[i]);
        }
        BigInteger answer = BigInteger.valueOf(Long.valueOf(max) * Long.valueOf(secondMax));
        return answer;
    }


    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            } }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                } }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}