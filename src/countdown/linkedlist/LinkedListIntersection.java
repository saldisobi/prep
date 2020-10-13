package countdown.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListIntersection {
    static class InteractionNode {
        int data;
        InteractionNode next;

        InteractionNode(int data) {
            this.data = data;
        }

    }


    public boolean isIntersecting(InteractionNode interactionNodeOne, InteractionNode interactionNodeTwo) {
        InteractionNode current = interactionNodeOne;

        Set<InteractionNode> interactionSet = new HashSet<>();

        while (current != null) {
            interactionSet.add(current);
            current = current.next;
        }

        current = interactionNodeTwo;


        while (current != null) {
            if (interactionSet.contains(current)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public static void main(String args[]) {
        InteractionNode node1 = new InteractionNode(1);
        InteractionNode node2 = new InteractionNode(2);
        InteractionNode node3 = new InteractionNode(3);
        InteractionNode node4 = new InteractionNode(4);
        InteractionNode node5 = new InteractionNode(5);
        InteractionNode node6 = new InteractionNode(6);

        InteractionNode nodeTwoThree = new InteractionNode(3);

        InteractionNode nodeTwoFour = new InteractionNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        nodeTwoThree.next = nodeTwoFour;
        nodeTwoFour.next = node5;
        node5.next = node6;

        System.out.println(new LinkedListIntersection().isIntersecting(node1,null));

    }
}
