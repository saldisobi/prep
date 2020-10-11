package countdown.linkedlist;

public class KthLastLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }


    public int getKthFromLast(int k, Node node) {

        int mainCounter = 0;


        Node kNodesBefore = null;

        Node current = node;

        while (current != null) {
            current = current.next;

            if (mainCounter == k) {
                kNodesBefore = node;

            } else if (mainCounter > k) {
                kNodesBefore = kNodesBefore.next;
            }

            mainCounter++;
        }


        return kNodesBefore == null ? -1 : kNodesBefore.data;

    }

    public static void main(String args[]) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        System.out.println(new KthLastLinkedList().getKthFromLast(1, node));
        System.out.println(new KthLastLinkedList().getKthFromLast(2, node));
        System.out.println(new KthLastLinkedList().getKthFromLast(3, node));
        System.out.println(new KthLastLinkedList().getKthFromLast(4, node));
        System.out.println(new KthLastLinkedList().getKthFromLast(5, node));
        System.out.println(new KthLastLinkedList().getKthFromLast(6, node));
        System.out.println(new KthLastLinkedList().getKthFromLast(7, node));


    }
}
