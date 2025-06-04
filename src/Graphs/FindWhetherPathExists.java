package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class FindWhetherPathExists {
    class Pair {
        int row, col;
        public Pair (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public boolean is_Possible(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        boolean found = false;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    queue.add(new Pair(i, j));
                    found = true;
                    visited[i][j] = true;
                    break;
                }
            }
            if(found) break;
        }
//        found = false;
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            int row = p.row;
            int col = p.col;
            int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
            for(int[] dir : directions) {
                int newR = row + dir[0];
                int newC = col + dir[1];
                if(newR >= 0 && newR < n && newC >= 0 && newC < m && !visited[newR][newC]) {
                    if(grid[newR][newC] == 0 ) continue;
                    queue.add(new Pair(newR, newC));
                    visited[row][col] = true;
                    if(grid[newR][newC] == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,3},{3,2}};
        FindWhetherPathExists FWP = new FindWhetherPathExists();
        System.out.println(FWP.is_Possible(grid));
    }
}
