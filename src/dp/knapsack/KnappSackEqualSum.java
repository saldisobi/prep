package dp.knapsack;

public class KnappSackEqualSum {

    public boolean isEqualSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        boolean[][] lookUpTable = new boolean[nums.length + 1][(sum / 2) + 1];

        for (int i = 0; i < lookUpTable.length; i++) {
            for (int j = 0; j < lookUpTable[i].length; j++) {
                if (i == 0) {
                    lookUpTable[i][j] = false;
                } else if (j == 0) {
                    lookUpTable[i][j] = true;
                } else if (nums[i - 1] <= j) {
                    lookUpTable[i][j] = lookUpTable[i - 1][j] || lookUpTable[i - 1][j - nums[i - 1]];
                } else {
                    lookUpTable[i][j] = lookUpTable[i - 1][j];
                }
            }
        }

        return lookUpTable[nums.length][sum / 2];
    }


    public static void main(String args[]) {
        System.out.println(new KnappSackEqualSum().isEqualSum(new int[]{11, 5, 6, 2, 2}));
    }
}
