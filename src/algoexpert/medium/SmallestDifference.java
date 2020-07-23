package algoexpert.medium;

import javafx.util.Pair;

import java.util.Arrays;

public class SmallestDifference {

    public Pair<Integer, Integer> getSmallestDifference(int[] arrOne, int[] arrTwo) {
        Arrays.sort(arrOne);
        Arrays.sort(arrTwo);

        int smallestDifference = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        int numOne = arrOne[i];
        int numTwo = arrTwo[j];

        while (i < arrOne.length && j < arrTwo.length) {
            int diff = Math.abs(arrOne[i] - arrTwo[j]);

            if (diff == 0) {
                // can not be better than this
                return new Pair<>(arrOne[i], arrTwo[j]);
            } else if (diff < smallestDifference) {
                smallestDifference = diff;
                numOne = arrOne[i];

                numTwo = arrTwo[j];
            }

            if (arrOne[i] > arrTwo[j]) {
                j++;
            } else {
                i++;
            }

        }

        return new Pair<>(numOne, numTwo);
    }

    public static void main(String args[]) {
        Pair<Integer, Integer> pair = new SmallestDifference().getSmallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17});
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }
}
