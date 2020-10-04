package dp.knapsack;

public class MinimumDifferenceSubSet {

    public int getMinimumDifference(int[] nums) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }


        boolean[][] lookUpTable = new boolean[nums.length + 1][sum + 1];

        for (int i = 0; i < lookUpTable.length; i++) {
            for (int j = 0; j < lookUpTable[i].length; j++) {
                if (i == 0) {
                    lookUpTable[i][j] = false;
                } else if (j == 0) {
                    lookUpTable[i][j] = true;
                } else if (nums[i - 1] >= j) {
                    lookUpTable[i][j] = lookUpTable[i - 1][j] || lookUpTable[i - 1][j - nums[i - 1]];

                } else {
                    lookUpTable[i][j] = lookUpTable[i - 1][j];
                }
            }
        }

        int diff = Integer.MAX_VALUE;

        // Find the largest j such that dp[n][j]
        // is true where j loops from sum/2 t0 0
        for (int j = sum / 2; j >= 0; j--) {
            // Find the
            if (lookUpTable[nums.length][j] == true) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }

    public static void main(String args[]) {
        System.out.println(new MinimumDifferenceSubSet().getMinimumDifference(new int[]{1, 12}));
    }
}
