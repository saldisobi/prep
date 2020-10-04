package dp.knapsack;

public class RecursiveKnappSack {


    public int getMaxValue(int[] values, int[] weights, int weight, int index) {
        if (index == 0 || weight == 0) {
            return 0;
        }

        if (weights[index - 1] <= weight) {
            return Math.max(values[index - 1] + getMaxValue(values, weights, weight - weights[index - 1], index - 1),
                    getMaxValue(values, weights, weight, index - 1));
        } else {
            return getMaxValue(values, weights, weight, index - 1);
        }

    }

    public static void main(String args[]) {
        System.out.println(new RecursiveKnappSack().getMaxValue(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50, 3));
    }
}
