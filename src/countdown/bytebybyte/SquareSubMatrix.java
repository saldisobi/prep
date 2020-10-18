package countdown.bytebybyte;

public class SquareSubMatrix {

    public int getSquareSubMatrix(int[][] input) {

        int[][] lookUpTable = new int[input.length][input[0].length];

        int max = 0;

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (i == 0 || j == 0) {
                    lookUpTable[i][j] = input[i][j];
                } else if (input[i][j] == 1) {
                    lookUpTable[i][j] = Math.min(Math.min(lookUpTable[i - 1][j - 1], lookUpTable[i - 1][j]), lookUpTable[i][j - 1]) + 1;
                    if (lookUpTable[i][j] > max) {
                        max = lookUpTable[i][j];
                    }
                } else {
                    lookUpTable[i][j] = 0;
                }
            }
        }

        return max;
    }

    public static void main(String args[]) {
        int[][] input = new int[][]
                {
                        {1, 1, 1, 0},
                        {1, 1, 1, 1},
                        {1, 1, 1, 0},
                        {1, 1, 0, 0}
                };
        System.out.println(new SquareSubMatrix().getSquareSubMatrix(input));
    }
}
