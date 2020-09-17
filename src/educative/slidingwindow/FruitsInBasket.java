package educative.slidingwindow;

import java.util.HashMap;

public class FruitsInBasket {

    public int findMaxFruits(char[] fruits) {

        int windowStart = 0;

        int maxLength = 0;

        HashMap<Character, Integer> charToFrequencyMap = new HashMap<>();


        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            char rightMostCharacter = fruits[windowEnd];

            charToFrequencyMap.put(rightMostCharacter, charToFrequencyMap.getOrDefault(rightMostCharacter, 0) + 1);

            while (charToFrequencyMap.size() > 2) {
                char leftMostCharacter = fruits[windowStart];

                charToFrequencyMap.put(leftMostCharacter, charToFrequencyMap.getOrDefault(leftMostCharacter, 0) - 1);

                if (charToFrequencyMap.get(leftMostCharacter) == 0) {
                    charToFrequencyMap.remove(leftMostCharacter);
                }

                windowStart++;

            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }
        return maxLength;

    }

    public static void main(String args[]) {
        System.out.println(new FruitsInBasket().findMaxFruits(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
