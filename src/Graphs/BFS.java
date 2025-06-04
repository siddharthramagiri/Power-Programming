package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.insertList(1, 2);
        graph.insertList(1, 3);
        graph.insertList(1, 6);
        graph.insertList(2, 3);
        graph.insertList(3, 4);
        graph.insertList(4, 1);
        graph.insertList(4, 2);
        graph.insertList(4, 5);

        graph.bfs(1);
        System.out.println();
        boolean[] visited = new boolean[graph.vertices];
        graph.dfs(1, visited);
    }
}
