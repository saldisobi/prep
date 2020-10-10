package countdown.strings;

import java.util.HashSet;
import java.util.Set;

public class IsPermutation {


    public boolean isPermutation(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return true;
        }
        Set<Character> characterSet = new HashSet();

        for (int i = 0; i < s1.length(); i++) {
            characterSet.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!characterSet.contains(s2.charAt(i))) {
                return false;
            } else {
                characterSet.remove(s2.charAt(i));
            }
        }

        return characterSet.isEmpty();

    }

    public static void main(String args[]){
        System.out.println(new IsPermutation().isPermutation("",""));
        System.out.println(new IsPermutation().isPermutation("a",""));
        System.out.println(new IsPermutation().isPermutation("a","a"));
        System.out.println(new IsPermutation().isPermutation("abcd","cdba"));
    }

}
