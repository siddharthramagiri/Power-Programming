package Graphs;

import java.util.*;

public class FindClosestNodeGivenTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] distNode1 = new int[n];
        int[] distNode2 = new int[n];
        bfs(edges, node1, distNode1);
        bfs(edges, node2, distNode2);
        int minOfMaxDist = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < n; i++) {
            if(distNode1[i] != -1 && distNode2[i] != -1) {
                System.out.println(i + " :: " + distNode1[i] + " | " + distNode2[i]);
                if(minOfMaxDist > Math.max(distNode1[i], distNode2[i])) {
//                    minOfMaxDist = Math.min(minOfMaxDist, Math.max(distNode1[i], distNode2[i]));
                    minOfMaxDist = Math.max(distNode1[i], distNode2[i]);
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
    public void bfs(int[] edges, int src, int[] dist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        Arrays.fill(dist, -1);
        dist[src] = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            int neighbour = edges[node];
            if(neighbour != -1 && dist[neighbour] == -1) {
                dist[neighbour] = dist[node] + 1;
                queue.offer(neighbour);
            }
        }
    }
    public static void main(String[] args) {
        int[] edges = {2,2,3,-1};
        int node1 = 0;
        int node2 = 1;
        System.out.println(new FindClosestNodeGivenTwoNodes().closestMeetingNode(edges, node1, node2));
    }
}
