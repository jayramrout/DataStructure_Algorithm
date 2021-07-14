package jrout.tutorial.algorithm.educative.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a string, find the length of the longest substring, which has no repeating characters.
Example 1:
Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".

Example 2:
Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".

Example 3:
Input: String="abccde"
Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".
*/
public class NoRepeatingSubstring {
    public static void main(String[] args) {
//        String str ="aabccbb";
//        String str ="abcadbe";
        String str ="abcdefgadbezxycqle";
        int i = findLength(str);
        System.out.println("Length = "+i);
    }

// abcadbe -- abccde
    public static int noRepeatingCharLength(String str) {
        char[] chars = str.toCharArray();
        int maxLength = Integer.MIN_VALUE;
        int winStart = 0;
        Map<Character,Integer> charMap = new HashMap<>();
        for (int winEnd = 0; winEnd < chars.length; winEnd++) {
            charMap.put(chars[winEnd],charMap.getOrDefault(chars[winEnd],0)+1);
            if (charMap.get(chars[winEnd]) > 1) {
                charMap.put(chars[winEnd],charMap.get(chars[winEnd])-1);
                winStart++;
            }
            maxLength = Math.max(winEnd - winStart + 1, maxLength);
        }
        return maxLength;
    }

    public static int findLength(String str) {
        int windowStart = 0, windowEnd = 0, maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        while (windowEnd < str.length()) {
            if (!charSet.contains(str.charAt(windowEnd))) {
                charSet.add(str.charAt(windowEnd));
                windowEnd++;
                maxLength = Math.max(maxLength, charSet.size());
            } else {
                charSet.remove(str.charAt(windowStart));
                windowStart++;
            }
        }

        return maxLength;
    }

    public static int findLength_bk(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }
}
