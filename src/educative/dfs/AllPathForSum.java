package educative.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathForSum {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data) {
            this.data = data;
        }
    }

    TreeNode rootNode;

    AllPathForSum(TreeNode treeNode) {
        this.rootNode = treeNode;
    }

    public List<List<TreeNode>> getAllPathForSum(TreeNode treeNode, int sum) {
        List<List<TreeNode>> result = new ArrayList<>();

        getAllPathForSum(result, treeNode, sum, 0, new ArrayList<>());

        return result;
    }

    private void getAllPathForSum(List<List<TreeNode>> result, TreeNode treeNode, int sum, int currentSum, List<TreeNode> currentList) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null) {
            //it is leaf node
            if (treeNode.data + currentSum == sum) {
                currentList.add(treeNode);
                result.add(currentList);
            }
        } else if (treeNode.left != null) {
            ArrayList<TreeNode> list = new ArrayList<>(currentList);
            list.add(treeNode.left);
            getAllPathForSum(result, treeNode.left, sum, currentSum + treeNode.data, list);
        } else if (treeNode.right != null) {
            ArrayList<TreeNode> list = new ArrayList<>(currentList);
            list.add(treeNode.right);
            getAllPathForSum(result, treeNode.right, currentSum + treeNode.data, currentSum, list);
        }

    }


    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        List<List<TreeNode>> res = new AllPathForSum(treeNode).getAllPathForSum(treeNode, 3);

        System.out.println(res.get(0).get(0).data);
        System.out.println(res.get(0).get(1).data);
    }
}
