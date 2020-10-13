package countdown.linkedlist;

public class LoopLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node isLoop(Node node) {

        Node slow = node;
        Node fast = node;

        boolean loopDetected = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            if (loopDetected) {
                fast = fast.next;
            } else {
                fast = fast.next.next;
            }

            if (slow == fast && loopDetected) {

                return slow;

            } else if (slow == fast) {
                loopDetected = true;
                slow = node;
            }

        }

return node;
    }

    public static void main(String args[]) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node4;

        System.out.println(new LoopLinkedList().isLoop(node1).data);

    }
}
