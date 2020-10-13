package countdown.linkedlist;

public class ReverseLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node reverseLinkedList(Node node) {

        Node current = node;

        Node prev = null;

        while (current != null) {

            Node temp = current.next;

            current.next = prev;

            prev = current;

            current = temp;

        }

        return prev;
    }

    public static void main(String args[]) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);

        Node res = new ReverseLinkedList().reverseLinkedList(node);

        Node current = res;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }


    }
}
