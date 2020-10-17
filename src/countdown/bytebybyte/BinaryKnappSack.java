package countdown.bytebybyte;

public class BinaryKnappSack {


    public int getMaxProfit(int[] values, int[] weights, int maxWeight) {

        if (values == null || values.length == 0) {
            return 0;
        }

        if (weights == null || weights.length != values.length) {
            return 0;
        }


        int[][] lookUpTable = new int[weights.length + 1][maxWeight + 1];


        for (int i = 0; i < lookUpTable.length; i++) {
            for (int j = 0; j < lookUpTable[i].length; j++) {
                if (i == 0 || j == 0) {
                    lookUpTable[i][j] = 0;
                } else {
                    if (weights[i - 1] <= j) {
                        lookUpTable[i][j] = Math.max(lookUpTable[i][j - weights[i - 1]] + values[i - 1], lookUpTable[i - 1][j]);

                    } else {

                        lookUpTable[i][j] = lookUpTable[i - 1][j];
                    }

                }
            }

        }

        return lookUpTable[values.length][maxWeight];

    }


    public static void main(String args[]) {
        System.out.println(new BinaryKnappSack().getMaxProfit(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
    }
}
