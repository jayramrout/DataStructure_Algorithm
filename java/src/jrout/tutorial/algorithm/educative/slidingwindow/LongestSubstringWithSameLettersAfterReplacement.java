package jrout.tutorial.algorithm.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 *
 * Example 1:
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 *
 * Example 2:
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 *
 * Example 3:
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class LongestSubstringWithSameLettersAfterReplacement {
    public static void main(String[] args) {
        String str = "aabccbb";
//        int lenghtAfterReplace = findLenghtAfterReplace("aabccbb", 2);
        int lenghtAfterReplace = findLenghtAfterReplace("abbcb", 1);
        System.out.println(lenghtAfterReplace);

    }

    public static int findLenghtAfterReplace(String str, int k) {
        int maxLength = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int maxRepeatLetterCount = 0,winStart = 0 ,winEnd = 0; winEnd < str.length(); winEnd++) {
            char rChar = str.charAt(winEnd);
            freqMap.put(rChar,freqMap.getOrDefault(rChar,0)+1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount,freqMap.get(rChar));
            if (winSize(winStart,winEnd) - maxRepeatLetterCount > k) {
                char lChar = str.charAt(winStart);
                freqMap.put(lChar,freqMap.get(lChar)-1);
                winStart++;
            }
            maxLength = Math.max(maxLength,winSize(winStart,winEnd));
        }
        return maxLength;
    }

    public static int winSize(int winStart, int winEnd) {
        return winEnd - winStart +1;
    }
}
