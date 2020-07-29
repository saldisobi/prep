package algoexpert.must;

public class CoinChange {

    public int getChangeWays(int target, int[] nums) {

        int[] ways = new int[target + 1];

        ways[0] = 1;

        for (int i = 1; i <= target; i++) {
            ways[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i]) {
                    ways[j] += ways[j - nums[i]];
                }
            }
        }

        return ways[target];

    }

    public static void main(String args[]) {
        System.out.println(new CoinChange().getChangeWays(10, new int[]{1, 5, 10, 25}));
    }
}
