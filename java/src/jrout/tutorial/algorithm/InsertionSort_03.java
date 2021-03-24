package jrout.tutorial.algorithm;

import static jrout.tutorial.algorithm.Util.print;
import static jrout.tutorial.algorithm.Util.swap;

/**
 * Start with a sorted sublist of size 1
 * Compare adjacent elements
 * Time Complexity : O(n^2)
 * Stable Sort : YES
 * Space Complexity : O(1)
 * Adaptive : YES
 */
public class InsertionSort_03 {
    private static int listToSort[] = new int[] {4, 5, 8, 2, 1, 17, 10, 3, 88, 9, 3};

    public static void main(String[] args) {
        print(listToSort);
        insertionSort(listToSort);
    }

    private static void insertionSort(int[] listToSort) {
        for (int i = 0; i < listToSort.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (listToSort[j] < listToSort[j-1]) {
                    swap(listToSort, j, j - 1);
                } else {
                    break;
                }
                print(listToSort);
            }
        }
    }


}
