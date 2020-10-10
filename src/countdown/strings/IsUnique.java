package countdown.strings;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    public boolean isUnique(String input) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            if (set.contains(input.charAt(i))) {
                return false;
            } else {
                set.add(input.charAt(i));
            }
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.println(new IsUnique().isUnique("saldi"));
    }
}
