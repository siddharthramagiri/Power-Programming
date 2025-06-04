package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int vertices;
    ArrayList<ArrayList<Integer>> adjajList;

    public Graph () {
        this.vertices = 0;
        this.adjajList = new ArrayList<>();
    }

    public Graph (int vertices) {
        this.vertices = vertices;
        adjajList = new ArrayList<>();
        for(int i = 0; i < vertices; i++) {
            adjajList.add(new ArrayList<>());
        }
    }

    public void insertList(int src, int des) {
        adjajList.get(src).add(des);
    }

    public void bfs(int src) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[this.vertices];
        queue.offer(src);
        visited[src] = true;
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            System.out.print(currNode + " ");
            for(Integer neighbours : adjajList.get(currNode)) {
                if(!visited[neighbours]) {
                    queue.offer(neighbours);
                    visited[neighbours] = true;
                }
            }
        }
    }

    public void dfs(int src, boolean[] visited) {
        visited[src] = true;
        System.out.print(src + " ");
        for(Integer neighbour : adjajList.get(src)) {
            if(!visited[neighbour]) {
                dfs(neighbour, visited);
            }
        }
    }
}
