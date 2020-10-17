package countdown.dp;

public class MinimumPartition {

    public void getPartition(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        boolean[][] lookUpTable = new boolean[nums.length + 1][sum + 1];

        for (int i = 0; i < lookUpTable.length; i++) {
            for (int j = 0; j < lookUpTable[i].length; j++) {

                if (j == 0) {
                    lookUpTable[i][j] = true;
                } else if (i == 0) {
                    lookUpTable[i][j] = false;
                } else {
                    if (nums[i - 1] <= j) {
                        lookUpTable[i][j] = lookUpTable[i][j - nums[i - 1]];
                    } else {
                        lookUpTable[i][j] = lookUpTable[i - 1][j];
                    }
                }
            }
        }
    }
}
