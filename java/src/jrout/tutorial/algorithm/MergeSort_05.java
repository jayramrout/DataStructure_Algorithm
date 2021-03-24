package jrout.tutorial.algorithm;

import static jrout.tutorial.algorithm.Util.print;
import static jrout.tutorial.algorithm.Util.swap;

/**
 * Divide and Conquer using recursion
 *
 * Time Complexity : O(n^2)
 * Stable Sort : YES
 * Space Complexity : O(1)
 * Adaptive : YES
 */
public class MergeSort_05 {
    private static int listToSort[] = new int[] {4, 5, 8, 2, 1, 17, 10, 3, 88, 9, 3};

    public static void main(String[] args) {
        print(listToSort);
        mergeSort(listToSort);
    }

    private static void mergeSort(int[] listToSort) {

    }


}
