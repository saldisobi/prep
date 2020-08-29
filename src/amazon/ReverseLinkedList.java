package amazon;

public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode currentNode = head;

        ListNode previousNode = null;

        while (currentNode != null) {
            ListNode tempNode = currentNode.next;

            currentNode.next = previousNode;

            previousNode = currentNode;

            currentNode = tempNode;

        }

        return previousNode;

    }

    public static void main(String args[]) {

        ListNode listNode = new ListNode(1);

        listNode.next = new ListNode(2);

        listNode.next.next = new ListNode(3);

        listNode.next.next.next = new ListNode(4);

        listNode.next.next.next.next = new ListNode(5);

        new ReverseLinkedList().reverseList(listNode);
    }
}



