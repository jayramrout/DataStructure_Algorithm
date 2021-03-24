package jrout.tutorial.algorithm;

import static jrout.tutorial.algorithm.Util.print;
import static jrout.tutorial.algorithm.Util.swap;

/**
 * ShellSort uses Insertion Sort internally.
 *
 * Compare adjacent elements
 * Time Complexity : between o(n) to O(n^2)
 * Stable Sort : YES
 * Space Complexity : O(1)
 * Adaptive : YES
 */
public class ShellSort_04 {
    private static int listToSort[] = new int[] {4, 5, 8, 2, 1, 17, 10, 3, 88, 9, 3};

    public static void main(String[] args) {
        print(listToSort);
        shellSort(listToSort);
    }

    public static void insertionSort(int[] listToSort, int startIndex, int increment) {
        for (int i = startIndex; i < listToSort.length; i = i + increment) {
            int min = Math.min(i + increment, listToSort.length - 1);
            for (int j = min; j - increment >= 0; j = j - increment) {
                if (listToSort[j] < listToSort[j - increment]) {
                    swap(listToSort, j, j - increment);
                } else {
                    break;
                }
                print(listToSort);
            }
        }
    }

    public static void shellSort(int[] listToSort) {
        int increment = listToSort.length / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSort(listToSort, startIndex, increment);
            }
            increment = increment / 2;
        }
    }
}
