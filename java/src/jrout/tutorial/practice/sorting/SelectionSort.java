package jrout.tutorial.practice.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int ages[] = {3,4,6,1,8,9,10};
        selectionSort(ages);
        printArray(ages);
    }

    public static void selectionSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            int lowestIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[lowestIndex] > array[j]) {
                    lowestIndex = j;
                }
            }
            if (lowestIndex != i) {
                swap(array,i,lowestIndex);
            }
        }
    }

    static void printArray(int array[]) {
        for (int i : array) {
            System.out.print(i+" ");
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
