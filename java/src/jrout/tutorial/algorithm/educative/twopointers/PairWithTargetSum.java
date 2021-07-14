package jrout.tutorial.algorithm.educative.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 *
 * Example 1:
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 *
 * Example 2:
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class PairWithTargetSum {
    public static void main(String[] args) {
//        System.out.println(getPairIndex(new int[]{1,2,3,4,6},6));
//        System.out.println(getPairIndex(new int[]{2,5,9,11},11));

        int[] search = search(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println(search[0]+","+search[1]);
    }

    /*
        brute force approach
     */
    public static List<String> getPairIndex_brute_force(int array[], int target) {
        List<String> pairStringList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    pairStringList.add("("+i+","+j+")");
                }
            }
        }
        return pairStringList;
    }
    /*
     [1, 2, 3, 4, 6], target=6
     */
    public static List<String> getPairIndex(int array[], int target) {
        List<String> pairStringList = new ArrayList<>();
        int leftIndex = 0, rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            int sum = array[leftIndex] + array[rightIndex];
            if (sum == target ) {
                pairStringList.add("("+leftIndex+","+rightIndex+")");
                return pairStringList;
            } else if (sum > target) {
                rightIndex--;
            } else if (sum < target) {
                leftIndex++;
            }
        }

        return pairStringList;
    }

    public static int[] search(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>(); // to store numbers and their indices
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i]))
                return new int[] { nums.get(targetSum - arr[i]), i };
            else
                nums.put(arr[i], i); // put the number and its index in the map
        }
        return new int[] { -1, -1 }; // pair not found
    }

    public static List<String> getPairIndex_bk(int array[], int target) {
        List<String> pairStringList = new ArrayList<>();
        for (int leftIndex = 0, rightIndex = array.length-1; leftIndex < array.length; leftIndex++) {
            int sum = array[leftIndex] + array[rightIndex];

            if (sum == target ) {
                pairStringList.add("("+leftIndex+","+rightIndex+")");
                return pairStringList;
            } else if (sum > target) {
                rightIndex--;
            } else if (sum < target) {
                continue;
            }

        }

        return pairStringList;
    }

}
