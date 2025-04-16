package DSA;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSumWithMostKElements {

    public long maxSum(int[][] grid, int[] limits, int k) {
        int m = grid[0].length;
        int j = 0;
        long sum = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for(int[] arr : grid) {
            Arrays.sort(arr);
            for(int i = m - 1; i >= 0; i--) {
                if(limits[j] > 0) {
                    sum += arr[i];
                    PQ.offer(arr[i]);
                    limits[j]--;
                } else break;
            }
            j++;
        }
        System.out.println(PQ);
        while(PQ.size() > k) {
            sum -= PQ.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxSumWithMostKElements MSME = new MaxSumWithMostKElements();
        int[][] grid = {{1,2},{3,4}};
        int[] limits = {1,2};
        int k = 2;
        System.out.println(MSME.maxSum(grid, limits, k));
    }
}
