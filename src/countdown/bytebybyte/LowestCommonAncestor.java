package countdown.bytebybyte;


public class LowestCommonAncestor {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }


    public TreeNode getLca(TreeNode root, TreeNode first, TreeNode second) {

        if (root == null) {
            return null;
        }

        if (root == first || root == second) {
            return root;
        }

        TreeNode left = getLca(root, first, second);
        TreeNode right = getLca(root, first, second);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;

    }

    public static void main(String args[]){

    }
}
