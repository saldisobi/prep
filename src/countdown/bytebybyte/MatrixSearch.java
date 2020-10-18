package countdown.bytebybyte;

public class MatrixSearch {

   /* contains(
   6
   [​1​, ​2​, ​3​, ​4​]
   [​5​, ​6​, ​7​, ​8​]
   [​9​, ​10​, ​11​, ​12​]) = True*/


    public boolean contains(int[][] input, int number) {

        int i = 0;
        int j = input.length - 1;

        while (i < input.length && j >= 0) {

            if (input[i][j] == number) {
                return true;
            } else if (input[i][j] < number) {
                i++;
            } else {
                j--;
            }

        }

        return false;
    }

    public static void main(String args[]) {
        int[][] input = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        MatrixSearch matrixSearch = new MatrixSearch();

        System.out.println(matrixSearch.contains(input, 1));
        System.out.println(matrixSearch.contains(input, 9));
        System.out.println(matrixSearch.contains(input, 1));
        System.out.println(matrixSearch.contains(input, 7));
        System.out.println(matrixSearch.contains(input, 8));
        System.out.println(matrixSearch.contains(input, 16));
        System.out.println(matrixSearch.contains(input, 188));
        System.out.println(matrixSearch.contains(input, 14));


    }

}
