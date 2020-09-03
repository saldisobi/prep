package amazon;

public class DiagonalFill {

    public void diagonalFill() {

        int gap, i, j;

        int sum = 0;
        int[][] arr = new int[4][4];
        int n = 4;
        for (gap = 0; gap < n; ++gap) {
            for (i = 0, j = gap; j < n; ++i, ++j) {
                arr[i][j] = sum;
                sum++;

            }
        }

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                System.out.print(arr[k][l] + "   ");
            }
            System.out.println("   ");
        }
    }

    public void diagonalFillModified() {

        int gap, i, j;

        int sum = 0;
        int[][] arr = new int[4][4];
        int n = 4;
        for (gap = 0; gap < n; gap++) {
            for (i = 0, j = gap; j < n; i++, j++) {
                arr[i][j] = sum;
                sum++;

            }
        }

        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                System.out.print(arr[k][l] + "   ");
            }
            System.out.println("   ");
        }
    }

    public static void main(String ar[]) {
        new DiagonalFill().diagonalFill();
        System.out.println();
        System.out.println();
        System.out.println();
        new DiagonalFill().diagonalFillModified();
    }
}
