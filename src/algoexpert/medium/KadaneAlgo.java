package algoexpert.medium;

public class KadaneAlgo {

    public int getMaxSubArraySum(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.max(dp[i - 1] + nums[i], nums[i]);
        }
        return dp[nums.length - 1];


    }

    public static void main(String args[]) {
        System.out.println(new KadaneAlgo().getMaxSubArraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
