package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        for(int[] prereq : prerequisites) {
            graph[prereq[1]][prereq[0]] = 1;
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i])
                if(dfs(visited, path, graph, i)) return false;
        }
        return true;
    }
    public static boolean dfs(boolean[] visited, boolean[] path, int[][] graph, int node) {
        visited[node] = true;
        path[node] = true;
        for(int neighbour = 0; neighbour < graph.length; neighbour++) {
            if(graph[node][neighbour] == 1) {
                if (!visited[neighbour]) {
                    if (dfs(visited, path, graph, neighbour))
                        return true;
                } else if (path[neighbour]) {
                    return true;
                }
            }
        }
        path[node] = false;
        return false;
    }

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }
        int[] visited = new int[numCourses];
        for(int i = 0; i < graph.length; i++) {
            if(!dfs2(graph, visited, prerequisites[i][1])) {
                return false;
            }
        }
        return true;
    }
    public static boolean dfs2(List<Integer>[] graph, int[] visited, int node) {
        if(visited[node] == 2) return false;
        if(visited[node] == 1) return true;
        visited[node]++;
        for(int neighbour : graph[node]) {
            if(dfs2(graph, visited, neighbour)) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0,1}};
        System.out.println(canFinish2(numCourses, prerequisites));
    }
}
