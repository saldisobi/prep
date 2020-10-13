package countdown.stacknqueue;

public class MinStack {
    Node head;
    int min;

    class Node {
        int data;
        Node previous;

        Node(int data) {
            this.data = data;
        }
    }


    public void push(int data) {
        if (head == null) {
            head = new Node(data);
            min = data;
        } else {
            if (data < min) {
                data = 2 * data - min;


            }
            Node node = new Node(data);
            node.previous = head;
            head = node;
        }
    }

    public int poll() {
        if (head == null) {
            return -1;
        }
        int data = head.data;
        if (data < min) {
            min = 2 * min - data;
            data = min;
        }
        head = head.previous;
        return data;
    }


    public static void main(String args[]) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.poll());
        stack.push(5);
        System.out.println(stack.poll());
        stack.push(98);
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());


    }
}
