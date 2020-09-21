package educative.linkedlistrev;

public class ReverseSubLinkedList {

    LinkedListNode rootNode;


    private LinkedListNode reverseSubList(LinkedListNode node, int start, int end) {
        if (node == null) {
            return null;
        }

        if (start > end) {
            return node;
        }

        LinkedListNode current = node;

        LinkedListNode previous = null;

        while (start > 1) {
            previous = current;
            current = current.next;

            start--;
            end--;
        }

        LinkedListNode connection = previous, tail = current;

        LinkedListNode tempCurrent = null;

        while (end > 0) {
            tempCurrent = current.next;
            current.next = previous;
            previous = current;
            current = tempCurrent;
            end--;
        }

        if(connection!=null){
            connection.next = previous;
        }else{
            node = previous;
        }

        tail.next = current;

        return node;

    }

    public static void main(String args[]) {
        LinkedListNode linkedListNode = new LinkedListNode(1);
        linkedListNode.next = new LinkedListNode(2);
        linkedListNode.next.next = new LinkedListNode(3);
        linkedListNode.next.next.next = new LinkedListNode(4);
        linkedListNode.next.next.next.next = new LinkedListNode(5);
        linkedListNode.next.next.next.next.next = new LinkedListNode(6);

        linkedListNode = new ReverseSubLinkedList().reverseSubList(linkedListNode, 2, 3);

        System.out.println(linkedListNode.data);
        System.out.println(linkedListNode.next.data);
        System.out.println(linkedListNode.next.next.data);
        System.out.println(linkedListNode.next.next.next.data);
        System.out.println(linkedListNode.next.next.next.next.data);
        System.out.println(linkedListNode.next.next.next.next.next.data);
    }


}
