package datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyTree {

    Node rootNode;

    static class Node {
        int data;
        Node leftChild;
        Node rightChild;

        Node(int data) {
            this.data = data;
        }
    }

    public void inOrder() {
        Stack<Node> myStack = new Stack();
        Node currentNode = rootNode;
        while (!myStack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                myStack.add(currentNode);
                currentNode = currentNode.leftChild;
            } else {
                Node popNode = myStack.pop();
                System.out.println(popNode.data);
                if (popNode.rightChild != null)
                    currentNode = popNode.rightChild;
            }
        }
    }


    public void preorder() {
        Stack<Node> myStack = new Stack<>();
        myStack.push(rootNode);
        while (!myStack.isEmpty()) {
            Node popNode = myStack.pop();
            System.out.println(popNode.data);
            if (popNode.rightChild != null)
                myStack.push(popNode.rightChild);
            if (popNode.leftChild != null)
                myStack.push(popNode.leftChild);
        }
    }


    private void postOrder() {
        Stack<Node> myStack = new Stack();
        Node currentNode = rootNode;
        Node previousNode = null;

        while (!myStack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                myStack.add(currentNode);
                currentNode = currentNode.leftChild;
            } else {
                Node peekNode = myStack.peek();
                if (peekNode.rightChild != null && peekNode.rightChild != previousNode) {
                    currentNode = peekNode.rightChild;

                } else {
                    System.out.println(peekNode.data);
                    previousNode = myStack.pop();
                }
            }
        }

    }

    private void levelTraverse() {
        Queue<Node> myQueue = new LinkedList<>();


        myQueue.add(rootNode);
        myQueue.add(null);

        Node lastAdded = null;

        while (!myQueue.isEmpty()) {
            Node current = myQueue.poll();

            if (current != null) {
                System.out.println(current.data);
                if (current.leftChild != null) {
                    myQueue.add(current.leftChild);
                    lastAdded = current.leftChild;
                }

                if (current.rightChild != null) {
                    myQueue.add(current.rightChild);
                    lastAdded = current.rightChild;
                }
            } else {
                if (lastAdded != null) {
                    myQueue.add(null);
                    lastAdded = null;
                }
            }


        }
    }


    public static void main(String args[]) {
        MyTree myTree = new MyTree();
        Node node = new Node(5);
        node.leftChild = new Node(4);
        node.leftChild.leftChild = new Node(11);
        node.leftChild.leftChild.leftChild = new Node(7);
        node.leftChild.leftChild.rightChild = new Node(2);
        node.rightChild = new Node(8);
        node.rightChild.rightChild = new Node(9);
        node.rightChild.leftChild = new Node(13);

        myTree.rootNode = node;

        myTree.inOrder();
        System.out.println("inorder finished");
        myTree.preorder();
        System.out.println("preorder finished");
        myTree.postOrder();
        System.out.println("postOrder finished");
        myTree.levelTraverse();
        System.out.println("BFS finished");

    }
}
