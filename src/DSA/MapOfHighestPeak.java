package DSA;

import java.util.ArrayDeque;
import java.util.Queue;

public class MapOfHighestPeak {
    public static int[][] highestPeak(int[][] isWater) {
        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] res = new int[n][m];
        Queue<int[]> Q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(isWater[i][j] == 1) {
                    res[i][j] = 0;
                    Q.offer(new int[]{i,j});
                } else {
                    res[i][j] = -1;
                }
            }
        }
        while(!Q.isEmpty()) {
            int[] cell = Q.poll();
            int r = cell[0];
            int c = cell[1];
            int h = res[r][c];
            for(int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && res[nr][nc] == -1) {
                    res[nr][nc] = h + 1;
                    Q.offer(new int[]{nr, nc});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,0,1},{1, 0, 0},{0,0,0}};
        int[][] res = highestPeak(arr);
        for(int[] a : res) {
            for (int i : a) System.out.print(i + " ");
            System.out.println();
        }
    }
}
