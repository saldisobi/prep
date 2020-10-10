package countdown.graphtheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BellmanFordAdjacency {

    final Integer deemedPositiveInfinity = 1000000;

    class Edge {
        int from;
        int to;
        int weight;

        /**
         * @param from
         * @param to
         * @param weight
         */
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    class Graph {
        private HashMap<Integer, List<Edge>> graph = new HashMap<>();

        private int size;

        /**
         * @param size
         */
        Graph(int size) {
            this.size = size;

            for (int i = 0; i < size; i++) {
                graph.put(i, new ArrayList<>());
            }

        }

        /**
         * @param from
         * @param edge
         */
        public void addEdge(int from, Edge edge) {
            graph.get(from).add(edge);
        }


        public List<Edge> getEdgeList(int from) {
            return graph.get(from);
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
        int[] distance = new int[graph.size];

        Arrays.fill(distance, deemedPositiveInfinity);

        distance[source] = 0;
        for (int j = 0; j < graph.size - 1; j++) {
            for (int i = 0; i < graph.size; i++) {
                List<Edge> edges = graph.getEdgeList(i);
                for (Edge edge : edges) {
                    if (distance[edge.to] > distance[edge.from] + edge.weight) {
                        distance[edge.to] = distance[edge.from] + edge.weight;
                    }
                }
            }
        }

        return distance[end];
    }

}
