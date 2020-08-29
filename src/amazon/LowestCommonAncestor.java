package amazon;

public class LowestCommonAncestor {

    public static class LcaTreeNode {
        int val;
        LcaTreeNode left;
        LcaTreeNode right;

        LcaTreeNode() {
        }

        LcaTreeNode(int val) {
            this.val = val;
        }

        LcaTreeNode(int val, LcaTreeNode left, LcaTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public LcaTreeNode getLowestCommonAncestor(LcaTreeNode rootNode, LcaTreeNode nodeOne, LcaTreeNode nodeTwo) {

        if (rootNode == null) {
            return null;
        }

        if (rootNode == nodeOne || rootNode == nodeTwo) {
            return rootNode;
        }

        LcaTreeNode left = getLowestCommonAncestor(rootNode.left, nodeOne, nodeTwo);

        LcaTreeNode right = getLowestCommonAncestor(rootNode.right, nodeOne, nodeTwo);

        if (left != null && right != null) {
            return rootNode;
        }

        if (left == null && right == null) {
            return null;
        }

        if (left != null) {
            return left;
        }

        return right;
    }
}
