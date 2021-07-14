package jrout.tutorial.practice;
/*
Given a sorted array of integers containing duplicates,
write a program which returns the last index of an element.
Example:
Input:
array = {0, 1, 2, 2, 4, 5, 5, 5, 8};
num = 5;
Output:
Element 5 found at index 7
 */
public class LastIndexOfSortedArray {
    public static void main(String[] args) {
//        int array[] = {0, 1, 2, 2, 4, 5, 5, 5, 5,5,5,5,5,5,5,5,5,5,5,58};
        int array[] = {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
//        int array[] = {1,2,3,5,5,7,8,9};
        int i = searchLastIndex(array, 5);
        System.out.println("Index at "+ i);
    }

    public static int searchLastIndex(int array[], int number) {
        if (array.length == 0)
            return -1;
        int min = 0;
        int max = array.length - 1;
        int finalIndex = 0;
        int iteration = 1;
        while (min <= max) {
            System.out.println(iteration++);
            int mid = min + (max - min)/2;

            if(array[mid] == number)
                finalIndex = mid;
//                return mid;

            if(array[mid] > number)
                max = mid - 1;
            else
                min = mid + 1;
        }


        return finalIndex;
    }
}
