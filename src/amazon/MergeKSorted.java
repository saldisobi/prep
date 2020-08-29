package amazon;

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSorted {
    public ReverseLinkedList.ListNode mergeKLists(ReverseLinkedList.ListNode[] lists) {

        PriorityQueue<Integer> minHeap = new PriorityQueue();

        for (int i = 0; i < lists.length; i++) {

            ReverseLinkedList.ListNode current = lists[i];

            while (current != null) {
                minHeap.add(current.val);
                current = current.next;
            }

        }

        ReverseLinkedList.ListNode result = null;

        ReverseLinkedList.ListNode head = null;

        while (!minHeap.isEmpty()) {

            if (result == null) {
                result = new ReverseLinkedList.ListNode(minHeap.remove());
                head = result;
            } else {
                head.next = new ReverseLinkedList.ListNode(minHeap.remove());

                head = head.next;
            }

        }

        return result;


    }
}