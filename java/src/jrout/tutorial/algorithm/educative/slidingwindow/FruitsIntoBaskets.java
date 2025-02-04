package jrout.tutorial.algorithm.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of characters where each character represents a fruit tree,
you are given two baskets, and your goal is to put maximum number of fruits in each basket.
The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but you can’t skip a tree once you have started.
You will pick one fruit from each tree until you cannot,
i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both baskets.

Example 1:
Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

Example 2:
Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */
public class FruitsIntoBaskets {
    public static void main(String[] args) {
//        char fruits[] = {'A', 'B', 'C', 'A', 'C'};
        char fruits[] = {'A', 'B', 'C', 'B', 'B', 'C'};
        int length = findLength(fruits);
        System.out.println("Length = "+length);
    }

    public static int findLength(char[] arr) {
        int k = 2 ;
        Map<Character, Integer> charMap = new HashMap<>();
        int winStart = 0;
        for (int winEnd = 0; winEnd < arr.length; winEnd++) {
            charMap.put(arr[winEnd], charMap.getOrDefault(arr[winEnd], 0) + 1);
            while (charMap.size() > k) {
                charMap.remove(arr[winStart]);
                winStart++;
            }
        }
        return charMap.values().stream().mapToInt(Integer::intValue).sum();
    }
}
