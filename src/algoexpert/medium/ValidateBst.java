package algoexpert.medium;

import datastructures.BinarySearchTree;

import java.util.Stack;

public class ValidateBst {


    public boolean isValidBst(BinarySearchTree binarySearchTree) {

        BinarySearchTree.Node node = binarySearchTree.rootNode;

        Stack<BinarySearchTree.Node> stack = new Stack<>();

        stack.add(node);

        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node.left != null && node.left.data < node.data) {
                stack.add(node.left);
            }
            if (node.right != null && node.right.data >= node.data) {
                stack.add(node.right);
            }

            if (node.left != null && node.left.data >= node.data) {
                return false;
            }
            if (node.right != null && node.right.data < node.data) {
                return false;
            }

        }

        return true;
    }

    public static void main(String args[]){
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(3);
        bst.add(2);
        bst.add(4);
        bst.add(7);
        bst.add(6);
        bst.add(9);

        System.out.println(new ValidateBst().isValidBst(bst));
    }
}
