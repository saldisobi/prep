package countdown.dp;

import java.util.Arrays;

public class LIS {


    public int getLIS(int[] input) {

        int[] lookUpTable = new int[input.length];

        Arrays.fill(lookUpTable, 1);

        int max = 0;

        for (int j = 1; j < input.length; j++) {

            for (int i = 0; i <= j; i++) {
                if (input[i] < input[j]) {
                    lookUpTable[j] = Math.max((lookUpTable[i] + 1), lookUpTable[j]);
                    if (lookUpTable[j] > max) {
                        max = lookUpTable[j];
                    }
                }
            }

        }

        return max;

    }


    public static void main(String args[]) {
        System.out.println(new LIS().getLIS(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}));
    }
}
