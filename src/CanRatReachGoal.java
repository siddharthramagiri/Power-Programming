public class CanRatReachGoal {

    public static boolean ReachState (int[][] maze, int r, int c) {

        if(r >= maze.length || c >= maze[0].length || r < 0 || c < 0) return false;
        if(maze[r][c] == 0) return false;
        if(r == maze.length - 1 && c == maze.length - 1) return true;
        maze[r][c] = 0;
        return ReachState(maze, r + 1, c) || ReachState(maze, r , c+1) ||
                ReachState(maze , r - 1, c) || ReachState(maze, r, c - 1);
    }
    public static void main(String[] args) {
        int[][] maze = {
                {1,1,1,1},
                {1,0,1,0},
                {1,0,1,0},
                {0,1,1,1},
        };
        System.out.println(ReachState(maze,0,0));
    }
}
