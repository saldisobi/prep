package amazon;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {

        Map<Character, Integer> characterToPositionMap = new LinkedHashMap();

        for (int i = 0; i < s.length(); i++) {
            int position = characterToPositionMap.getOrDefault(s.charAt(i), -1);

            if (position == -1) {
                characterToPositionMap.put(s.charAt(i), i);
            } else {
                characterToPositionMap.put(s.charAt(i), Integer.MAX_VALUE);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (characterToPositionMap.get(s.charAt(i)) < min) {
                min = characterToPositionMap.get(s.charAt(i));

            }
        }


        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
