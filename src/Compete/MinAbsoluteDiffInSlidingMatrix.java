package Compete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinAbsoluteDiffInSlidingMatrix {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                List<Integer> vals = new ArrayList<>();
                for (int x = 0; x < k; x++) {
                    for (int y = 0; y < k; y++) {
                        vals.add(grid[i + x][j + y]);
                    }
                }

                Collections.sort(vals);
                int minDiff = Integer.MAX_VALUE;
                for (int z = 1; z < vals.size(); z++) {
                    if (!vals.get(z).equals(vals.get(z - 1))) {
                        minDiff = Math.min(minDiff, vals.get(z) - vals.get(z - 1));
                    }
                }
                ans[i][j] = (minDiff == Integer.MAX_VALUE)? 0 : minDiff;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,-2,3},{2,3,5}};
        int k = 2;
        int[][] res = new MinAbsoluteDiffInSlidingMatrix().minAbsDiff(grid, k);
        for(int[] r : res) for(int i : r) System.out.println(i);
    }
}
