package countdown.matrix;

public class Rotate90 {

    private int[][] rotate90(int[][] input) {

        transposeInPlace(input);

        for (int i = 0; i < input.length; i++) {
            int start = 0;
            int end = input.length - 1;
            while (start <= end) {
                int temp = input[i][start];
                input[i][start] = input[i][end];
                input[i][end] = temp;

                start++;
                end--;
            }
        }

        return input;

    }

    private void transposeInPlace(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input[i].length; j++) {

                int temp = input[i][j];

                input[i][j] = input[j][i];
                input[j][i] = temp;

            }
        }
    }


    public static void main(String args[]) {
        int[][] input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] res = new Rotate90().rotate90(input);
        for (int i = 0; i < res.length; i++) {
            System.out.println();
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
        }
    }


}
