package countdown.linkedlist;

import java.util.Stack;

public class LinkedListPalindrome {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

    }


    public boolean isLinkedListPalindrome(Node node) {
        Node current = node;
        Stack<Integer> stack = new Stack<>();
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        current = node;

        while (current != null) {
            if (current.data != stack.pop()) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    public static void main(String args[]) {
        Node node = new Node(1);
        node.next = new Node(0);
        node.next.next = new Node(0);
        node.next.next = new Node(0);
        System.out.println(new LinkedListPalindrome().isLinkedListPalindrome(node));
    }
}
