package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CityWithSmallestNumOfNeighboursThreshold {
    class Pair {
        int next;
        int weight;
        public Pair(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<Integer>[] graph = new ArrayList[n];
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }


        return 0;
    }
    public static void main(String[] args) {

    }
}
