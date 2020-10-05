package dp;

public class LongestCommonSubSequence {

    public int getLongestCommonSubSequence(String s1, String s2) {

        int[][] lookUpTable = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < lookUpTable.length; i++) {
            for (int j = 0; j < lookUpTable[i].length; j++) {

                if (i == 0 || j == 0) {
                    lookUpTable[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // two character match we take diagonal value and add 1
                    lookUpTable[i][j] = lookUpTable[i - 1][j - 1] + 1;

                } else {
                    lookUpTable[i][j] = Integer.max(lookUpTable[i - 1][j], lookUpTable[i][j - 1]);
                }
            }
        }


        return lookUpTable[s1.length()][s2.length()];


    }

    public static void main(String args[]) {
        System.out.println(new LongestCommonSubSequence().getLongestCommonSubSequence("saurabh", "saurach"));
    }
}
