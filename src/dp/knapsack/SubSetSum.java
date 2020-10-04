package dp.knapsack;

public class SubSetSum {

    public boolean isSubSetSum(int[] nums, int target) {

        boolean[][] lookUpTable = new boolean[nums.length + 1][target + 1];

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

        return lookUpTable[nums.length][target];
    }

    public static void main(String args[]) {
        System.out.println(new SubSetSum().isSubSetSum(new int[]{3, 34, 4, 12, 5, 2}, 17));
    }
}
