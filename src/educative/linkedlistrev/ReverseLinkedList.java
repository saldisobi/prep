package educative.linkedlistrev;

public class ReverseLinkedList {

    LinkedListNode rootNode;

    public LinkedListNode reverse(LinkedListNode node) {

        LinkedListNode previousNode = null;

        LinkedListNode currentNode = node;

        LinkedListNode nextNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;

            currentNode.next = previousNode;

            previousNode = currentNode;

            currentNode = nextNode;
        }

        return previousNode;

    }

    public static void main(String args[]) {
        LinkedListNode linkedListNode = new LinkedListNode(1);
        linkedListNode.next = new LinkedListNode(2);
        linkedListNode.next.next = new LinkedListNode(3);
        linkedListNode.next.next.next = new LinkedListNode(4);
        linkedListNode.next.next.next.next = new LinkedListNode(5);
        linkedListNode.next.next.next.next.next = new LinkedListNode(6);

        linkedListNode =  new ReverseLinkedList().reverse(linkedListNode);

        System.out.println(linkedListNode.next.data);
        System.out.println(linkedListNode.next.next.data);
        System.out.println(linkedListNode.next.next.next.data);
        System.out.println(linkedListNode.next.next.next.next.data);
        System.out.println(linkedListNode.next.next.next.next.next.data);
    }
}
