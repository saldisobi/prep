package dp.knapsack;

public class MemoizeKnappSack {

    int[][] lookUpTable;

    public int getKnappSackMax(int[] values, int[] weights, int weight, int index) {
        lookUpTable = new int[values.length + 1][weight + 1];
        for (int i = 0; i < lookUpTable.length; i++) {
            for (int j = 0; j < lookUpTable[i].length; j++) {
                lookUpTable[i][j] = -1;
            }
        }
        int res = getMaxValue(values, weights, weight, index);

        return res;
    }

    public int getMaxValue(int[] values, int[] weights, int weight, int index) {
        if (index == 0 || weight == 0) {
            return 0;
        }
        if (lookUpTable[index][weight] != -1) {

            return lookUpTable[index][weight];

        }

        int res;
        if (weights[index - 1] <= weight) {
            res = Math.max(values[index - 1] + getMaxValue(values, weights, weight - weights[index - 1], index - 1),
                    getMaxValue(values, weights, weight, index - 1));

        } else {
            res = getMaxValue(values, weights, weight, index - 1);

        }
        lookUpTable[index][weight] = res;
        return res;

    }

    public static void main(String args[]) {
        System.out.println(new MemoizeKnappSack().getKnappSackMax(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50, 3));
    }
}
