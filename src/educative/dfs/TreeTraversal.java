package educative.dfs;

import java.util.Stack;

public class TreeTraversal {

    TreeNode rootNode;

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data) {
            this.data = data;
        }
    }


    TreeTraversal(TreeNode root) {
        this.rootNode = root;
    }


    public void inOrder() {
        if (rootNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();


        TreeNode currentNode = rootNode;

        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode == null) {
                TreeNode pop = stack.pop();
                System.out.println(pop.data);
                currentNode = pop.right;
            } else {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
        }
    }

    public void preOrder() {
        if (rootNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(rootNode);

        while (!stack.isEmpty()) {
            TreeNode popNode = stack.pop();
            System.out.println(popNode.data);

            if (popNode.right != null) {
                stack.push(popNode.right);
            }

            if (popNode.left != null) {
                stack.push(popNode.left);
            }
        }
    }

    public void postOrder() {
        if (rootNode == null) {
            return;
        }

        TreeNode currentNode;
        TreeNode lastNode = null;
        Stack<TreeNode> stack = new Stack<>();

        currentNode = rootNode;

        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode == null) {
                TreeNode peekNode = stack.peek();
                if (peekNode.left == null && peekNode.right == null) {
                    //it is a leafy node lets print it
                    System.out.println(stack.pop().data);
                    lastNode = peekNode;
                } else if (peekNode.right != null && peekNode.right != lastNode) {
                    currentNode = peekNode.right;
                } else {
                    //we have already visited its last lets print this
                    System.out.println(stack.pop().data);
                    lastNode = peekNode;
                }
            } else {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
        }
    }

    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
       /* treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);*/
        new TreeTraversal(treeNode).postOrder();
    }

}
