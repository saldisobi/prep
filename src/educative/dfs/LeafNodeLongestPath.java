package educative.dfs;

public class LeafNodeLongestPath {

    int maxDia = 0;

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data) {
            this.data = data;
        }
    }



    public int longestPathBetweenNodes(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            int leftHeight = longestPathBetweenNodes(treeNode.left);
            int rightHeight = longestPathBetweenNodes(treeNode.right);
            int dia = leftHeight + rightHeight + 1;
            if(dia>maxDia)
                maxDia = dia;
        }

        return maxDia;

    }

    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right =  new TreeNode(3);
        System.out.println(new LeafNodeLongestPath().longestPathBetweenNodes(treeNode));
    }
}
