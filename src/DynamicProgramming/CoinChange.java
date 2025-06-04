package DynamicProgramming;

public class CoinChange {
    int minPath = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int n = coins.length;
        for(int i = 0; i < n; i++) {
            recursive(coins, amount - coins[i], 1);
        }
        return minPath == Integer.MAX_VALUE ? -1 : minPath;
    }
    public void recursive(int[] coins, int amount, int path) {
        if(amount == 0) {
            minPath = Math.min(minPath, path);
            return;
        }
        if(amount < 0) {
            return;
        }
        for(int i = 0; i < coins.length; i++) {
            recursive(coins, amount - coins[i], path + 1);
        }
    }
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        System.out.println(new CoinChange().coinChange(coins, amount));
    }
}
