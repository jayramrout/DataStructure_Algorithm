package jrout.tutorial.algorithm.educative.slidingwindow;

public class MaxSumSubarrayOfSizeK {

    public static void main(String[] args) {
        int intput[] = {2,1,5,1,3,2};
//        int i = maxSumOfContiguousSubArray(intput, 3);
        int i = maxSumOfContiguousSubArray_DP(intput, 3);

//        int intput[] = {2,3,4,1,5};
//        int i = maxSumOfContiguousSubArray(intput, 4);

        System.out.println("Sum ="+i);
    }

    public static int maxSumOfContiguousSubArray(int arr[], int k) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return maxSum;
    }

    public static int maxSumOfContiguousSubArray_old(int arr[], int k) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int maxSum = 0;
        for (int i = 0; i < arr.length - k; i++) {
            int innerSum = 0;
            for (int j = 0; j < k; j++) {
                innerSum += arr[i+j];
            }
            maxSum = Math.max(innerSum,maxSum);
        }
        return maxSum;
    }

    public static int maxSumOfContiguousSubArray_DP(int arr[], int k) {
        int n = arr.length;
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            localMax = Math.max(arr[i], arr[i] + localMax);
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }
        return globalMax;
    }

}
