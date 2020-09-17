package educative.slidingwindow;

import java.util.HashMap;

public class LongestSubstringDistinct {

    public String longestSubStringAllDistinct(String input) {
        HashMap<Character, Integer> characterToPositionMap = new HashMap<>();


        int currentStart = 0;

        String longestString = "";
        for (int i = 0; i < input.length(); i++) {

            if (characterToPositionMap.get(input.charAt(i)) == null) {
                characterToPositionMap.put(input.charAt(i), i);
            } else {
                // case is repeating one
                //we still update newest position of given character
                characterToPositionMap.put(input.charAt(i), i);
                if ((i - currentStart + 1) > longestString.length()) {
                    longestString = input.substring(currentStart, i);
                }

                currentStart = characterToPositionMap.get(input.charAt(i)) + 1;


            }

        }

        if (input.length() - currentStart > longestString.length()) {
            longestString = input.substring(currentStart, input.length());
        }

        return longestString;

    }


    public static void main(String args[]) {
        System.out.println(new LongestSubstringDistinct().longestSubStringAllDistinct("aabccbb"));
        // System.out.println(new LongestSubstringDistinct().longestSubStringAllDistinct("aababcdefahgsfshshghytstdstttsfsffjskllskskskqwerttyuiiopasdfgvcnkshuo"));
    }
}
