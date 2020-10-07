package countdown.graphtheory;

import java.util.*;

public class TopSort {

    static class Graph {

        public int size;

        private HashMap<Integer, List<Integer>> graph = new HashMap();

        Graph(int size) {
            this.size = size;
            for (int i = 0; i < size; i++) {
                graph.put(i, new ArrayList<>());
            }

        }

        public void addEdge(int from, int to) {
            graph.get(from).add(to);
        }

    }


    public Stack<Integer> topSort(Graph graph) {

        boolean[] visited = new boolean[graph.size];

        Stack<Integer> stack = new Stack();

        int currentPointer = graph.size - 1;

        for (int i = 0; i < graph.size; i++) {
            if (!visited[i]) {
                dfs(graph, stack, currentPointer, visited, i);
            }
        }

        return stack;

    }

    private void dfs(Graph graph, Stack<Integer> stack, int currentPointer, boolean[] visited, int index) {
        if (!visited[index]) {
            visited[index] = true;
            List<Integer> edges = graph.graph.get(index);
            if (edges == null) {
                return;
            }

            for (int i = 0; i < edges.size(); i++) {
                if (!visited[edges.get(i)]) {
                    dfs(graph, stack, currentPointer, visited, edges.get(i));
                }
            }
        }

        stack.push(index);
    }

    public static void main(String rgs[]) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(5, 4);
        Stack<Integer> res = new TopSort().topSort(graph);
        while (!res.isEmpty()) {
            System.out.println(res.pop());
        }
    }
}
