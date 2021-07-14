package jrout.tutorial.algorithm.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Permutation in a String (hard) #
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 *
 * Permutation is defined as the re-arranging of the characters of the string.
 * For example, “abc” has the following six permutations:
 *
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * If a string has ‘n’ distinct characters, it will have n!n! permutations.
 *
 * Example 1:
 *
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 *
 *  Example 2:
 * Input: String="odicf", Pattern="dc"
 * Output: false
 * Explanation: No permutation of the pattern is present in the given string as a substring.
 *
 * Example 3:
 * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
 * Output: true
 * Explanation: Both the string and the pattern are a permutation of each other.
 *
 * Example 4:
 * Input: String="aaacb", Pattern="abc"
 * Output: true
 * Explanation: The string contains "acb" which is a permutation of the given pattern.
 */
public class PermutationInAString {
    public static void main(String[] args) {
//        System.out.println(hasPermutation("aaacb","abc"));
//        System.out.println(hasPermutation("bcdxabcdy","bcdyabcdx"));
        System.out.println(hasPermutation("odicf","dc"));
    }

    public static boolean hasPermutation(String str , String pattern) {
        boolean hasPermutation = false;
        Map<Character, Integer> patMap = new HashMap<>();
        for (int i = 0; i < pattern.toCharArray().length; i++) {
            patMap.put(pattern.charAt(i), patMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        Map<Character, Integer> inputMap = new HashMap<>();
        int winStart = 0;
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            inputMap.put(str.charAt(winEnd),inputMap.getOrDefault(str.charAt(winEnd),0)+1);
            int winSize = winSize(winStart, winEnd);
            if (winSize == pattern.length()) {
                Set<Map.Entry<Character, Integer>> entries = patMap.entrySet();
                hasPermutation = true;
                inLoop: for (Map.Entry mapEntry : entries) {
                    if (mapEntry.getValue() != inputMap.get(mapEntry.getKey())) {
                        hasPermutation = false;
                        break inLoop;
                    }
                }
                if(hasPermutation)
                    return true;
                inputMap.put(str.charAt(winStart),inputMap.getOrDefault(str.charAt(winStart),0)-1);
                if (inputMap.get(str.charAt(winStart)) == 0) {
                    inputMap.remove(str.charAt(winStart));
                }
                winStart++;
            }
        }

        return hasPermutation;
    }

    /**
     * Educative version
     * @param str
     * @param pattern
     * @return
     */
    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> patCharFreqMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            patCharFreqMap.put(chr, patCharFreqMap.getOrDefault(chr, 0) + 1);

        // our goal is to match all the characters from the 'patCharFreqMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (patCharFreqMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                patCharFreqMap.put(rightChar, patCharFreqMap.get(rightChar) - 1);
                if (patCharFreqMap.get(rightChar) == 0) // character is completely matched
                    matched++;
            }

            if (matched == patCharFreqMap.size())
                return true;

            if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
                char leftChar = str.charAt(windowStart++);
                if (patCharFreqMap.containsKey(leftChar)) {
                    if (patCharFreqMap.get(leftChar) == 0)
                        matched--; // before putting the character back, decrement the matched count
                    // put the character back for matching
                    patCharFreqMap.put(leftChar, patCharFreqMap.get(leftChar) + 1);
                }
            }
        }

        return false;
    }

    public static int winSize(int winStart, int winEnd) {
        return winEnd - winStart +1;
    }
}
