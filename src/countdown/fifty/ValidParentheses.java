package countdown.fifty;

import java.util.HashMap;
import java.util.Stack;


public class ValidParentheses {


    HashMap<Character, Character> openingMap = new HashMap<>();


    ValidParentheses() {
        openingMap.put('{', '}');
        openingMap.put('(', ')');
        openingMap.put('[', ']');


    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (openingMap.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                Character popChar = stack.pop();

                if (popChar != null && openingMap.get(popChar) == s.charAt(i)) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();


    }

    public static void main(String args[]) {
        System.out.println(new ValidParentheses().isValid("{"));
        System.out.println(new ValidParentheses().isValid("{}"));
        System.out.println(new ValidParentheses().isValid("(()){"));
        System.out.println(new ValidParentheses().isValid("{()}"));
    }
}
