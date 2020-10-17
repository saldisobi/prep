package countdown.dp;

public class LongestIncreasingPath {

    public int getLongestIncreasingLength(int[][] matrix) {
        int max = 0;
        int[][] lookUpTable = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = getLongestIncreasingLength(matrix, i, j);
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        return 0;
    }

    private int getLongestIncreasingLength(int[][] matrix, int i, int j) {

        if (i < 0 || i > matrix.length || j < 0 || j > matrix[i].length) {
            return 0;
        } else {
            return 0;
        }
    }
}
