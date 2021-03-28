package jrout.tutorial.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *Input: candyType = [1,1,2,2,3,3]
 * Output: 3
 * Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.
 * Example 2:
 *
 * Input: candyType = [1,1,2,3]
 * Output: 2
 * Explanation: Alice can only eat 4 / 2 = 2 candies. Whether she eats types [1,2], [1,3], or [2,3], she still can only eat 2 different types.
 * Example 3:
 *
 * Input: candyType = [6,6,6,6]
 * Output: 1
 * Explanation: Alice can only eat 4 / 2 = 2 candies. Even though she can eat 2 candies, she only has 1 type.
 *
 * Constraints:
 *
 * n == candyType.length
 * 2 <= n <= 10^4
 * n is even.
 * -10^5 <= candyType[i] <= 105
 */
public class DistributeCandies {
    public static void main(String[] args) {
//        Integer candyType[] = {1,1,2,2,3,3};
//        Integer candyType[] = {1,1,2,3};
        int candyType[] = {6,6,6,6};
        int totalCandiesICanEat = totalCandiesICanEat(candyType);
        System.out.println("totalCandiesICanEat = " + totalCandiesICanEat);


    }

    public static int totalCandiesICanEat(int candyType[]) {
        Set<Integer> candySet = Arrays.stream(candyType).boxed().collect(Collectors.toSet());
        int totalCandies = candyType.length;
        int totalCandiesICanEat = totalCandies/2;
        int distinctCandies = 0;
        if (totalCandiesICanEat > candySet.size()) {
            distinctCandies = candySet.size();
        } else {
            distinctCandies = totalCandiesICanEat;
        }
        return distinctCandies;
    }
}
