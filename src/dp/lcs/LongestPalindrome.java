package dp.lcs;

public class LongestPalindrome {

    public int getLongestPalindromeLength(String input) {
        int[][] lookUpTable = new int[input.length()][input.length()];

        for (int i = 0; i < input.length(); i++) {
            lookUpTable[i][i] = 1;
        }

        int hotSpotCharCount = 2;

        while (hotSpotCharCount <= input.length()) {

            for (int i = 0; i < input.length() - hotSpotCharCount + 1; i++) {
                int j = i + hotSpotCharCount - 1;

                boolean isEqual = input.charAt(i) == input.charAt(j);
                if (hotSpotCharCount == 2 && isEqual) {
                    lookUpTable[i][j] = 2;
                } else if (isEqual) {
                    lookUpTable[i][j] = lookUpTable[i + 1][j - 1] + 2;
                } else {
                    lookUpTable[i][j] = Math.max(lookUpTable[i + 1][j], lookUpTable[i][j - 1]);
                }
            }

            hotSpotCharCount++;
        }

        return lookUpTable[0][input.length() - 1];
    }

    public static void main(String args[]) {
        System.out.println(new LongestPalindrome().getLongestPalindromeLength("agbdba"));
    }
}
