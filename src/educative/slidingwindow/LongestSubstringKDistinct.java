package educative.slidingwindow;

import java.util.HashMap;

public class LongestSubstringKDistinct {

    public int longestSubStringKDistinct(String string, int distinct) {

        int windowStart = 0;

        int maxLengthString = Integer.MIN_VALUE;

        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < string.length(); windowEnd++) {
            char rightCharacter = string.charAt(windowEnd);
            charFrequencyMap.put(rightCharacter, charFrequencyMap.getOrDefault(rightCharacter, 0) + 1);

            while (charFrequencyMap.size() > distinct) {
                char leftCharacter = string.charAt(windowStart);
                charFrequencyMap.put(leftCharacter, charFrequencyMap.get(leftCharacter) - 1);
                if (charFrequencyMap.get(leftCharacter) < 1) {
                    charFrequencyMap.remove(leftCharacter);
                }

                windowStart++;

            }

            maxLengthString = Math.max(maxLengthString, windowEnd - windowStart + 1);

        }
        return maxLengthString;

    }

    public static void main(String args[]) {
        System.out.println(new LongestSubstringKDistinct().longestSubStringKDistinct("araaci", 1));
    }
}
