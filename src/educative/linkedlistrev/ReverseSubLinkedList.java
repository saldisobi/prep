package educative.linkedlistrev;

public class ReverseSubLinkedList {

    LinkedListNode rootNode;

    public LinkedListNode reverseList(LinkedListNode node) {

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

    private LinkedListNode reverseSubList(LinkedListNode linkedListNode, int start) {

        LinkedListNode currentNode = linkedListNode;

        int currentCounter = 0;

        while (currentCounter < start && currentNode != null) {
            currentNode = currentNode.next;
            currentCounter++;
        }

        currentNode.next = reverseList(currentNode);

        return linkedListNode;


    }

    public static void main(String args[]) {
        LinkedListNode linkedListNode = new LinkedListNode(1);
        linkedListNode.next = new LinkedListNode(2);
        linkedListNode.next.next = new LinkedListNode(3);
        linkedListNode.next.next.next = new LinkedListNode(4);
        linkedListNode.next.next.next.next = new LinkedListNode(5);
        linkedListNode.next.next.next.next.next = new LinkedListNode(6);

        linkedListNode = new ReverseSubLinkedList().reverseSubList(linkedListNode, 0);

        System.out.println(linkedListNode.data);
        System.out.println(linkedListNode.next.data);
        System.out.println(linkedListNode.next.next.data);
        System.out.println(linkedListNode.next.next.next.data);
        System.out.println(linkedListNode.next.next.next.next.data);
        System.out.println(linkedListNode.next.next.next.next.next.data);
    }


}
