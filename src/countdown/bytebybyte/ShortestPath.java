package countdown.bytebybyte;

import java.util.*;


public class ShortestPath {

    class Graph {
        HashMap<Integer, ArrayList<Edge>> graph = new HashMap<>();

        public void addEdge(int from, Edge edge) {

            ArrayList<Edge> edges = graph.getOrDefault(from, new ArrayList<>());
            edges.add(edge);
            graph.put(from, edges);
        }

        public List<Edge> getEdgesFromSource(int source) {
            return graph.get(source);
        }

    }

    class Edge {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;

        }
    }


    class Node {
        int nodeId;
        int shortestDistanceToSource;

        public Node(int source, int dis) {
            nodeId = source;
            shortestDistanceToSource = dis;
        }
    }


    public int getShortestDistance(int source, int destination, Graph graph) {
        int[] distance = new int[graph.graph.size()];

        Arrays.fill(distance, 1000);

        distance[source] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a, b) -> a.shortestDistanceToSource - b.shortestDistanceToSource);

        priorityQueue.add(new Node(source, 0));

        while (!priorityQueue.isEmpty()) {

            Node node = priorityQueue.poll();

            if (distance[node.nodeId] < node.shortestDistanceToSource) continue;

            List<Edge> edges = graph.getEdgesFromSource(node.nodeId);

            for (Edge edge : edges) {
                int distanceViaThis = distance[edge.from] + edge.weight;

                if (distanceViaThis < distance[edge.to]) {
                    distance[edge.to] = distanceViaThis;
                    priorityQueue.add(new Node(edge.to, distanceViaThis));
                }
            }

            if (node.nodeId == destination) return distance[node.nodeId];
        }

        return Integer.MAX_VALUE;
    }
}
