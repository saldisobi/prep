package countdown.stacknqueue;

public class Queue {

    Node head;
    Node tail;

    class Node {
        int data;
        Node previous;

        Node(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        if (tail == null) {
            tail = new Node(data);
            head = tail;
        } else {
            Node node = new Node(data);
            node.previous = null;

            tail.previous = node;
            tail = node;
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

    public static void main(String args[]){
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);


        System.out.println(queue.poll());

        System.out.println(queue.poll());

        System.out.println(queue.poll());
    }
}
