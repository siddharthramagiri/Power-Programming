package DSA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearchII {
    List<String> ans = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> finalWords = new HashSet<>();
        HashSet<String> prefixes = new HashSet<>();
        for(String word : words) {
            finalWords.add(word);
            int n = word.length();
            while(n > 0) {
                prefixes.add(word.substring(0,n));
                n--;
            }
        }
//        System.out.println(prefixes);
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(prefixes.contains(board[i][j]+"")) {
                    StringBuilder sb = new StringBuilder();
                    backTrack(i, j, board, visited, sb, n, m, finalWords, prefixes);
                }
            }
        }
        return ans;
    }
    int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}};
    public void backTrack(int r, int c, char[][] board, boolean[][] visited, StringBuilder sb,
                          int n, int m, HashSet<String> finalWords, HashSet<String> prefixes) {
        if(r < 0 || r >= n || c < 0 || c >= m || visited[r][c]) {
            return;
        }
        sb.append(board[r][c]);
        visited[r][c] = true;
        if(!prefixes.contains(sb.toString())) {
            sb.deleteCharAt(sb.length() - 1);
            visited[r][c] = false;
            return;
        }
//        System.out.println(sb.toString());
        if(finalWords.contains(sb.toString()) && !ans.contains(sb.toString())) {
            ans.add(sb.toString());
        }
        for(int[] dir : directions) {
            backTrack(r+dir[0], c+dir[1], board, visited, sb, n, m, finalWords, prefixes);
        }
        visited[r][c] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
    public static void main(String[] args) {
        WordSearchII WS = new WordSearchII();
        char[][] board =  {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        System.out.println(WS.findWords(board, new String[]{"oath","pea","eat","rain","hklf", "hf"}));
    }
}
