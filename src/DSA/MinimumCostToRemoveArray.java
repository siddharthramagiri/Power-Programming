package DSA;

import java.util.*;

public class MinimumCostToRemoveArray {
    public static int minCost(int[] nums) {
        Deque<Integer> Q = new ArrayDeque<>();
        for(int i : nums) {
            Q.offerLast(i);
        }
        int cost = 0;
        cost = backTrack(Q, 0);
        return cost;
    }
    static int score = Integer.MAX_VALUE;
    public static int backTrack(Deque<Integer> Q, int sum) {
        if(Q.size() < 3) {
            int max = 0;
            for(Integer i : Q) {
                max = Math.max(max, i);
            }
            return max + sum;
        }
        int[] nums = {Q.pollFirst(), Q.pollFirst(), Q.pollFirst()};
        int[] scores = {
                Math.max(nums[1], nums[2]),
                Math.max(nums[0], nums[2]),
                Math.max(nums[0], nums[1])
        };
        for(int i = 0; i < 3; i++) {
            Q.offerFirst(nums[i]);
            score = Math.min(score, backTrack(Q, sum + scores[i]));
            Q.pollFirst();
        }
        for(int i = 2; i >= 0; i--) {
            Q.offerFirst(nums[i]);
        }
        return score;
    }

    public static void main(String[] args) {
        int[] nums = {6,2,8,4};
        System.out.println(minCost(nums));
    }
}
