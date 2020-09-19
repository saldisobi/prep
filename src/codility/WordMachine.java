package codility;

import java.util.Stack;

public class WordMachine {

    public static final int MAX = 0XFFFFF;

    public static final int MIN = 0;

    public int solution(String S) {
        // write your code in Java SE 8
        String[] commands = S.split(" ");

        Stack<Integer> commandStack = new Stack<>();

        for (int i = 0; i < commands.length; i++) {

            if (commands[i].equalsIgnoreCase("DUP")) {
                if (!commandStack.isEmpty()) {
                    commandStack.push(commandStack.peek());

                } else {
                    return -1;
                }

            } else if (commands[i].equalsIgnoreCase("POP")) {

                if (!commandStack.isEmpty()) {
                    commandStack.pop();
                } else {
                    return -1;
                }

            } else if (commands[i].equalsIgnoreCase("+")) {

                if (commandStack.size() < 2) {
                    return -1;
                } else {
                    int num1 = commandStack.pop();
                    int num2 = commandStack.pop();
                    int sum = num1 + num2;
                    if (!isValid(sum)) return -1;
                    commandStack.push(sum);
                }

            } else if (commands[i].equalsIgnoreCase("-")) {
                if (commandStack.size() < 2) {
                    return -1;
                } else {
                    int num1 = commandStack.pop();
                    int num2 = commandStack.pop();
                    int diff = num1 - num2;
                    if (!isValid(diff)) return -1;
                    commandStack.push(diff);
                }
            } else {
                try {
                    int num = Integer.parseInt(commands[i]);
                    commandStack.push(num);
                } catch (NumberFormatException nfe) {
                    return -1;
                }
            }

        }

        return commandStack.pop();


    }

    private boolean isValid(int num) {

        if (num < MIN && num > MAX) {
            return false;
        }
        return true;
    }


    public static void main(String args[]) {
        System.out.println(new WordMachine().solution("3 DUP 5 - -"));

        System.out.println(0XFFFFF);
    }
}
