package dp.knapsack;

public class TopDownKnappSack {

    public int getMaxWeight(int[] values, int[] weights, int maxWeight) {

        int[][] lookUpTable = new int[values.length + 1][maxWeight + 1];

        for (int i = 0; i < lookUpTable.length - 1; i++) {
            for (int j = 0; j < lookUpTable[i].length - 1; j++) {
                if (i == 0 || j == 0) {
                    lookUpTable[i][j] = 0;
                }
            }
        }


        for (int i = 1; i < lookUpTable.length; i++) {
            for (int j = 1; j < lookUpTable[i].length; j++) {
                if (weights[i - 1] <= j) {
                    lookUpTable[i][j] = Math.max(values[i - 1] + lookUpTable[i - 1][j - weights[i - 1]], lookUpTable[i - 1][j]);
                } else {
                    lookUpTable[i][j] = lookUpTable[i - 1][j];
                }
            }
        }

        return lookUpTable[values.length][maxWeight];

    }

    public static void main(String args[]) {
        System.out.println(new TopDownKnappSack().getMaxWeight(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
    }
}
