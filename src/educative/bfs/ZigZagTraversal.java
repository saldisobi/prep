package educative.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversal {

    TreeNode mRootNode = null;

    static class TreeNode {
        TreeNode left;
        TreeNode right;

        int data;

        TreeNode(int data) {
            this.data = data;
        }
    }

    ZigZagTraversal(TreeNode rootNode) {
        this.mRootNode = rootNode;
    }


    public void zigZagTraversal() {
        Stack<TreeNode> leftToRight = new Stack<>();

        Stack<TreeNode> rightToLeft = new Stack<>();

        boolean isLeftToRight = true;

        leftToRight.push(mRootNode);

        while (!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
            if (isLeftToRight) {
                if (leftToRight.isEmpty()) {
                    isLeftToRight = false;
                } else {
                    TreeNode treeNode = leftToRight.pop();
                    System.out.println(treeNode.data);
                    if (treeNode.left != null) {
                        rightToLeft.push(treeNode.left);
                    }

                    if (treeNode.right != null) {
                        rightToLeft.push(treeNode.right);
                    }
                }

            } else {
                if (rightToLeft.isEmpty()) {
                    isLeftToRight = true;
                } else {
                    TreeNode treeNode = rightToLeft.pop();
                    System.out.println(treeNode.data);
                    if (treeNode.right != null) {
                        leftToRight.push(treeNode.right);
                    }

                    if (treeNode.left != null) {
                        leftToRight.push(treeNode.left);
                    }
                }
            }
        }
    }


    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        new ZigZagTraversal(treeNode).zigZagTraversal();
    }
}


