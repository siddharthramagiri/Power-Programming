package RecursionsKunal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static int[][] RottOrange(int[][] grid, int i, int j) {
        if(i < 0 || i > grid.length || j < 0 || j > grid[0].length) {
            return grid;
        }
        if(grid[i][j] == 1) {
            grid[i][j] = 2;
            return grid;
        } else if(grid[i][j] == 0) {
            return grid;
        }
        grid = RottOrange(grid, i, j + 1);
        grid = RottOrange(grid, i + 1, j);
        grid = RottOrange(grid, i - 1, j);
        grid = RottOrange(grid, i, j - 1);
        return grid;
    }
    public static int orangesRotting(int[][] grid) {
        grid = RottOrange(grid, 0, 0);
        for (int ar[] : grid)
            for(int i : ar)
                System.out.print(i + " ");
            System.out.println();
        return 0;
    }
    public static void oranges(Queue<ArrayList<Integer>> queue, int[][] oranges, int row, int col) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(row);
        temp.add(col);
        temp.add(oranges[row][col]);
        if(row>= 0 && row<oranges.length && col >= 0 && col < oranges[0].length && oranges[row][col] == 1) {
            queue.add(temp);
            while (!queue.isEmpty()) {
                ArrayList<Integer> arr = queue.poll();
                int newRow = arr.get(0);
                int newCol = arr.get(1);
                oranges(queue, oranges, newRow + 1, newCol);
                oranges(queue, oranges, newRow, newCol + 1);
                oranges(queue, oranges, newRow - 1, newCol);
                oranges(queue, oranges, newRow, newCol - 1);
            }
        }
    }
    public static void rottingOranges(int[][] oranges) {
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        oranges(queue, oranges, 0, 0);
    }
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
        rottingOranges(grid);
    }
}
