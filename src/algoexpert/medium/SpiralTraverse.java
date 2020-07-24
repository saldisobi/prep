package algoexpert.medium;

import java.util.Stack;

public class SpiralTraverse {

    SpiralTreeNode rootNode;

    static class SpiralTreeNode {
        SpiralTreeNode leftNode;
        SpiralTreeNode rightNode;
        int data;

        SpiralTreeNode(int data) {
            this.data = data;
        }

    }

    public void traverseSpiral() {
        boolean isLeftToRight = true;

        Stack<SpiralTreeNode> stackLeft = new Stack<>();

        Stack<SpiralTreeNode> stackRight = new Stack<>();

        stackLeft.add(rootNode);

        while (!stackLeft.isEmpty() || !stackRight.isEmpty()) {

            if (isLeftToRight && stackLeft.isEmpty()) {
                isLeftToRight = !isLeftToRight;
            } else if (!isLeftToRight && stackRight.isEmpty()) {
                isLeftToRight = !isLeftToRight;
            }

            if (isLeftToRight) {
                SpiralTreeNode node = stackLeft.pop();

                System.out.println(node.data);

                if (node.leftNode != null) {
                    stackRight.add(node.leftNode);
                }
                if (node.rightNode != null) {
                    stackRight.add(node.rightNode);
                }
            } else {
                SpiralTreeNode node = stackRight.pop();

                System.out.println(node.data);

                if (node.rightNode != null) {
                    stackLeft.add(node.rightNode);
                }
                if (node.leftNode != null) {
                    stackLeft.add(node.leftNode);
                }
            }

        }
    }

    public static void main(String args[]) {
        SpiralTraverse spiralTraverse = new SpiralTraverse();
        SpiralTreeNode node = new SpiralTreeNode(1);

        node.leftNode = new SpiralTreeNode(2);
        node.rightNode = new SpiralTreeNode(3);


        node.leftNode.leftNode = new SpiralTreeNode(4);
        node.leftNode.rightNode = new SpiralTreeNode(5);

        node.rightNode.leftNode = new SpiralTreeNode(6);
        node.rightNode.rightNode = new SpiralTreeNode(7);

        spiralTraverse.rootNode = node;

        spiralTraverse.traverseSpiral();
    }
}
