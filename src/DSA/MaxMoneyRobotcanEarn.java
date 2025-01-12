package DSA;

import java.util.Arrays;

public class MaxMoneyRobotcanEarn {
    static int count = 0;
    public static int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int i = 0, j = 0;
//        while(i < m || j < n) {
//            if(i >= m) {
//            } else if (j >= n) {
//            } else {
//                int down = (i+1 < m) ? coins[i+1][j] : 0;
//                int right = (j+1 < n) ? coins[i][j+1] : 0;
//            }
//        }
        int robbed = 0;
        int profit = 0;
        profit = getMaxProfit(coins, i, j, robbed, profit);
        return 0;
    }
    public static int getMaxProfit(int[][] coins, int i, int j, int robbed, int profit) {
        int m = coins.length, n = coins[0].length;
        if(i >= m && j >= n) {
            return profit;
        }
        if(i < m && j < n) {
            if(coins[i][j] < 0) {
                if(robbed < 2) {
                    robbed++;
                } else {
                    profit += coins[i][j];
                }
            } else {
                profit += coins[i][j];
            }
        }
        int right = getMaxProfit(coins, i, j + 1, robbed, profit);
        int down = getMaxProfit(coins, i + 1, j, robbed, profit);
        return Math.max(right, down);
    }

    public static int getMax(int[][] coins) {
        int m = coins.length;    // Number of rows
        int n = coins[0].length; // Number of columns
        int[][][] dp = new int[m][n][3];

        // Initialize dp array with INT_MIN equivalent
        for (int[][] arr2D : dp) {
            for (int[] arr : arr2D) {
                Arrays.fill(arr, Integer.MIN_VALUE);
            }
        }

        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0; // Neutralizing one robber
            dp[0][0][2] = 0; // Neutralizing two robbers
        }

        // Dynamic programming to calculate the maximum amount
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE) continue; // Skip unvisited states

                    if (i + 1 < m) { // From the top
                        dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k] + coins[i + 1][j]);
                        if (k + 1 < 3 && coins[i + 1][j] < 0) {
                            dp[i + 1][j][k + 1] = Math.max(dp[i + 1][j][k + 1], dp[i][j][k]);
                        }
                    }

                    if (j + 1 < n) { // From the left
                        dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i][j][k] + coins[i][j + 1]);
                        if (k + 1 < 3 && coins[i][j + 1] < 0) {
                            dp[i][j + 1][k + 1] = Math.max(dp[i][j + 1][k + 1], dp[i][j][k]);
                        }
                    }
                }
            }
        }

        // Return the maximum value from the last cell
        return Math.max(dp[m - 1][n - 1][0],
                Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
    public static void main(String[] args) {
        int[][] coins = {{0,1,-1},{1,-2,3},{2,-3,4}};
        System.out.println(getMax(coins));
    }
}
