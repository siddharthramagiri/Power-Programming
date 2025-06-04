package Graphs;

import java.util.ArrayList;
import java.util.List;

public class MaximizeNumberConnectingTreesI {
    public List<List<Integer>> buildGraph(int[][] edges, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length, m = edges2.length;
        List<List<Integer>> graph1 = buildGraph(edges1, n);
        List<List<Integer>> graph2 = buildGraph(edges2, m);
        int maxEdge2 = 0;
        for(int i = 0; i <= m; i++) {
            maxEdge2 = Math.max(maxEdge2, dfs(graph2, i, -1, k - 1));
        }
        int[] res = new int[n+1];
        for(int i = 0; i <= n; i++) {
            res[i] = dfs(graph1, i, -1, k) + maxEdge2;
        }
        return res;
    }
    public int dfs(List<List<Integer>> graph, int node, int parent, int k) {
        if(k < 0) return 0;
        int count = 1;
        for(Integer neighbour : graph.get(node)) {
            if(neighbour != parent) {
                count += dfs(graph, neighbour, node, k - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}}, edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        int[] result = new MaximizeNumberConnectingTreesI().maxTargetNodes(edges1, edges2, 2);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
