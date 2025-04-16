package DSA;

import java.util.*;

public class MinOperationstoMakeUniValueGrid {
    public int minOperations(int[][] grid, int x) {
        int remainder = grid[0][0]%x;
        int m = grid.length;
        int n = grid[0].length;
        int[] list = new int[n*m];
        int i = 0;
        for(int[] row : grid) {
            for(int num : row) {
                int r = num % x;
                if(remainder != r) return -1;
                list[i++] = num;
            }
        }
        Arrays.sort(list);
        return getOperations(list, list[list.length/2], x);
    }

    public int getOperations(int[] list, int mid, int x) {
        int ops = 0;
        for(int num : list) {
            ops += (Math.abs(mid - num) / x);
        }
        return ops;
    }

    public static void main(String[] args) {
        MinOperationstoMakeUniValueGrid MOVG = new MinOperationstoMakeUniValueGrid();
        int[][] grid = {
                {980,476,644,56},{644,140,812,308},{812,812,896,560},{728,476,56,812}
        };
        System.out.println(MOVG.minOperations(grid, 84));
    }
}
