package countdown.graphtheory;

import java.util.*;

public class Dijkstra {

    static class Edge {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

    }

    static class Node {
        int nodeId;
        int shortestDisToSource;

        Node(int nodeId, int shortestDisToSource) {
            this.nodeId = nodeId;
            this.shortestDisToSource = shortestDisToSource;
        }

    }


    static class Graph {
        private final HashMap<Integer, List<Edge>> graph = new HashMap<>();

        private final int size;

        Graph(int size) {
            this.size = size;
            for (int i = 0; i < size; i++) {
                graph.put(i, new ArrayList<>());
            }
        }

        public void addEdge(int from, int to, int weight) {

            graph.get(from).add(new Edge(from, to, weight));

        }


        public List<Edge> getEdgesFromSource(int source) {
            return graph.get(source);
        }

        public int getSize() {
            return size;
        }

    }


    /**
     * @param source
     * @param end
     * @param graph
     * @return
     */
    public int getShortestPath(int source, int end, Graph graph) {

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.shortestDisToSource));

        int[] distance = new int[graph.size];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        priorityQueue.add(new Node(source, 0));

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();


            if (distance[node.nodeId] < node.shortestDisToSource) continue;

            List<Edge> edges = graph.getEdgesFromSource(node.nodeId);


            if (edges != null) {
                for (Edge edge : edges) {
                    int distanceFromHere = distance[edge.from] + edge.weight;
                    if (distanceFromHere < distance[edge.to]) {
                        distance[edge.to] = distanceFromHere;
                        priorityQueue.add(new Node(edge.to, distance[edge.to]));
                    }
                }
            }

            if (node.nodeId == end) return distance[end];
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 3, 7);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 5);
        graph.addEdge(2, 4, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(4, 3, 2);

        System.out.println(new Dijkstra().getShortestPath(0, 5, graph));
    }
}
