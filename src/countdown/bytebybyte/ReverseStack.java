package countdown.bytebybyte;

import java.util.Stack;

public class ReverseStack {

    public Stack<Integer> reverseStack(Stack<Integer> input) {

        reverseStackRecursive(input, input.pop());

        return input;
    }

    private void reverseStackRecursive(Stack<Integer> input, int i) {
        if (input.isEmpty()) {
            input.push(i);
            return;
        }
        int num = input.pop();
        reverseStackRecursive(input, num);
        input.push(i);
    }

    public static void main(String args[]) {
        Stack<Integer> input = new Stack<>();
        input.push(1);
        input.push(2);
        input.push(3);

        input = new ReverseStack().reverseStack(input);

        while (!input.isEmpty()){
            System.out.println(input.pop());
        }
    }
}
