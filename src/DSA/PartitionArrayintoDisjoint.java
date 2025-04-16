package DSA;

import java.util.PriorityQueue;

public class PartitionArrayintoDisjoint {
    public static int partitionDisjoint(int[] nums) {
//        PriorityQueue<Integer> qLeft = new PriorityQueue<>((a,b) -> b-a);
//        PriorityQueue<Integer> qRight = new PriorityQueue<>((a, b) -> a-b);
//        qLeft.offer(nums[0]);
//        for(int i = 1; i < n; i++) {
//            qRight.offer(nums[i]);
//        }
//        for(int i = 1; i < n; i++) {
//            if(qLeft.peek() < qRight.peek()) {
//                return i;
//            }
//            qRight.remove(nums[i]);
//            qLeft.offer(nums[i]);
//        }
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max,nums[i]);
            leftMax[i] = max;
        }
        int min = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            min = Math.min(min,nums[i]);
            rightMin[i] = min;
        }
        for(int i = 1; i < n; i++) {
            if(leftMax[i-1] <= rightMin[i]) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {5,0,3,8,6};
        System.out.println(partitionDisjoint(nums));
    }
}
