package Graphs;

import java.util.*;

public class ShortestPathAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] red : redEdges) {
            graph[red[0]].add(new int[]{red[1], 0});
        }
        for(int[] blue : blueEdges) {
            graph[blue[0]].add(new int[]{blue[1],1});
        }
        int[] result = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][2];

        queue.add(new int[]{0,0, -1});
        while (!queue.isEmpty()) {
            int[] prev = queue.remove();
            for(int[] neighbour : graph[prev[0]]) {
                if(!visited[neighbour[0]][neighbour[1]]
                        && neighbour[1] != prev[2]) {
                    if(result[neighbour[0]] == -1) {
                        result[neighbour[0]] = prev[1] + 1;
                    }
                    visited[neighbour[0]][neighbour[1]] = true;
                    queue.offer(new int[]{neighbour[0], prev[1] + 1, neighbour[1]});
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] redEdges = {{0,1},{0,2}};
        int[][] blueEdges = {{1,0}};
        int[] result = new ShortestPathAlternatingColors().shortestAlternatingPaths(n, redEdges, blueEdges);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
