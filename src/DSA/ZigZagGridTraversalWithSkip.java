package DSA;

import java.util.ArrayList;
import java.util.List;

public class ZigZagGridTraversalWithSkip {
    public static List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        int j = 0;
        for(int i = 0; i < m; i++) {
            if(j >= n) j = n - 1;
            if(j < 0) j = 0;
            while(j >= 0 && j < n) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) list.add(grid[i][j]);
                    j++;
                } else {
                    if (j % 2 != 0) list.add(grid[i][j]);
                    j--;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2,1,3},{5,15,7,3},{10,4,14,12}};
        System.out.println(zigzagTraversal(grid));
    }
}
