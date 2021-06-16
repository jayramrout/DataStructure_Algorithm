package jrout.tutorial.practice.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int ages[] = {3,4,6,1,8,9,10};
        insertionSort(ages);
        printArray(ages);
    }

    public static void insertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int position = i;
            int tempValue = array[i];
            while (position > 0 && array[position - 1] > tempValue) {
                array[position] = array[position-1];
                position--;
            }
            array[position] = tempValue;
        }
    }

    static void printArray(int array[]) {
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println("");
    }
}
