package countdown.dp;

public class EditDistance {

    public int editDistance(String s1, String s2) {

        int[][] lookUpTable = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i == 0 && j == 0) {
                    lookUpTable[i][j] = 0;
                } else if (i == 0) {
                    lookUpTable[i][j] = j;
                } else if (j == 0) {
                    lookUpTable[i][j] = i;
                } else if (s1.charAt(i) == s2.charAt(j)) {
                    lookUpTable[i][j] = lookUpTable[i - 1][j - 1];
                } else {
                    lookUpTable[i][j] = Math.min(Math.min(lookUpTable[i][j - 1], lookUpTable[i - 1][j]), lookUpTable[i - 1][j - 1]) + 1;
                }
            }
        }

        return lookUpTable[s1.length()][s2.length()];

    }
}
