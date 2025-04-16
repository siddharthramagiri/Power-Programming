package DSA;

import java.util.PriorityQueue;

public class MinimumOperationsExceedThresholdValue {

    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long i : nums) {
            pq.add(i);
        }
        int count = 0;
        while(!pq.isEmpty()) {
            if(pq.size() > 1) {
                long min = pq.poll();
                long max = pq.poll();
                if(min >= k) {
                    if(max >= k)
                        return count;
                }
                pq.add((min*2 + max));
                count++;
            } else {
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1000000000,999999999,1000000000,999999999,1000000000,999999999};
        int k = 1000000000;
        System.out.println(minOperations(nums, k));
    }
}
