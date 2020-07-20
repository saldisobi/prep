package datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    ArrayList<LinkedList<Integer>> graph = new ArrayList<>();

    boolean[] visited;

    Graph(int size) {
        visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            graph.add(new LinkedList<>());
            visited[i] = false;
        }


    }

    public void addEdge(int start, int end) {
        if (start < 0 || end < 0 || start > (graph.size() - 1) || end > (graph.size() - 1)) {
            throw new IndexOutOfBoundsException("please check");
        }
        graph.get(start).add(end);
    }

    public void depthFirstSearch() {

        Stack<Integer> myStack = new Stack<>();

        myStack.push(0);

        while (!myStack.isEmpty()) {
            int node = myStack.pop();
            visited[node] = true;
            System.out.println(node);
            for (int i = 0; i < graph.get(node).size(); i++) {
                if (!visited[graph.get(node).get(i)])
                    myStack.push(graph.get(node).get(i));
            }
        }
    }


    public void breadthFirstSearch() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            System.out.println(node);
            for (int i = 0; i < graph.get(node).size(); i++) {
                if (!visited[graph.get(node).get(i)])
                    queue.add(graph.get(node).get(i));
            }
        }
    }

    public static void main(String args[]) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        graph.breadthFirstSearch();

        System.out.println("*************************");

        Graph graph1 = new Graph(8);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 3);
        graph1.addEdge(2, 4);
        graph1.addEdge(3, 5);
        graph1.addEdge(4, 6);
        graph1.addEdge(5, 7);
        graph1.addEdge(6, 7);

        graph1.depthFirstSearch();
    }

}
