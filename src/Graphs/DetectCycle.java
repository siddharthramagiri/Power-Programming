package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DetectCycle {
    public static boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[V];
        for(int i = 0; i < adjList.size(); i++) {
            if(!visited[i])
                if(dfs(visited, adjList, i, -1)) {
                    return true;
                }
        }
        return false;
    }
    public static boolean dfs(boolean[] visited, List<List<Integer>> graph, int node, int parent) {
        visited[node] = true;
        for(int neighbour : graph.get(node)) {
            if(!visited[neighbour]) {
                if(dfs(visited, graph, neighbour, node)) return true;
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 4, E = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        System.out.println(isCycle(V, edges));
    }
}
