package educative.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BfsLineBreak {

    TreeNode mRootNode = null;

    static class TreeNode {
        TreeNode left;
        TreeNode right;

        int data;

        TreeNode(int data) {
            this.data = data;
        }
    }

    BfsLineBreak(TreeNode rootNode) {
        this.mRootNode = rootNode;
    }


    public void zigZagTraversal() {

        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.offer(mRootNode);
        myQueue.offer(null);
        TreeNode lastNode = mRootNode;

        while (!myQueue.isEmpty()) {
            TreeNode currentNode = myQueue.poll();
            if (currentNode == null) {
                System.out.println();
                if (lastNode == null) {
                    break;
                } else {
                    myQueue.offer(null);
                }
            } else {
                System.out.print(currentNode.data);
                if (currentNode.left != null) {
                    myQueue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    myQueue.offer(currentNode.right);
                }
            }

            lastNode = currentNode;
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
        new BfsLineBreak(treeNode).zigZagTraversal();
    }
}


