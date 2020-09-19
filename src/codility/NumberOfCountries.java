package codility;

public class NumberOfCountries {

    public int solution(int[][] A) {

        int countriesCount = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] != -1) {
                    countriesCount++;
                    dfs(A, i, j, A[i][j]);
                }
            }
        }

        return countriesCount;
    }

    private void dfs(int[][] a, int i, int j, int num) {

        if (i < 0 || i > a.length - 1 || j < 0 || j > a[i].length - 1 || a[i][j] != num) {
            return;
        }

        a[i][j] = -1;

        dfs(a, i + 1, j, num);
        dfs(a, i - 1, j, num);
        dfs(a, i, j + 1, num);
        dfs(a, i, j - 1, num);

        return;

    }

    public static void main(String args[]) {
        int[][] input = new int[][]{
                {5, 4, 4},
                {4, 3, 4},
                {3, 2, 4},
                {2, 2, 2},
                {3, 3, 4},
                {1, 4, 4},
                {4, 1, 1}
        };

        System.out.println(new NumberOfCountries().solution(input));

    }
}
