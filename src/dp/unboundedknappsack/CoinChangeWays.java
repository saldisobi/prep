package dp.unboundedknappsack;

public class CoinChangeWays {

    public int getWays(int[] coins, int target) {

        int[][] lookUpTable = new int[coins.length + 1][target + 1];

        for (int i = 0; i < lookUpTable.length; i++) {
            for (int j = 0; j < lookUpTable[i].length; j++) {
                if (j == 0) {
                    lookUpTable[i][j] = 1;
                } else if (i == 0) {
                    lookUpTable[i][j] = 0;
                } else if (coins[i-1] <= j) {
                    lookUpTable[i][j] = lookUpTable[i - 1][j] + lookUpTable[i][j - coins[i-1]];
                } else {
                    lookUpTable[i][j] = lookUpTable[i - 1][j];
                }
            }
        }

        return lookUpTable[coins.length][target];

    }

    public static void main(String args[]){
        System.out.println(new CoinChangeWays().getWays(new int[]{1,2,5},5));
    }
}
