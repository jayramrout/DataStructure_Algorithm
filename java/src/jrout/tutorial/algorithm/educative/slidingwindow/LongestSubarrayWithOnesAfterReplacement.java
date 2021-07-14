package jrout.tutorial.algorithm.educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace
 * no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
 *
 * Example 1:
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 *
 * Example 2:
 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
 */
public class LongestSubarrayWithOnesAfterReplacement {
    public static void main(String[] args) {
//        int length = findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2); // 6
        int length = findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3); // 9
        System.out.println(length);
    }

    public static int findLength(int []a, int k) {
        int maxLength = 0, winStart = 0;
        int maxOnesCount = 0;
        for (int winEnd = 0; winEnd < a.length; winEnd++) {
            if(a[winEnd] == 1)
                maxOnesCount++;
            int winSize = winSize(winStart, winEnd);
            if (winSize - maxOnesCount > k) {
                if (a[winStart] == 1) {
                    maxOnesCount--;
                }
                winStart++;
            }
            winSize = winSize(winStart, winEnd);
            maxLength = Math.max(maxLength, winSize);
        }

        return maxLength;
    }
    public static int winSize(int winStart, int winEnd) {
        return winEnd - winStart +1;
    }
}
