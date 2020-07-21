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
        else if (data < prevNode.data) {
            prevNode.left = node;
        } else {
            prevNode.right = node;
        }

        return prevNode;
    }


    public Node findNode(int data) {
        Node currentNode = rootNode;
        while (currentNode != null) {
            if (currentNode.data == data) {
                return currentNode;
            } else if (data < currentNode.data) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return null;
    }


    public void delete(int data) {
        Node currentNode = rootNode;
        Node prevNode = rootNode;
        boolean isLeft = false;

        while (currentNode != null) {

            if (currentNode.data == data) {
                if (currentNode.left == null && currentNode.right == null) {
                    //it is leaf node that is to be deleted
                    if (isLeft) {
                        prevNode.left = null;
                    } else {
                        prevNode.right = null;
                    }

                } else if (currentNode.left == null && currentNode.right != null) {
                    //nothing on left but a tree on right
                    prevNode.right = currentNode.right;

                } else if (currentNode.right == null && currentNode.left != null) {
                    //nothing on right but tree on left
                    prevNode.left = currentNode.left;
                } else {
                    // tree on both sides
                    Node node = leftMostOnRight(currentNode.right);

                    currentNode.data = node.data;
                    currentNode.left = prevNode.left;
                    currentNode.right = prevNode.right;
                }
            } else if (data < currentNode.data) {
                prevNode = currentNode;
                isLeft = true;
                currentNode = currentNode.left;
            } else {
                prevNode = currentNode;
                isLeft = false;
                currentNode = currentNode.right;
            }
        }
    }

    private Node leftMostOnRight(Node node) {
        Node currentNode = node;

        while (currentNode != null) {

            if (currentNode.left == null) {
                return currentNode;
            } else {
                currentNode = currentNode.left;
            }

        }

        return null;
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

        System.out.println(bst.findNode(3).data);

        bst.delete(3);
        System.out.println(bst.findNode(6).data);

    }
}
