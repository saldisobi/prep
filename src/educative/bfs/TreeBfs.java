package educative.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBfs {

    TreeNode mRootNode = null;

    static class TreeNode {
        TreeNode left;
        TreeNode right;

        int data;

        TreeNode(int data) {
            this.data = data;
        }
    }

    TreeBfs(TreeNode rootNode) {
        this.mRootNode = rootNode;
    }


    public void treeBfs() {

        Queue<TreeNode> myQueue = new LinkedList<>();

        myQueue.offer(mRootNode);

        while (!myQueue.isEmpty()){
            TreeNode currentNode = myQueue.poll();
            System.out.println(currentNode.data);
            if(currentNode.left !=null){
                myQueue.offer(currentNode.left);
            }

            if(currentNode.right !=null){
                myQueue.offer(currentNode.right);
            }
        }

    }


    public static void main(String args[]){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        new TreeBfs(treeNode).treeBfs();
    }
}


