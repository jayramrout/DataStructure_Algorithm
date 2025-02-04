package jrout.tutorial.algorithm.educative.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * String Anagrams (hard) #
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 *
 * Every anagram is a permutation of a string. As we know, when we are not allowed
 * to repeat characters while finding permutations of a string, we get N!N! permutations
 * (or anagrams) of a string having NN characters.
 * For example, here are the six anagrams of the string “abc”:
 *
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * Write a function to return a list of starting indices of the anagrams of the pattern
 * in the given string.
 *
 * Example 1:
 *
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 * Example 2:
 *
 * Input: String="abbcabc", Pattern="abc"
 * Output: [2, 3, 4]
 * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */
public class StringAnagrams {
    public static void main(String[] args) {
        findStringAnagrams("ppqp","pq");
    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        Map<Character, Integer> patCharFreqMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            patCharFreqMap.put(chr, patCharFreqMap.getOrDefault(chr, 0) + 1);

        for (int winEnd = 0; winEnd < str.length(); winEnd++) {

        }
        return resultIndices;
    }
}
