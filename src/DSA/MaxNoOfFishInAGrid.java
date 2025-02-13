package DSA;

public class MaxNoOfFishInAGrid {
    public static int findMaxFish(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxFishes = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                maxFishes = Math.max(maxFishes, dfs(i,j,grid));
            }
        }
        return maxFishes;
    }
    public static int dfs(int r, int c, int[][] grid) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        int ans = grid[r][c];
        grid[r][c] = 0;
        ans += dfs(r-1,c,grid) + dfs(r,c-1, grid) + dfs(r, c+1, grid) + dfs(r+1, c, grid);
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        System.out.println(findMaxFish(grid));
    }
}
