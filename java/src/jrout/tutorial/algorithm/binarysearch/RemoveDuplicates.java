package jrout.tutorial.algorithm.binarysearch;

/*
Given an array of sorted numbers, remove all duplicates from it.
You should not use any extra space; after removing the duplicates in-place return the length of the subarray that has no duplicate in it.

Example 1:
Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].

Example 2:
Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
/*
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
*/
        int uniqueNumbers = remove_edu(new int[]{3, 2, 3, 6, 3, 10, 9, 3}, 3);
//        int uniqueNumbers = remove(new int[]{2, 11, 2, 2, 1}, 2);
        System.out.println("uniqueNumbers = " + uniqueNumbers);

    }

    public static int remove(int[] arr) {
        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[index - 1] != arr[i]) {
                arr[index] = arr[i];
                index++;
            }
        }
        return index;
    }

    /*
        Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
        Example 1:
        Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
        Output: 4
        Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].

        Example 2:
        Input: [2, 11, 2, 2, 1], Key=2
        Output: 2
        Explanation: The first two elements after removing every 'Key' will be [11, 1].
     */
    public static int remove_jay(int[] arr, int key) {
        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == key) {
                arr[i - 1] = arr[i];
            } else {
                index++;
            }
        }
        return index;
    }
    //Input: [2, 11, 2, 2, 1], Key=2
    public static int remove_edu(int[] arr, int key) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[index] = arr[i];
                index++;
            }
        }
        return index;
    }
}
