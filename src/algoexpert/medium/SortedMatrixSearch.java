package algoexpert.medium;

import javafx.util.Pair;

public class SortedMatrixSearch {

    public Pair<Integer, Integer> searchSortedMatrix(int[][] matrix, int query) {
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length - 1 && column >= 0) {
            if (matrix[row][column] == query) {
                return new Pair<>(row, column);
            } else if (matrix[row][column] < query) {
                row++;
            } else {
                column--;
            }
        }

        return new Pair<>(-1, -1);
    }

    public static void main(String args[]) {
        Pair<Integer, Integer> res = new SortedMatrixSearch().searchSortedMatrix(new int[][]{{1, 5, 9},
                {14, 20, 21},
                {30, 34, 43}}, 14);
        System.out.println(res.getKey());
        System.out.println(res.getValue());
    }
}
