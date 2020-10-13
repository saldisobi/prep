package countdown.stacknqueue;

public class QueueTwoStack {

    private java.util.Stack<Integer> stackOne = new java.util.Stack();

    private java.util.Stack<Integer> stackTwo = new java.util.Stack();

    boolean isFirst = true;

    public void enqueue(int data) {

        if (isFirst) {
            stackOne.push(data);
        } else {
            stackTwo.push(data);
        }

    }

    public int deque() {
        if (isFirst && stackTwo.isEmpty()) {
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
                isFirst = !isFirst;
            }
            return stackTwo.pop();
        } else if (isFirst) {
            return stackTwo.pop();
        } else if (!isFirst && stackOne.isEmpty()) {
            while (!stackTwo.isEmpty()) {
                stackOne.push(stackTwo.pop());
                isFirst = !isFirst;
            }
            return stackOne.pop();
        } else {
            return stackOne.pop();
        }
    }

    public static void main(String args[]) {
        QueueTwoStack queueTwoStack = new QueueTwoStack();
        queueTwoStack.enqueue(1);
        queueTwoStack.enqueue(2);
        queueTwoStack.enqueue(3);
        queueTwoStack.enqueue(4);

        System.out.println(queueTwoStack.deque());
        System.out.println(queueTwoStack.deque());
        queueTwoStack.enqueue(5);
        queueTwoStack.enqueue(6);
        System.out.println(queueTwoStack.deque());
        System.out.println(queueTwoStack.deque());
        System.out.println(queueTwoStack.deque());
        System.out.println(queueTwoStack.deque());


    }
}
