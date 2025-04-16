package DSA;

import java.util.PriorityQueue;

public class MinNumberOfPlatforms {

    public static void main(String[] args) {
        int[] arrivals = {900,  940, 950, 1100, 1500, 1800};
        int[] deprture = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(minPlatforms(arrivals, deprture));
    }
    public static int minPlatforms(int[] ar, int[] dp) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = ar.length;
        int prevDep = 0;
        int max = 0;
        pq.offer(prevDep);
        for(int i = 0; i < n; i++) {
            if(pq.peek() <= ar[i]) {
                pq.poll();
            }
            pq.offer(dp[i]);
            max = Math.max(max, pq.size());
        }
        return max;
    }
}
