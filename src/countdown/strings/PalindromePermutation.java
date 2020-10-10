package countdown.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PalindromePermutation {

    public boolean isPalindromePermutation(String input) {
        HashMap<Character, Integer> characterToCountMap = new HashMap();

        for (int i = 0; i < input.length(); i++) {
            int currentCounterOfCharacter = characterToCountMap.getOrDefault(input.charAt(i), 0);
            characterToCountMap.put(input.charAt(i), currentCounterOfCharacter + 1);
        }

        Iterator iterator = characterToCountMap.entrySet().iterator();

        boolean oddEntry = false;
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry) iterator.next();

            if (entry.getValue() % 2 != 0 && !oddEntry) {
                oddEntry = true;
            } else if (entry.getValue() % 2 != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]){
        System.out.println(new PalindromePermutation().isPalindromePermutation("tinnt"));
    }
}
