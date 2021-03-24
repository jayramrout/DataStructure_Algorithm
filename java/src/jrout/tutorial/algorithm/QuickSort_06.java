package jrout.tutorial.algorithm;

import static jrout.tutorial.algorithm.Util.print;
import static jrout.tutorial.algorithm.Util.swap;

/**
 * Its based on PIVOT
 * Divide and Conquer using recursion
 *
 * Time Complexity : O(n log n)
 * Stable Sort : NO
 * Space Complexity : O(log n)
 * Adaptive : NO
 */
public class QuickSort_06 {
    private static int listToSort[] = new int[] {4, 5, 8, 2, 1, 17, 10, 3, 88, 9, 3};

    public static void main(String[] args) {
        print(listToSort);
        quickSort(listToSort, 0, listToSort.length - 1);
    }

    public static void quickSort(int[] listToSort, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(listToSort, low, high);
        quickSort(listToSort, low, pivotIndex - 1);
        quickSort(listToSort, pivotIndex + 1, high);
    }

    public static int partition(int[] listToSort, int low, int high) {
        int pivot = listToSort[low];
        int l = low;
        int h = high;
        while (l < h) {
            while (listToSort[l] <= pivot && l < h) {
                l++;
            }
            while (listToSort[h] > pivot) {
                h--;
            }
            if (l < h) {
                swap(listToSort, l, h);
            }
        }
        swap(listToSort, low, h);

        System.out.println("Pivot: " + pivot);
        print(listToSort);
        return h;
    }

}
