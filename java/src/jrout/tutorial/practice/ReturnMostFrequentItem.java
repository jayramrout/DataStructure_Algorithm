package jrout.tutorial.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of integers, return the most frequent item in the list.
 */
public class ReturnMostFrequentItem {
    public static void main(String[] args) {
        int listOfIntegers[] = {1, 2, 3, 3, 4, 5, 5, 7, 7, 7, 7};
        int maxValue = frequentItems(listOfIntegers);
        System.out.println("maxValue = " + maxValue);
    }

    public static int frequentItems(int [] listOfIntegers) {
        Arrays.sort(listOfIntegers);
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : listOfIntegers) {
            Integer val = freqMap.get(i);
            freqMap.put(i, val == null ? 1 : val +1);
        }

        int maxFreq = -1;
        int maxKey = -1;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(entry.getValue() > maxFreq){
                maxFreq = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }
}
