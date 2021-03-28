package jrout.tutorial.practice;

import java.util.Arrays;
import java.util.List;

/**
 * Input: number = [[1,2,3],[3,2,1]]
 * Output: 6
 * Input: number = [[1,5],[7,3],[3,5]]
 * Output: 10
 */
public class MaxSumOfInnerArray {
    public static void main(String[] args) {
        int [][] _2DArray = {{1,2,3},{3,2,2}};
        int maxValue = 0;
        for (int _1DArray[] : _2DArray) {
            int sum = 0;
            for (int num : _1DArray) {
                sum +=num;
            }
            if(sum > maxValue)
                maxValue = sum;
        }

        System.out.println("Max value "+ maxValue);
    }
}
