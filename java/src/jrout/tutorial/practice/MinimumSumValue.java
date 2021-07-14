package jrout.tutorial.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumSumValue {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(20);
        ints.add(7);

        int i = minSum(ints, 4);
        System.out.println(i);
    }

    public static int minSum(List<Integer> num, int k) {
        if(num.size() == 0)
            return 0;
        int i = 0;
        for (i = 0; (i < num.size() && i < k); i++) {
            int ceilValue = (int) Math.ceil((double) num.get(i) / 2);
            num.set(i, Integer.valueOf(ceilValue));
        }

        while(i < k){
            Collections.sort(num,Collections.reverseOrder());
            int ceilValue = (int)Math.ceil(num.get(0)/2);
            num.set(0, Integer.valueOf(ceilValue));
            i++;
        }
        return num.stream().mapToInt(Integer::intValue).sum();
    }
}
