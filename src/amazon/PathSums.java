package amazon;


import java.util.Stack;

class PathSums {

    public static class TreeNode {
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


    public boolean hasPathSum(TreeNode rootNode, int sum) {
        if (rootNode == null)
            return false;

        int actualSum = 0;

        Stack<TreeNode> tree = new Stack<>();


        TreeNode current = rootNode;

        TreeNode lastVisited = null;

        while (current != null || !tree.isEmpty()) {

            if (current != null) {
                actualSum += current.val;
                tree.push(current);
                current = current.left;
            } else {
                TreeNode peekNode = tree.peek();

                // if right child exists and traversing node
                // from left child, then move right

                if (peekNode.right != null && lastVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    if (peekNode.left == null && peekNode.right == null) {
                        if (actualSum == sum) {
                            return true;
                        }
                    }
                    lastVisited = tree.pop();
                    actualSum = actualSum - lastVisited.val;


                    current = null;
                }
            }

        }

        return false;
    }


    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode levelOneLeftTreeNode = new TreeNode(4);
        TreeNode levelOneRightTreeNode = new TreeNode(8);

        TreeNode levelTwoLeftTreeNode = new TreeNode(11);
        TreeNode levelTwoRightLeftTreeNode = new TreeNode(13);
        TreeNode levelTwoRightRightTreeNode = new TreeNode(4);

        TreeNode levelThreeLeftTreeNode = new TreeNode(7);
        TreeNode levelThreeLeftRightTreeNode = new TreeNode(2);
        TreeNode levelThreeRightTreeNode = new TreeNode(1);

        treeNode.left = levelOneLeftTreeNode;
        treeNode.right = levelOneRightTreeNode;

        treeNode.left.left = levelTwoLeftTreeNode;
        treeNode.right.left = levelTwoRightLeftTreeNode;
        treeNode.right.right = levelTwoRightRightTreeNode;

        treeNode.left.left.left = levelThreeLeftTreeNode;
        treeNode.left.left.right = levelThreeLeftRightTreeNode;
        treeNode.right.right.right = levelThreeRightTreeNode;


        System.out.println(new PathSums().hasPathSum(treeNode, 18));

        // new PathSums().hasPathSum(treeNode, 22);
    }
}