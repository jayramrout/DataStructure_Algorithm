package jrout.tutorial.algorithm;

import static jrout.tutorial.algorithm.Util.print;
import static jrout.tutorial.algorithm.Util.swap;

/**
 * Time Complexity : O(n^2)
 * Stable Sort : NO
 * Space Complexity : O(1)
 * Adaptive : NO
 */
public class SelectionSort_01 {
    private static int listToSort[] = new int[] {4, 5, 8, 2, 1, 17, 10, 3, 88, 9, 3};

    public static void main(String[] args) {
        print(listToSort);
        selectionSort(listToSort);
    }

    public static void selectionSort(int[] listToSort) {
        for (int i = 0; i < listToSort.length; i++) {
            for (int j = i + 1; j < listToSort.length; j++) {
                if (listToSort[i] > listToSort[j]) {
                    swap(listToSort, i, j);
                }
            }
            print(listToSort);
        }
    }
}
