package jrout.tutorial.practice.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int ages[] = {3,4,6,1,8,9,10};
        bubbleSort(ages);
        printArray(ages);
    }

    static void printArray(int array[]) {
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
    public static void bubbleSort(int array[]) {
        int unsortedIndex = array.length - 1;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < unsortedIndex; i++) {
                if (array[i] > array[i + 1]) {
                    sorted = false;
                    swap(array, i, i + 1);
                }
            }
            unsortedIndex--;
        }
    }

    public static void swap(int array[], int index1, int index2) {
        if(index1 == index2)
            return;
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
