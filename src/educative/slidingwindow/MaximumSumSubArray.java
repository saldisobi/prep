package educative.slidingwindow;

public class MaximumSumSubArray {

    public int getMaximumSumSubArray(int[] nums, int size) {

        if (size > nums.length) {
            return 0;
        }

        int currentSum = 0;

        int maxSum;

        int i = 0;

        while (i < size) {
            currentSum += nums[i];
            i++;
        }

        maxSum = currentSum;
        for (i = size; i < nums.length; i++) {
            currentSum -= nums[i - size];
            currentSum += nums[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;

    }

    public static void main(String args[]) {

        System.out.println(new MaximumSumSubArray().getMaximumSumSubArray(new int[]{2, 1, -5, 1, 3, 2}, 3));

    }
}
