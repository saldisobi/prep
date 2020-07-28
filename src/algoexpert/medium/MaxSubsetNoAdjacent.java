package algoexpert.medium;

public class MaxSubsetNoAdjacent {

    public int maxSubsetSumNoAdjacent(int[] nums) {

        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        if (nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];


    }

    public static void main(String args[]) {
        System.out.println(new MaxSubsetNoAdjacent().maxSubsetSumNoAdjacent(new int[]{7, 10, 12, 7, 9, 14}));
    }
}
