package countdown.bytebybyte;

public class MatrixProduct {

    public int getMaxProductRecur(int[][] matrix, int i, int j) {

        if (i + 1 > matrix.length || j + 1 > matrix[i].length) {

            return 1;

        }

        return Math.max(matrix[i][j] * getMaxProductRecur(matrix, i + 1, j), matrix[i][j] * getMaxProductRecur(matrix, i, j + 1));

    }


    public int getMaxProduct(int[][] matrix) {
        int[][] lookUpTable = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == 0 && j == 0) {
                    lookUpTable[i][j] = matrix[i][j];
                } else if (i == 0) {
                    lookUpTable[i][j] = lookUpTable[i][j - 1] * matrix[i][j];
                } else if (j == 0) {
                    lookUpTable[i][j] = lookUpTable[i - 1][j] * matrix[i][j];
                } else {
                    lookUpTable[i][j] = Math.max(matrix[i][j] * lookUpTable[i - 1][j], matrix[i][j] * lookUpTable[i][j - 1]);
                }
            }
        }

        return lookUpTable[matrix.length - 1][matrix[0].length - 1];
    }

    public static void main(String args[]) {
        int[][] matrix = new int[][]{
                {1, 0, 3},
                {4, 5, 6},
                {7, 0, 9}
        };
        int res = new MatrixProduct().getMaxProductRecur(matrix, 0, 0);
        System.out.println(res);
        int res1 = new MatrixProduct().getMaxProduct(matrix);
        System.out.println(res1);
    }
}
