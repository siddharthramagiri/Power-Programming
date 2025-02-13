package DSA;

public class CountServers {
    public static int countServers(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                    ans++;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1)
                    if(rows[i] <= 1 && cols[j] <= 1)
                        ans -= 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {1,0},{1,1}
        };
        System.out.println(countServers(grid));
    }
}
