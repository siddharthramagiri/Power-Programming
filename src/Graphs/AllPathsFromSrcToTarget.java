package Graphs;
import java.util.*;

public class AllPathsFromSrcToTarget {
    public static List<List<Integer>> ans;
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        dfs2(graph, 0, new ArrayList<Integer>(Arrays.asList(0)));
        return ans;
    }

    public static void dfs2(int[][] graph, int src, ArrayList<Integer> path) {
        int target = graph.length - 1;
        if(src == target) {
            ans.add(new ArrayList(path));
            return;
        }
        for(int neighbour : graph[src]) {
            path.add(neighbour);
            dfs2(graph, neighbour, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {4,3,1},{3,2,4},{3},{4},{}
        };
        System.out.println(allPathsSourceTarget(graph));
    }
}
