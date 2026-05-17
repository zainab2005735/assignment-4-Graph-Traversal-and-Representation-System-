import java.util.*;
public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Edge>> adjList;
    public boolean printPath = true; // Flag to toggle printing during traversal

    public Graph() {
        this.vertices = new HashMap<>();
        this.adjList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    // Adding an undirected edge (adds both directions)
    public void addEdge(int from, int to) {
        if (!vertices.containsKey(from) || !vertices.containsKey(to)) {
            return;
        }
        adjList.get(from).add(new Edge(from, to));
        adjList.get(to).add(new Edge(to, from));
    }

    public void printGraph() {
        for (int id : adjList.keySet()) {
            System.out.print("Vertex " + id + " is connected to: ");
            for (Edge edge : adjList.get(id)) {
                System.out.print(edge.getDestination() + " ");
            }
            System.out.println();
        }
    }

    // Breadth-First Search
    public void bfs(int start) {
        if (!vertices.containsKey(start)) return;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        if (printPath) System.out.print("BFS Path: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (printPath) System.out.print(current + " ");

            for (Edge edge : adjList.get(current)) {
                if (!visited.contains(edge.getDestination())) {
                    visited.add(edge.getDestination());
                    queue.add(edge.getDestination());
                }
            }
        }
        if (printPath) System.out.println();
    }

    // Depth-First Search
    public void dfs(int start) {
        if (!vertices.containsKey(start)) return;
        Set<Integer> visited = new HashSet<>();

        if (printPath) System.out.print("DFS Path: ");
        dfsHelper(start, visited);
        if (printPath) System.out.println();
    }

    // Helper method for DFS recursion
    private void dfsHelper(int current, Set<Integer> visited) {
        visited.add(current);
        if (printPath) System.out.print(current + " ");

        for (Edge edge : adjList.get(current)) {
            if (!visited.contains(edge.getDestination())) {
                dfsHelper(edge.getDestination(), visited);
            }
        }
    }
}
