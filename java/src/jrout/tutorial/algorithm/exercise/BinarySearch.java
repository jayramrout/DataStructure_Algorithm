package jrout.tutorial.algorithm.exercise;

public class BinarySearch {
    public static void main(String[] args) {
        int sortedList[] = {1,2,3,3,4,5,8,9,10,17,88};
        int searchIndex = binarySearch(sortedList,88);
        System.out.println("search Index "+ searchIndex);
    }

    public static int binarySearch(int sortedList[], int number) {
        if(sortedList.length == 0)
            return -1;

        int min = 0;
        int max = sortedList.length - 1;
        while (min <= max) {
            int mid = min + (max - min)/2;

            if(sortedList[mid] == number)
                return mid;

            if(sortedList[mid] > number)
                max = mid - 1;
            else
               min = mid + 1;
        }

        return -1;
    }
}
