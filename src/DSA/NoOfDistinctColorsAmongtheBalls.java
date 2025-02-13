package DSA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class NoOfDistinctColorsAmongtheBalls {

    public static int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> balls = new HashMap<>();
        HashMap<Integer, Integer> colors = new HashMap<>();
        int n = queries.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if(balls.containsKey(ball)) {
                int existingColor = balls.get(ball);
                if(balls.get(ball) == color) {
                    res[i] = colors.size();
                    continue;
                } else if (colors.get(existingColor) == 1) {
                    colors.remove(existingColor);
                } else {
                    colors.put(existingColor, colors.get(existingColor) - 1);
                }
            }
            balls.put(ball, color);
            colors.put(color, colors.getOrDefault(color, 0) + 1);
            res[i] = colors.size();
        }
        return res;
    }

    public static void main(String[] args) {
        int limit = 1;
        int[][] queries = {{0,1},{1,4},{1,1},{1,4},{1,1}};
        int[] res = queryResults(limit, queries);
        for(int i : res) System.out.print(i + " ");
    }
}
