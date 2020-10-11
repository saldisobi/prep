package countdown.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {


    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public Node removeDuplicates(Node node) {

        Node current = node;

        Node prev = null;

        HashSet<Integer> hashSet = new HashSet<>();

        while (current != null) {
            if (hashSet.contains(current.data)) {
                prev.next = current.next;
            } else {
                hashSet.add(current.data);
                prev = current;
            }
            current = current.next;
        }

        return node;
    }

    public static void printLinkedList(Node node) {
        Node current = node;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String args[]) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(2);
        node.next.next.next.next = new Node(1);
        node.next.next.next.next.next = new Node(4);


        Node res = new RemoveDuplicates().removeDuplicates(node);

        printLinkedList(res);


    }
}
