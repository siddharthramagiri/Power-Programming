package DSA;

import java.util.Arrays;

public class PredictTheWinner {
    int[][] dp;
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        for(int[] d : dp) Arrays.fill(d, -1);
        return solve(nums, 0, n - 1) >= 0;
    }
    public int solve(int[] nums, int l, int r) {
        if(dp[l][r] != -1) return dp[l][r];
        if(l > r) return 0;
        if(l == r) return nums[l];
        int left = nums[l] - solve(nums, l + 1, r);
        int right = nums[r] - solve(nums, l, r - 1);
        return dp[l][r] = Math.max(left, right);
    }

    public static void main(String[] args) {
        int[] nums = {1,5,233,7};
        System.out.println(new PredictTheWinner().predictTheWinner(nums));
    }
}
