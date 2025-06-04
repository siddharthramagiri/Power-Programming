package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    int n;
    class Pair {
        int row;
        int col;
        Pair (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public Pair getCordinates(int pos) {
        int rowT = (pos - 1) / n;
        int rowB = (n - 1) - rowT;

        int col = (pos - 1) % n;
        if(rowB % 2 == n % 2) {
            col = (n - 1) - col;
        }
        return new Pair(rowB, col);
    }
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[n-1][0] = true;
        int steps = 0;
        while(!queue.isEmpty()) {
            int N = queue.size();

            while(N-- > 0) {
                int x = queue.poll();
                if(x == n*n) return steps;
                for(int i = 1; i <= 6; i++) {
                    int val = x + i;
                    if(val > n*n) break;
                    Pair pair = getCordinates(val);
                    int row = pair.row;
                    int col = pair.col;
                    if(visited[row][col]) continue;
                    visited[row][col] = true;
                    if(board[row][col] == -1) {
                        queue.offer(val);
                    } else {
                        queue.offer(board[row][col]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] board = {
                {-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}
        };
        System.out.println(new SnakesAndLadders().snakesAndLadders(board));
    }
}
