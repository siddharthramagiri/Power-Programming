package DSA;

import java.util.Deque;
import java.util.LinkedList;

public class RottingOranges {
    int rows, cols;
    public int orangesRotting2(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int ans = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) {
                    if(rotten(i,j,grid,true)) ans++;
                }
            }
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
    public boolean rotten(int r, int c, int[][] grid, boolean current) {
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
            return false;
        } else if (grid[r][c] == 2) {
            if(!current)
                return false;
        } else {
            grid[r][c] = 2;
            return true;
        }
        boolean left = rotten(r,c-1,grid,false);
        boolean right =  rotten(r, c+1, grid, false);
        boolean up = rotten(r-1,c,grid,false);
        boolean down = rotten(r+1,c,grid,false);
        return left || right || up || down;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;
        Deque<int[]> Q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) freshCount++;
                else if (grid[i][j] == 2) Q.offerLast(new int[]{i,j});
            }
        }
        if(freshCount == 0) return 0;
        int time = 0;
        while(!Q.isEmpty()) {
            int size = Q.size();
            for(int i = 0; i < size; i++) {
                int[] index = Q.poll();
                int r = index[0];
                int c = index[1];
                int[][] direc = {{r - 1, c}, {r, c + 1}, {r + 1, c}, {r, c - 1}};
                for (int[] neighbour : direc) {
                    int nr = neighbour[0];
                    int nc = neighbour[1];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] == 2 || grid[nr][nc] == 0)
                        continue;
                    Q.offer(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                }
            }
            time++;
            freshCount -= Q.size();
            if (freshCount == 0) break;
        }
        return (freshCount==0)? time : -1;
    }
    public static void main(String[] args) {
        RottingOranges RO = new RottingOranges();
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1},
        };
        System.out.println(RO.orangesRotting(grid));
    }
}
