package DSA;

public class UniquePathsII {
    int paths = 0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        getPaths(0,0,obstacleGrid, n, m);
        return paths;
    }
    public int[][] directions = {{0,1},{1,0}};
    public void getPaths(int r, int c, int[][] grid, int n, int m) {
        if(r >= n || c >= m || grid[r][c] == 1) return;
        if(r == n-1 && c == m-1) {
            paths++;
            return;
        }
        for(int[] dir : directions) {
            getPaths(r+dir[0], c+dir[1], grid, n, m);
        }
    }
    public static void main(String[] args) {
        UniquePathsII UP = new UniquePathsII();
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(UP.uniquePathsWithObstacles(grid));
    }
}
