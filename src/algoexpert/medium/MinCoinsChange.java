package algoexpert.medium;

public class MinCoinsChange {

    public int getMinCoinsChange(int target, int[] coins) {

        int[] dp = new int[target + 1];

        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (coins[i] <= j) {
                    dp[j] = dp[j - coins[i]] + 1;
                }
            }
        }

        return dp[target];

    }

    public static void main(String args[]){
        System.out.println(new MinCoinsChange().getMinCoinsChange(16, new int[]{1,2,4,6}));
    }
}
