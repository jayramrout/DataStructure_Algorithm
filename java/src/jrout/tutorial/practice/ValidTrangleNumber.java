package jrout.tutorial.practice;

import java.util.Arrays;

/**
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 */
public class ValidTrangleNumber {
    public static void main(String[] args) {
        Integer triangleArray[] = {3, 7, 8, 8, 10, 11};
        int totalTriangleCount = triangleNumber_2(triangleArray);
        System.out.println("totalTriangleCount = " + totalTriangleCount);
    }

    public static int triangleNumber_1(Integer[] triangleArray) {
        int totalTriangleCount = 0;
        for (int i = 0; i < triangleArray.length; i++) {
            for (int j = i+1; j < triangleArray.length - 1; j++) {
                kpointer:for (int k = j+1; k < triangleArray.length; k++) {
                    if (triangleArray[i] + triangleArray[j] > triangleArray[k] &&
                            triangleArray[i] + triangleArray[k] > triangleArray[j] &&
                            triangleArray[j] + triangleArray[k] > triangleArray[i]) {
                        totalTriangleCount += 1;
                    }
                }
            }
        }
        return totalTriangleCount;
    }

    static int binarySearch(Integer nums[], int l, int r, int x) {
        while (r >= l && r < nums.length) {
            int mid = (l + r) / 2;
            if (nums[mid] >= x)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    public static int triangleNumber_2(Integer[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }

}
