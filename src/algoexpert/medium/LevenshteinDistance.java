package algoexpert.medium;

/**
 * Basic idea if same take up diagonal value else min of all 3 (insert delete and replace) plus 1
 */
public class LevenshteinDistance {

    public int getMinDistance(String strOne, String strTwo) {

        int[][] dp = new int[strOne.length() + 1][strTwo.length() + 1];

        for (int i = 0; i <= strOne.length(); i++) {
            for (int j = 0; j <= strTwo.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (strOne.charAt(i - 1) == strTwo.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[strOne.length()][strTwo.length()];
    }

    public static void main(String args[]) {
        System.out.println(new LevenshteinDistance().getMinDistance("ad", "abcd"));
    }

}
