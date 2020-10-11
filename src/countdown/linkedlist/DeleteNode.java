package countdown.linkedlist;

public class DeleteNode {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node deleteNode(Node node, int data) {

        if (node == null) {
            return null;
        }

        if (node.data == data) {
            return node.next;
        }
        Node prev = null;

        Node current = node;

        while (current != null) {

            if (current.data == data) {
                prev.next = current.next;
                return node;
            }

            prev = current;

            current = current.next;
        }

        return node;

    }

    public static void main(String args[]) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);

        Node res = new DeleteNode().deleteNode(node, 4);

        Node current = res;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }


    }
}
