package educative.subsets;

import java.util.ArrayList;
import java.util.List;

public class BalancedParentheses {

    public List<String> getBalancedParentheses(int num) {
        List<String> result = new ArrayList<>();

        generateBalancedParentheses( num, 0, 0, new StringBuilder(), result);

        return result;

    }

    private void generateBalancedParentheses(int max, int openCount, int closeCount, StringBuilder current, List<String> result) {
        if (current.length() == max * 2) {
            result.add(current.toString());
        } else {
            if (openCount < max) {
                StringBuilder curr = new StringBuilder(current);
                curr.append("(");
                generateBalancedParentheses( max, openCount + 1, closeCount, curr, result);
            }

            if (closeCount < openCount) {
                StringBuilder curr = new StringBuilder(current);
                curr.append(")");
                generateBalancedParentheses( max, openCount, closeCount + 1, curr, result);
            }
        }
    }

    public static void main(String args[]){
        List<String> result = new BalancedParentheses().getBalancedParentheses(3);
        for(String resItem: result){
            System.out.println(resItem);
        }
    }
}
