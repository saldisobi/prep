package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PhonePermutations {
    public List<String> letterCombinations(String digits) {




        List<String> results = new ArrayList<>();

        if(digits.isEmpty()){
            return results;
        }

        String[] numberToCharacter = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        letterCombinationsRecur(results, digits, "", numberToCharacter, 0);

        return results;

    }

    private void letterCombinationsRecur(List<String> results, String digits, String current, String[] numberToCharacter, int index) {
        if (index == digits.length()) {
            results.add(current);
        } else {
            String characters = numberToCharacter[Character.getNumericValue(digits.charAt(index))];

            for (int i = 0; i < characters.length(); i++) {
                letterCombinationsRecur(results, digits, current + characters.charAt(i), numberToCharacter, index + 1);
            }
        }
    }

    public static void main(String args[]) {
        List<String> res = new PhonePermutations().letterCombinations("234");

        System.out.println(Arrays.toString(res.toArray()));
    }
}