package RecursionsKunal;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    static List<List<String>> sols = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        boolean[] vertical = new boolean[n];
        for(int c = 0; c < n; c++) {
            vertical = new boolean[n];
            solveQueen(board, 0, c, vertical, n);
        }
        return sols;
    }
    public static void solveQueen(int[][] board, int r, int c, boolean[] vertical, int n) {
        if(r >= n || c < 0 || c >= n || vertical[c]) return;
        if(isValid(board, r, c, n)) {
            board[r][c] = 1;
            vertical[c] = true;
            if(r == n - 1) {
                List<String> strList = new ArrayList<>();
                for(int i = 0; i < n; i++) {
                    StringBuilder sb = new StringBuilder();
                    for(int j = 0; j < n; j++) {
                        if(board[i][j] == 0) sb.append('.');
                        else sb.append('Q');
                    }
                    strList.add(sb.toString());
                }
                sols.add(strList);
            }
        } else return;
        for(int i = 0; i < n; i++) {
            solveQueen(board, r + 1, i, vertical, n);
        }
        board[r][c] = 0;
        vertical[c] = false;
    }
    public static boolean isValid(int[][] board, int r, int c, int n) {
        if(r < 0 || r >= n || c < 0 || c >= n) return true;
        int i = r, j = c;
        while(i >= 0 && j >= 0) if(board[i--][j--] == 1) return false;
        i = r; j = c;
        while(i < n && j < n) if(board[i++][j++] == 1) return false;
        i = r; j = c;
        while(i >= 0 && j < n) if(board[i--][j++] == 1) return false;
        i = r; j = c;
        while(i < n && j >= 0) if(board[i++][j--] == 1) return  false;
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> solutions = solveNQueens(4);
        System.out.println(solutions);
    }
}
