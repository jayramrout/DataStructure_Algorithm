package jrout.tutorial.practice.facebook;

import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(1,5));
        list.add(new Pair(3,7));
        list.add(new Pair(4,6));
        list.add(new Pair(6,8));

        List list1 = mergePairs(list);
        System.out.println(list1);
    }

    private static List mergePairs(List<Pair> list) {
        if(list == null || list.size() == 0)
            return list;

        List<Pair> newPair = new ArrayList();
        newPair.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (newPair.get(newPair.size() - 1).end > list.get(i).start) {
                newPair.get(newPair.size() - 1).end = Math.max(
                                                                newPair.get(newPair.size() - 1).end,
                                                                list.get(i).end);
            } else {
                newPair.add(list.get(i));
            }
        }

        return newPair;
    }

    static class Pair{
        int start;
        int end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + "," + end + ')';
        }
    }



}
