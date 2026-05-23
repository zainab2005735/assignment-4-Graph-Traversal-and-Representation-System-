
Replace your entire `Graph.java` with this complete version:

        ```java
import java.util.*;

public class Graph {

    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Edge>> adjList;

    public boolean printPath = true;

    public Graph() {

        this.vertices = new HashMap<>();
        this.adjList = new HashMap<>();
    }

    // Add vertex
    public void addVertex(Vertex v) {

        vertices.put(v.getId(), v);
        adjList.putIfAbsent(v.getId(),
                new ArrayList<>());
    }

    // Add weighted undirected edge
    public void addEdge(int from,
                        int to,
                        int weight) {

        if (!vertices.containsKey(from)
                || !vertices.containsKey(to)) {

            return;
        }

        adjList.get(from).add(
                new Edge(from, to, weight));

        adjList.get(to).add(
                new Edge(to, from, weight));
    }

    // Print graph
    public void printGraph() {

        for (int id : adjList.keySet()) {

            System.out.print(
                    "Vertex "
                            + id
                            + " is connected to: ");

            for (Edge edge : adjList.get(id)) {

                System.out.print(
                        edge.getDestination()
                                + "(weight="
                                + edge.getWeight()
                                + ") ");
            }

            System.out.println();
        }
    }

    // Breadth-First Search
    public void bfs(int start) {

        if (!vertices.containsKey(start))
            return;

        Set<Integer> visited =
                new HashSet<>();

        Queue<Integer> queue =
                new LinkedList<>();

        visited.add(start);
        queue.add(start);

        if (printPath)
            System.out.print("BFS Path: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();

            if (printPath)
                System.out.print(current + " ");

            for (Edge edge : adjList.get(current)) {

                if (!visited.contains(
                        edge.getDestination())) {

                    visited.add(
                            edge.getDestination());

                    queue.add(
                            edge.getDestination());
                }
            }
        }

        if (printPath)
            System.out.println();
    }

    // Depth-First Search
    public void dfs(int start) {

        if (!vertices.containsKey(start))
            return;

        Set<Integer> visited =
                new HashSet<>();

        if (printPath)
            System.out.print("DFS Path: ");

        dfsHelper(start, visited);

        if (printPath)
            System.out.println();
    }

    // DFS helper
    private void dfsHelper(int current,
                           Set<Integer> visited) {

        visited.add(current);

        if (printPath)
            System.out.print(current + " ");

        for (Edge edge : adjList.get(current)) {

            if (!visited.contains(
                    edge.getDestination())) {

                dfsHelper(
                        edge.getDestination(),
                        visited);
            }
        }
    }

    // Dijkstra Algorithm
    public void dijkstra(int start) {

        Map<Integer, Integer> distance =
                new HashMap<>();

        Set<Integer> visited =
                new HashSet<>();

        // Initialize distances
        for (int vertexId : vertices.keySet()) {

            distance.put(vertexId,
                    Integer.MAX_VALUE);
        }

        // Starting vertex
        distance.put(start, 0);

        // Main algorithm
        while (visited.size()
                < vertices.size()) {

            int current = -1;

            int minDistance =
                    Integer.MAX_VALUE;

            // Find nearest unvisited vertex
            for (int vertexId :
                    distance.keySet()) {

                if (!visited.contains(vertexId)
                        && distance.get(vertexId)
                        < minDistance) {

                    minDistance =
                            distance.get(vertexId);

                    current = vertexId;
                }
            }

            // No reachable vertex left
            if (current == -1) {
                break;
            }

            visited.add(current);

            // Check neighbors
            for (Edge edge :
                    adjList.get(current)) {

                int neighbor =
                        edge.getDestination();

                int newDistance =
                        distance.get(current)
                                + edge.getWeight();

                // Relaxation step
                if (newDistance
                        < distance.get(neighbor)) {

                    distance.put(
                            neighbor,
                            newDistance);
                }
            }
        }

        // Print shortest distances
        System.out.println(
                "\nShortest distances from vertex "
                        + start);

        for (int vertexId :
                distance.keySet()) {

            System.out.println(
                    "To "
                            + vertexId
                            + " = "
                            + distance.get(vertexId));
        }
    }
}
```
