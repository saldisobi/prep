package countdown.matrix;

public class TransposeMatrix {

    public int[][] transposeMatrix(int[][] input) {
        if (input.length == 0) {
            return input;
        }
        int[][] res = new int[input[0].length][input.length];

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = input[j][i];
            }
        }

        return res;
    }

    public static void main(String args[]) {
        int[][] input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] res = new TransposeMatrix().transposeMatrix(input);
        for (int i = 0; i < res.length; i++) {
            System.out.println();
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
        }
    }
}
