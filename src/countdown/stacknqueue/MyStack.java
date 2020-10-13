package countdown.stacknqueue;

public class MyStack {
    Node head;

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
        } else {
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
        head = head.previous;
        return data;
    }


    public static void main(String args[]) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.poll());
        myStack.push(5);
        System.out.println(myStack.poll());
        myStack.push(98);
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());
        System.out.println(myStack.poll());



    }
}
