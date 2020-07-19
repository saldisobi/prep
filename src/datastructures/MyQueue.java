package datastructures;

public class MyQueue<T> {

    Node<T> front;
    Node<T> tail;

    int size = 0;

    class Node<T> {
        Node<T> previous;
        T data;

        Node(T data) {
            this.data = data;
        }
    }

    public void enqueue(T data) {
        Node node = new Node(data);

        Node temp = tail;
        tail = node;
        tail.previous = null;
        if (isEmpty()) {
            front = tail;
        } else {
            temp.previous = tail;
        }

        size++;

        System.out.println(data + " added to the queue");

    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Node<T> dequeue() {
        if (front == null) {
            throw new IllegalStateException("empty");
        } else {
            Node tempFront = front;
            front = front.previous;
            if (isEmpty()) {
                tail = null;
            }
            size--;
            System.out.println(tempFront.data + " removed from queue");
            return tempFront;
        }

    }


    public static void main(String args[]) {
        MyQueue<Integer> queue = new MyQueue();
        queue.enqueue(6);
        queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(99);
        queue.enqueue(56);
        queue.dequeue();
        queue.enqueue(43);
        queue.dequeue();
        queue.enqueue(89);
        queue.enqueue(77);
        queue.dequeue();
        queue.enqueue(32);
        queue.enqueue(232);
    }
}
