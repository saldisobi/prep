package algoexpert.medium;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Stack;

public class BalancedBrackets {

    LinkedHashSet<Character> openingSet = new LinkedHashSet<>();
    LinkedHashSet<Character> closingSet = new LinkedHashSet<>();

    BalancedBrackets() {
        openingSet.add('{');
        openingSet.add('(');
        openingSet.add('[');
        closingSet.add('}');
        closingSet.add(')');
        closingSet.add(']');

    }

    public boolean checkBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (openingSet.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty())
                    return false;
                Character bracketToMatch = stack.pop();
                if (bracketToMatch == '{' && s.charAt(i) != '}') {
                    return false;
                } else if (bracketToMatch == '(' && s.charAt(i) != ')') {
                    return false;
                } else if (bracketToMatch == '[' && s.charAt(i) != ']') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String args[]){
        System.out.println(new BalancedBrackets().checkBalanced("{{"));
        System.out.println(new BalancedBrackets().checkBalanced("}}"));
        System.out.println(new BalancedBrackets().checkBalanced("{}"));
    }
}
