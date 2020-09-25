package educative.dfs;


public class PathSum {

    TreeNode rootNode;

    PathSum(TreeNode root) {
        rootNode = root;

    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data) {
            this.data = data;
        }

    }

    public boolean hasSum(int sum, TreeNode root) {

        if (sum == 0) {
            return true;
        }
        if (root == null) {
            return false;
        }

        return hasSum(sum - root.data, root.left) || hasSum(sum - root.data, root.right);


    }

    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(1);
        treeNode.right = new TreeNode(1);
        System.out.println(new PathSum(treeNode).hasSum(1, treeNode));
    }
}
