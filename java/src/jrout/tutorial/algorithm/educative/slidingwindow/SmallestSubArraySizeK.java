package jrout.tutorial.algorithm.educative.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the
 * smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0 if no such subarray exists.
 * Eg:
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 *
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 *
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1]
 * or [1, 1, 6].
 *
 */
public class SmallestSubArraySizeK {
    public static void main(String[] args) {
        int arr[] = {2,1,5,2,3,2};
        int i = smallestSubArraySize(arr, 7);
        System.out.println("Smallest sub array size =" + i);
    }

    public static int smallestSubArraySize(int arr[], int s) {
        int winSum = 0;
        int minLength = Integer.MAX_VALUE;
        int winStart = 0;
        for (int winEnd = 0; winEnd < arr.length; winEnd++) {
            winSum += arr[winEnd];
            while (winSum >= s) {
                minLength = Math.min(minLength, winEnd - winStart + 1);
                winSum -= arr[winStart];
                winStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0: minLength;
    }
}
