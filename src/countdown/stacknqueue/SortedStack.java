package countdown.stacknqueue;

import java.util.Stack;

public class SortedStack {

    public Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> stackOne = new Stack<>();

        Stack<Integer> stackTwo = new Stack<>();

        boolean isStackOne = true;

        while (!input.isEmpty()) {
            if (isStackOne && stackOne.isEmpty()) {
                stackOne.push(input.pop());
            } else if (isStackOne) {
                int data = input.pop();
                if (data < stackOne.peek()) {
                    stackOne.push(data);
                } else {
                    while (!stackOne.isEmpty()) {
                        stackTwo.push(stackOne.pop());
                    }
                    stackTwo.push(data);

                    isStackOne = false;
                }
            } else {

                int data = input.pop();
                if (data < stackTwo.peek()) {
                    stackTwo.push(data);
                } else {
                    while (!stackTwo.isEmpty()) {
                        stackOne.push(stackTwo.pop());
                    }
                    stackOne.push(data);

                    isStackOne = true;
                }

            }
        }

        return isStackOne ? stackOne : stackTwo;
    }

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(9);
        stack.push(1);
        stack.push(3);
        stack.push(7);
        stack.push(4);
        stack.push(2);
        stack.push(8);
        stack.push(6);


        Stack<Integer> sortedStack = new SortedStack().sortStack(stack);

        while (!sortedStack.isEmpty()){
            System.out.println(sortedStack.pop());
        }

    }
}
