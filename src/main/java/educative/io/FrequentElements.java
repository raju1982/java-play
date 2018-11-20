package educative.io;

import java.util.*;

public class FrequentElements {

    //o(n) solution
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        //size of array of array of arraylist is equal to array size.
        List<Integer>[] bucket = new List[nums.length + 1];
        List<Integer> res = new ArrayList<>();

        //store count of each number in a hash map  <number, count>
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer>  tmp : hm.entrySet()){
            System.out.println("tmp.getKey() " + tmp.getKey() + ", tmp.getValue() " + tmp.getValue());
        }

        //array of arraylist -> arrayList has the numbers
        for(int key: hm.keySet()){
            int frequency = hm.get(key);
            System.out.println("key " + key + " frequency " + frequency);
            if(bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        //parse bucket [array of arraylist] from end.
        for(int pos = bucket.length-1; pos >= 0; pos--){
            if(bucket[pos] != null){
                //add k element from the max index
                for(int i = 0; i < bucket[pos].size() && res.size() < k; i++)
                    res.add(bucket[pos].get(i));
            }
        }
        return res;
    }


    final static class WordFreq implements Comparable<WordFreq> {
        String word;
        int freq;

        public WordFreq(final String w, final int c) {
            word = w;
            freq = c;
        }

        @Override
        public int compareTo(final WordFreq other) {
            return Integer.compare(this.freq, other.freq);
        }
    }

    public static String[] topKWords(final String stream, final int k) {
        final Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
        final PriorityQueue<WordFreq> minHeapFortopKHeap = new PriorityQueue<WordFreq>(k);

        final String[] words = stream.toLowerCase().trim().split(" ");

        //store count of each string in a hash map  <string, count>
        for (final String word : words) {
            int freq = 1;
            if (frequencyMap.containsKey(word)) {
                freq = frequencyMap.get(word) + 1;
            }

            // update the frequency map
            frequencyMap.put(word, freq);
        }

        // Build MinHeap to get topK
        for (final Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (minHeapFortopKHeap.size() < k) {
                minHeapFortopKHeap.add(new WordFreq(entry.getKey(), entry.getValue()));
            } else if (entry.getValue() > minHeapFortopKHeap.peek().freq) {
                minHeapFortopKHeap.remove();
                minHeapFortopKHeap.add(new WordFreq(entry.getKey(), entry.getValue()));
            }
        }

        // extract the top K
        final String[] topK = new String[k];
        int i = 0;
        while (minHeapFortopKHeap.size() > 0) {
            topK[i++] = minHeapFortopKHeap.remove().word;
        }

        return topK;
    }


    public static void main(String[] args){

        for(int tmp : topKFrequent(new int[] {1,1,1,2,2,2,3,3,3},  2)){
            System.out.println(tmp);
        }

        System.out.println(Arrays.toString(topKWords("dd ee ff dd aa bb ff dd cc eee", 3)));
    }

}
