package countdown.graphtheory;


import java.util.Arrays;

public class FloydWarshall {

    public int[][] allPairShortestPath(int[][] input) {


        for (int k = 0; k < input.length; k++) {
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input.length; j++) {
                    if (input[i][k] + input[k][j] < input[i][j])
                        input[i][j] = input[i][k] + input[k][j];
                }
            }
        }

        return input;

    }


    public static void main(String args[]) {
        int[][] input = new int[][]{
                {0, 3, 1000, 7},
                {8, 0, 2, 1000},
                {5, 1000, 0, 1},
                {2, 1000, 1000, 0}};

        input = new FloydWarshall().allPairShortestPath(input);

        for (int i = 0; i < input.length; i++) {
            System.out.println(Arrays.toString(input[i]));
        }

    }
}
