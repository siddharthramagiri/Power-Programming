package DSA;

import java.util.LinkedList;
import java.util.Queue;

public class MaxCandiesYouGetBoxes {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int box : initialBoxes) {
            queue.offer(box);
        }
        while(!queue.isEmpty()) {
            Queue<Integer> innerQueue = new LinkedList<>();
            boolean flag = false;
            while(!queue.isEmpty()) {
                int currBox = queue.poll();
                if(status[currBox] == 0) {
                    innerQueue.offer(currBox);
                    continue;
                }
                flag = true;
                count += candies[currBox];
                for(int k : keys[currBox]) {
                    status[k] = 1;
                }
                for(int box : containedBoxes[currBox]) {
                    innerQueue.offer(box);
                }
            }
            if(!flag) return count;
            queue = innerQueue;
        }
        return count;
    }
    public int maxCandies2(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = candies.length;
        boolean[] visited = new boolean[n];
        for(int currBox : initialBoxes) {
            dfs(currBox, containedBoxes, status, visited, keys);
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i] && status[i] == 1) {
                count += candies[i];
            }
        }
        return count;
    }
    public void dfs(int currBox, int[][] Boxes, int[] status, boolean[] visited, int[][] keys) {
        visited[currBox] = true;
        for(int key : keys[currBox]) {
            if(key == currBox) continue;
            status[key] = 1;
        }
        for(int box : Boxes[currBox]) {
            if(!visited[box]) {
                dfs(box, Boxes, status, visited, keys);
            }
        }
    }
    public static void main(String[] args) {
        int status[] = {1,0,0,0,0,0},
            candies[] = {1,1,1,1,1,1},
            keys[][] = {{1,2,3,4,5},{},{},{},{},{}},
            containedBoxes[][] = {{1,2,3,4,5},{},{},{},{},{}},
            initialBoxes[] = {0};

        System.out.println(new MaxCandiesYouGetBoxes().maxCandies2(status, candies, keys, containedBoxes, initialBoxes));
    }
}
