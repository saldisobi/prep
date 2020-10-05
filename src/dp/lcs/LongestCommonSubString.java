package dp.lcs;

public class LongestCommonSubString {


    public int getLongestCommonSubString(String s1, String s2) {

        int[][] lookUpTable = new int[s1.length() + 1][s2.length() + 1];

        int maxLength = 0;

        for (int i = 0; i < lookUpTable.length; i++) {
            for (int j = 0; j < lookUpTable[i].length; j++) {
                if (i == 0 || j == 0) {
                    lookUpTable[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lookUpTable[i][j] = lookUpTable[i - 1][j - 1] + 1;

                } else {
                    lookUpTable[i][j] = 0;
                }

                if (lookUpTable[i][j] > maxLength) {
                    maxLength = lookUpTable[i][j];
                }
            }
        }

        return maxLength;

    }

    public static void main(String args[]) {
        System.out.println(new LongestCommonSubString().getLongestCommonSubString("saurach", "saurabh"));
    }


}
