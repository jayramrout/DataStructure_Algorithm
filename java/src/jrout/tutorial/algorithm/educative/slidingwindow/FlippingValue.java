package jrout.tutorial.algorithm.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
Given a string, find the length of the longest substring in it with no more than K distinct characters.

You can assume that K is less than or equal to the length of the given string.

Example 1:
Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".

Example 2:
Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".

Example 3:
Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

 */
public class FlippingValue {
    public static void main(String[] args) {
        String str = "araaci";
        int K = 2;
        int i = longestSubStringWithKDistChars(str, K);
        System.out.println("Size ="+i);
    }

    public static int longestSubStringWithKDistChars(String str, int K) {
        if (str.length() == 0) {
            return 0;
        }
        Map<Character,Integer> charMap = new HashMap<>();
        int maxSize = Integer.MIN_VALUE;
        int winStart = 0;
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            char c1 = str.charAt(winEnd);
            charMap.put(c1,charMap.getOrDefault(c1,0)+1);
            while (charMap.size() > K) {
                char c2 = str.charAt(winStart);
                charMap.put(c2, charMap.get(c2) - 1);
                if (charMap.get(c2) == 0) {
                    charMap.remove(c2);
                }
                winStart++;
            }
            maxSize = Math.max(winEnd-winStart+1, maxSize);
        }
        return maxSize;
    }



}
