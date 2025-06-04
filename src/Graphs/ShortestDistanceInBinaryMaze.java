package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInBinaryMaze {
    class Pair {
        int dist, row, col;
        public Pair(int dist, int row, int col) {
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
    }
    public int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1])
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int[] d : dist) {
            Arrays.fill(d, (int)(1e9));
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, source[0], source[1]));
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int dis = p.dist;
            int row = p.row;
            int col = p.col;
            int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
            for(int[] dir : directions) {
                int newR = row + dir[0];
                int newC = col + dir[1];
                if(newR >= 0 && newR < n && newC >= 0 && newC < m &&
                grid[newR][newC] == 1 && (dis + 1) < dist[newR][newC]) {
                    dist[newR][newC] = dis + 1;
                    if(newR == destination[0] && newC == destination[1]) {
                        return dis + 1;
                    }
                    queue.add(new Pair(dis + 1, newR, newC));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int grid[][] = {{1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 0},
                        {1, 0, 1, 0, 1}},
            source[] = {0, 0},
            destination[] = {3, 4};
        ShortestDistanceInBinaryMaze SDB = new ShortestDistanceInBinaryMaze();
        System.out.println(SDB.shortestPath(grid, source, destination));
    }
}
