package educative.subsets;

import java.util.ArrayList;
import java.util.List;

public class ChangeCaseStringPermutation {

    public List<String> getStringCasePermutation(String input) {
        List<String> permutations = new ArrayList<>();

        getAllPermutations(0, new StringBuilder(), input, permutations);

        return permutations;
    }

    private void getAllPermutations(int index, StringBuilder stringBuilder, String input, List<String> permutations) {
        if (input.length() == index) {
            permutations.add(stringBuilder.toString());
        } else {
            if (!Character.isDigit(input.charAt(index))) {
                getAllPermutations(index + 1, new StringBuilder(stringBuilder).append(Character.toLowerCase(input.charAt(index))), input, permutations);
            }
            getAllPermutations(index + 1, new StringBuilder(stringBuilder).append(input.charAt(index)), input, permutations);
        }
    }

    public static void main(String args[]) {
        List<String> result = new ChangeCaseStringPermutation().getStringCasePermutation("AB7C");
        for (String res : result) {
            System.out.println(res);
        }
    }
}
