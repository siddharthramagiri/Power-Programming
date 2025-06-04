package Graphs;

import java.util.*;

public class CountNumberOfCompleteComponents {
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    public static int countCompleteComponents(int n, int[][] edges) {
        for(int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                Set<Integer> components = new HashSet<>();
                dfs(components, i, visited);
                if(isCompleteComponent(components)) count++;
            }
        }
        return count;
    }
    public static void dfs(Set<Integer> components, int node, boolean[] visited) {
        components.add(node);
        visited[node] = true;
        for(Integer neighbour : graph.getOrDefault(node, new ArrayList<>())) {
            if(!visited[neighbour]) {
                dfs(components, neighbour, visited);
            }
        }
    }
    public static boolean isCompleteComponent(Set<Integer> component) {
        for(Integer node : component) {
            if(graph.getOrDefault(node, new ArrayList<>()).size() != component.size() - 1) {
                return false;
            }
        }
        PriorityQueue<String> words = new PriorityQueue<>();
        words.add("abs");
        return true;
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1},{0, 2},{1, 2},{3, 4}};
        System.out.println(countCompleteComponents(n, edges));
    }
}
