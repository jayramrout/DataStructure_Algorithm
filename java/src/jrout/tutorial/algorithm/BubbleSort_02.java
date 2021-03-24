package jrout.tutorial.algorithm;

import static jrout.tutorial.algorithm.Util.print;
import static jrout.tutorial.algorithm.Util.swap;

/**
 *
 * Compare adjacent elements
 * Time Complexity : O(n^2)
 * Stable Sort : YES
 * Space Complexity : O(1)
 * Adaptive : YES
 */
public class BubbleSort_02 {
    private static int listToSort[] = new int[] {4, 5, 8, 2, 1, 17, 10, 3, 88, 9, 3};

    public static void main(String[] args) {
        print(listToSort);
        bubbleSort(listToSort);
    }

    private static void bubbleSort(int[] listToSort) {
        for (int i = 0; i < listToSort.length; i++) {
            boolean swapped = false;
            for (int j = listToSort.length - 1; j > i; j--) {
                if (listToSort[j] < listToSort[j - 1]) {
                    swap(listToSort, j, j - 1);
                    swapped = true;
                }
            }
            print(listToSort);
            if (!swapped) {
                break; // ADAPTIVE : You can break it here.
            }
        }
    }


}
