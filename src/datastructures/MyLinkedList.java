package datastructures;

public class MyLinkedList<E> {
    private Node head;

    class Node<E> {
        private E data;
        public Node next;

        Node(E val) {
            this.data = val;
        }
    }

    public void add(E data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }


    public void remove(E data) {
        if (head.data == data) {
            head = head.next;
        } else {
            Node current = head;
            while (current.next != null) {
                if (current.next.data == data) {
                    current.next = current.next.next;
                    break;
                } else {
                    current = current.next;
                }
            }
        }
    }


    public void printLinkedList() {
        if (head == null) {
            System.out.println("empty list");
        } else {
            Node current = head;
            while (current != null) {
                System.out.println(current.data.toString());
                current = current.next;
            }
        }
    }

    public static void main(String args[]) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);

        myLinkedList.remove(3);

        myLinkedList.printLinkedList();


    }
}
