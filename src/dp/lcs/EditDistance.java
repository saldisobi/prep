package dp.lcs;

public class EditDistance {

    public int getEditDistance(String s1, String s2) {
        int[][] lookupTable = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < lookupTable.length; i++) {
            for (int j = 0; j < lookupTable[i].length; j++) {
                if (i == 0 && j == 0) {
                    lookupTable[i][j] = 0;
                } else if (i == 0) {
                    lookupTable[i][j] = j;
                } else if (j == 0) {
                    lookupTable[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lookupTable[i][j] = lookupTable[i - 1][j - 1];
                } else {
                    lookupTable[i][j] = Integer.min(Integer.min(lookupTable[i - 1][j - 1], lookupTable[i - 1][j]), lookupTable[i][j - 1]) + 1;
                }
            }
        }

        return lookupTable[s1.length()][s2.length()];
    }

    public static void main(String args[]) {
        System.out.println(new EditDistance().getEditDistance("sobi", "saii"));
    }
}
