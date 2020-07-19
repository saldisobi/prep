package datastructures;

public class MyStack<T> {

    Node head;

    class Node<T> {
        T data;
        Node previous;

        Node(T data) {
            this.data = data;
        }
    }

    public void push(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            head = node;
            head.previous = temp;
        }
    }

    public Node<T> pop() {
        Node node = head;
        head = head.previous;
        return node;
    }

    public static void main(String args[]) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(10);
        myStack.push(9);
        myStack.push(8);
        System.out.println(myStack.pop().data);
        myStack.push(7);
        myStack.push(6);
        myStack.push(5);
        System.out.println(myStack.pop().data);
        System.out.println(myStack.pop().data);
        System.out.println(myStack.pop().data);
        System.out.println(myStack.pop().data);
        System.out.println(myStack.pop().data);

    }
}
