package algoexpert.medium;


import java.util.LinkedList;
import java.util.Queue;


class MinDepthTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> myQueue = new LinkedList<TreeNode>();

        myQueue.add(root);

        myQueue.add(null);

        int currentDepth = 1;

        TreeNode lastNode = root;

        while (!myQueue.isEmpty()) {
            TreeNode pollNode = myQueue.poll();

            if (pollNode == null) {
                if (lastNode != null) {
                    myQueue.add(null);
                    currentDepth++;
                }
            } else {
                if (pollNode.left == null && pollNode.right == null) {
                    return currentDepth;
                }

                if (pollNode.left != null) {
                    myQueue.add(pollNode.left);
                }
                if (pollNode.right != null) {
                    myQueue.add(pollNode.right);
                }


            }


        }

        return currentDepth;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}