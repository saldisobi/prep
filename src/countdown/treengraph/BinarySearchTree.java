package countdown.treengraph;

public class BinarySearchTree {

    Node rootNode;

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }


    public void put(int data) {
        if (rootNode == null) {
            rootNode = new Node(data);
        } else {
            put(data, rootNode);
        }
    }

    private void put(int data, Node node) {
        if (data < node.data && node.left != null) {
            put(data, node.left);
        } else if (data > node.data && node.right != null) {
            put(data, node.right);
        } else if (data < node.data) {
            node.left = new Node(data);
        } else if (data > node.data) {
            node.right = new Node(data);
        } else {
            System.out.println("duplicates not allowed");
        }
    }


    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(3);
        bst.put(4);
        bst.put(1);
        bst.put(2);



        System.out.println(bst.rootNode.data);
        System.out.println(bst.rootNode.right.data);
        System.out.println(bst.rootNode.left.data);
        System.out.println(bst.rootNode.left.right.data);


    }
}
