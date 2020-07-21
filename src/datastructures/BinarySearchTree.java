package datastructures;

public class BinarySearchTree {

    Node rootNode;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;

        }
    }

    public Node add(int data) {
        Node node = new Node(data);
        if (rootNode == null) {
            rootNode = node;
            return node;
        }

        Node currentNode = rootNode;
        Node prevNode = null;
        while (currentNode != null) {
            prevNode = currentNode;
            if (data < currentNode.data) {

                currentNode = currentNode.left;
            } else {

                currentNode = currentNode.right;
            }
        }
        if (prevNode == null)
            prevNode = node;
        else if (data<prevNode.data) {
            prevNode.left = node;
        } else {
            prevNode.right = node;
        }

        return prevNode;
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5);
        bst.add(3);
        bst.add(2);
        bst.add(4);
        bst.add(7);
        bst.add(6);
        bst.add(9);


    }
}
