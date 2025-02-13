package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Graphs01 {

    public static void addEdge(List<List<Integer>> adj, int edge, int vertices) {
        adj.get(edge).add(vertices);
        adj.get(vertices).add(edge);
    }
    public static void bfs(List<List<Integer>> adj, int source) {
        boolean[] visited = new boolean[adj.size()];
        List<Integer> queue = new ArrayList<>();
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int node = queue.removeFirst();
            System.out.print(node + " ");
            for(int neighbor : adj.get(node)) {
                if(!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
    public static void dfsHelper(List<List<Integer>> adj, int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");
        for(int neighbor : adj.get(source)) {
            if(!visited[neighbor]) {
                dfsHelper(adj, neighbor, visited);
            }
        }
    }
    public static void dfs(List<List<Integer>> adj, int source) {
        boolean[] visited = new boolean[adj.size()];
        dfsHelper(adj, source, visited);
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            adjList.add(new ArrayList<>());
        }
        addEdge(adjList, 1, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 2, 5);
        addEdge(adjList, 2, 4);
        addEdge(adjList, 3, 5);
        addEdge(adjList, 4, 5);

        bfs(adjList, 1);
        System.out.println();
        dfs(adjList, 1);
    }
}
