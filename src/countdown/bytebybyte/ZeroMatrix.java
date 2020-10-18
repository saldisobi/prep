package countdown.bytebybyte;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {

    public boolean[][] getTrueMatrix(boolean[][] input) {

        Set<Integer> rows = new HashSet<>();

        Set<Integer> columns = new HashSet<>();

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == true) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }


        for (int row : rows) {
            for (int i = 0; i < input[row].length; i++) {
                input[row][i] = true;
            }
        }

        for (int column : columns) {
            for (int i = 0; i < input.length; i++) {
                input[i][column] = true;
            }
        }

        return input;
    }


    public static void main(String args[]) {
        boolean[][] input = new boolean[][]{
                {true, false, false},
                {false, false, false},
                {false, false, false}
        };
        boolean[][] result = new ZeroMatrix().getTrueMatrix(input);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
