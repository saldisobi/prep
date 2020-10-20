package countdown.bytebybyte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BuildOrder {

    static class Graph {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        Graph(int size) {
            for (int i = 0; i < size; i++) {
                graph.put(i, new ArrayList<>());
            }
        }

        public int getSize() {
            return graph.size();
        }

        public void addEdge(int from, int to) {

            graph.get(from).add(to);

        }

    }

    public Stack<Integer> topSort(Graph graph) {

        Stack<Integer> result = new Stack<>();

        boolean[] visited = new boolean[graph.getSize()];


        for (int i = 0; i < graph.getSize(); i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, result);
            }
        }

        return result;

    }

    private void dfs(Graph graph, int i, boolean[] visited, Stack<Integer> result) {
        if (!visited[i]) {
            visited[i] = true;

            List<Integer> edges = graph.graph.get(i);

            for (int edge : edges) {
                if (!visited[edge]) {
                    dfs(graph, edge, visited, result);
                }
            }
        }

        result.add(i);
    }

    public static void main(String args[]) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        Stack<Integer> stack = new BuildOrder().topSort(graph);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
