package leetcode.explore;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNoRepeat {

    public int lengthOfLongestSubstring(String s) {

        if(s.isEmpty()){
            return 0;
        }
        char[] characters = s.toCharArray();

        int[] lengthLookUp = new int[s.length()];

        lengthLookUp[0] = 1; // longest substring at 0th is item at that pos only so it would be 1

        Set<Character> charSet = new HashSet<>();

        charSet.add(characters[0]);

        int max = 1;

        for (int i = 1; i < characters.length; i++) {
            if (!charSet.contains(characters[i])) {
                charSet.add(characters[i]);
                lengthLookUp[i] = lengthLookUp[i - 1] + 1;
                if (lengthLookUp[i] > max)
                    max = lengthLookUp[i];
            } else {
                charSet.clear();
                charSet.add(characters[i]);
                lengthLookUp[i] = lengthLookUp[i - 1] + 1;
                if (lengthLookUp[i] > max)
                    max = lengthLookUp[i];

            }
        }

        return max;

    }

    public static void main(String args[]) {

        System.out.println(new LongestSubstringNoRepeat().lengthOfLongestSubstring("abcabcbb"));
    }
}
