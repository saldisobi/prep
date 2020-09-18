package educative.slidingwindow;

import java.util.HashMap;

public class LongestStringNoRepeat {

    public int longestStringNoRepeat(String s) {

        int windowStart = 0;

        int maxLength = Integer.MIN_VALUE;


        HashMap<Character, Integer> characterMap = new HashMap();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightMostCharacter = s.charAt(windowEnd);

            if (characterMap.containsKey(rightMostCharacter)) {
                windowStart = Math.max(windowStart, characterMap.get(rightMostCharacter) + 1);

            }
            characterMap.put(rightMostCharacter, windowEnd);

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String args[]) {
        System.out.println(new LongestStringNoRepeat().longestStringNoRepeat("aabccbb"));
    }
}
