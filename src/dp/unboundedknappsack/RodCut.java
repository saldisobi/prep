package dp.unboundedknappsack;

public class RodCut {

    public int getMaxProfit(int[] price, int weight) {

        int[][] lookUpTable = new int[price.length + 1][weight + 1];

        for (int i = 0; i < lookUpTable.length; i++) {
            for (int j = 0; j < lookUpTable[i].length; j++) {
                if (i == 0) {
                    lookUpTable[i][j] = 0;
                } else if (j == 0) {
                    lookUpTable[i][j] = 0;
                } else if (i <= j) {
                    lookUpTable[i][j] = Math.max(price[i - 1] + lookUpTable[i][j - i], lookUpTable[i - 1][j]);
                } else {
                    lookUpTable[i][j] = lookUpTable[i - 1][j];
                }
            }
        }

        return lookUpTable[price.length][weight];

    }

    public static void main(String args[]) {
        System.out.println(new RodCut().getMaxProfit(new int[]{2, 5, 7, 8}, 5));
    }
}
