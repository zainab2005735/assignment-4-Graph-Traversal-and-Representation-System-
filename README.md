# Assignment-4-Graph-Traversal-and-Representation-System-
- ## A. Project Overview 
This project implements a Graph data structure using an adjacency list. A graph consists of 
Vertices (nodes representing entities) and Edges (connections between nodes). The project 
demonstrates two primary traversal algorithms: Breadth-First Search, which explores neighbor nodes level by level, 
and Depth-First Search, which explores as far as possible along each branch before backtracking.
- ## B. Class Descriptions
* `Vertex.java`: Represents a single node in the graph, containing a unique `id`.
<img width="471" height="458" alt="4" src="https://github.com/user-attachments/assets/2c9a983e-2144-4634-99e8-cef1c49b7696" />


* `Edge.java`: Represents a link between a `source` vertex and a `destination` vertex.
  <img width="538" height="490" alt="1" src="https://github.com/user-attachments/assets/09922b93-413d-4479-9e5c-1c88011e8962" />


* `Graph.java`: Manages the collection of vertices and edges using an Adjacency List (`Map<Integer, List<Edge>>`). 
Includes functions to add vertices, add edges, and perform traversals.

Bfs:
![img_2.png](docs/screenshots/img_2.png)
Dfs:
![img_3.png](docs/screenshots/img_3.png)
* `Experiment.java` & `Main.java`: Responsible for generating graphs of various sizes (10, 30, 100), running BFS and DFS, and 
recording their execution times using `System.nanoTime()`.
![img_4.png](docs/screenshots/img_4.png)

## C. Algorithm Descriptions
### 1. Breadth-First Search (BFS)
* Step-by-step logic: Starts at the root 
node, marks it as visited, and enqueues it. It dequeues a node, visits all its unvisited neighbors, enqueues them, and repeats 
until the queue is empty.

* Use Cases: Finding the shortest path in an unweighted graph, peer-to-peer networks, web crawlers.

* Time Complexity: $O(V + E)$ where $V$ is the number of vertices and $E$ is the number of edges.

### 2. Depth-First Search (DFS)
* Step-by-step logic: Starts at the root, marks it as visited, and recursively calls the DFS 
function on its first unvisited neighbor. It goes deep into the graph and backtracks only 
when a node has no unvisited neighbors.

* Use Cases: Topological sorting, solving mazes/puzzles (like Sudoku), detecting cycles in graphs.

* Time Complexity: $O(V + E)$.

## D. Experimental Results
![img_5.png](docs/screenshots/img_5.png)

**Analysis Answers:**
* **How does graph size affect performance?** As the number of vertices and edges increases, the time taken for both traversals increases linearly.
* **Which traversal is faster?** In these experiments, [INSERT DFS or BFS] is slightly faster due to [queue overhead for BFS / recursion overhead for DFS].
* **Do results match expected complexity O(V + E)?** Yes, the time scales proportionally with the size of the graph structure.
* **How does graph structure affect traversal order?** Wide graphs with many branches make BFS process many nodes early, while deep graphs cause DFS to reach far ends of the graph immediately.
* **When is BFS preferred?** When looking for the shortest path or when the target is known to be close to the starting point.
* **Limitations of DFS?** It is not guaranteed to find the shortest path, and deep recursions can cause a `StackOverflowError` in very large or infinite graphs.

## E. Screenshots
* Graph structure output:
![img_6.png](docs/screenshots/img_6.png)
* BFS and DFS traversal output:
![img_7.png](docs/screenshots/img_7.png)
* Performance results:
![img_8.png](docs/screenshots/img_8.png)


# Graph Traversal and Representation System
BONUS PART OF PROJECT:

## Overview
This project implements a graph data structure using an adjacency list representation in Java.

The system demonstrates:
- Breadth-First Search (BFS)
- Depth-First Search (DFS)
- Dijkstra’s Algorithm (Shortest Path)

## Features
- Vertex and Edge classes
- Weighted graph support
- BFS traversal
- DFS traversal
- Dijkstra shortest path algorithm
- Performance experiments and execution time measurements

## Graph Representation
The graph is implemented using:
- HashMap for vertices
- Adjacency List for edges

## Dijkstra Algorithm
The bonus task implements Dijkstra’s Algorithm to find the shortest path from a starting vertex to all other vertices in a weighted graph.

### Requirements Implemented
- Edge weights added
- Weighted adjacency list
- `dijkstra(int start)` method
- Shortest distance calculation

<img width="546" height="575" alt="1" src="https://github.com/user-attachments/assets/638ef499-0b6a-45d9-9275-33fb6bf7fb83" />

<img width="403" height="559" alt="2" src="https://github.com/user-attachments/assets/2f5b1c2c-a924-4d2a-be34-8d530cfb3527" />


<img width="386" height="481" alt="3" src="https://github.com/user-attachments/assets/6ac8ddc6-9d47-4ecc-8d4f-f1ac76a5b32a" />



  <img width="340" height="189" alt="4" src="https://github.com/user-attachments/assets/61697d6b-eb7e-4c38-8d5b-484f1e419e00" />


<img width="357" height="437" alt="5" src="https://github.com/user-attachments/assets/ce948c34-2f6e-44b4-ae8b-a5e179a1ba32" />

  


## Author
Zainab Noori
