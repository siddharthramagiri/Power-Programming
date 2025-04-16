package DSA;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MostProfitablePathinTree {
    int profit;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        HashMap<Integer, Integer> reversePath = new HashMap<>();
        HashMap<Integer, Deque<Integer>> path = new HashMap<>();
        for(int[] edge : edges) {
            reversePath.put(edge[1],edge[0]);
            Deque<Integer> Q = path.getOrDefault(edge[0], new ArrayDeque<>());
            Q.offer(edge[1]);
            path.put(edge[0], Q);
        }
        System.out.println(reversePath);
        System.out.println(path);
        HashMap<Integer, Integer> bobTimes = new HashMap<>();
        int time = 0;
        while(true) {
            bobTimes.put(bob,time);
            time++;
            if(reversePath.get(bob) == null) break;
            bob = reversePath.get(bob);
        }
        System.out.println(bobTimes);
        profit = Integer.MIN_VALUE;
        getMaxProfit(0, 0, 0, path, bobTimes, amount[0], amount);
        return profit;
    }
    public void getMaxProfit(int node, int time, int index,
                             HashMap<Integer, Deque<Integer>> path,
                             HashMap<Integer, Integer> bobTimes,
                             int profitTemp, int[] amount)
    {
        System.out.println("Node : " + node + "  Profit : " + profitTemp + " Time" + time );
        if(path.get(node) == null) {
            profit = Math.max(profit, profitTemp);
            return;
        }
        time++;
        while(path.containsKey(node) && !path.get(node).isEmpty()) {
            int n = path.get(node).poll();
                // System.out.print(n);
            if(!bobTimes.containsKey(n) || bobTimes.get(n) > time) {
                // profit = profit + amount[time];
                getMaxProfit(n, time, index + 1, path, bobTimes,
                        profitTemp + amount[index + 1], amount);
            } else if(bobTimes.get(n) < time) {
                // profit = profit - amount[time];
                getMaxProfit(n, time, index + 1, path, bobTimes,
                        profitTemp, amount);
            } else {
                // profit = profit + (amount[time] / 2);
                getMaxProfit(n, time, index + 1, path, bobTimes,
                        profitTemp + (amount[index + 1]/2), amount);
            }
            index++;
        }
    }

    public static void main(String[] args) {
        MostProfitablePathinTree MPT = new MostProfitablePathinTree();
        int[][] edges = {{0,1}};
        int bob = 1;
        int[] amount = {-7280,2350};
        System.out.println(MPT.mostProfitablePath(edges, bob, amount));

    }
}
