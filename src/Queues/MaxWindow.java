package Queues;


import java.util.Deque;
import java.util.LinkedList;

public class MaxWindow {

    public static int[] slidingWindow(int[] nums, int k) {
        Deque<Integer> DQ = new LinkedList<>();
        int n = nums.length;
        int res[] = new int[n - k + 1];
        for(int i = 0; i < n; i++) {
            if(!DQ.isEmpty() && DQ.peekFirst() < i - k + 1) {
                DQ.pollFirst();
            }
            while(!DQ.isEmpty() && nums[DQ.peekLast()] < nums[i]) {
                DQ.pollLast();
            }
            DQ.offer(i);
            if(i >= k - 1) {
                res[i - k + 1] = nums[DQ.peekFirst()];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,-1};
        int k = 1;
        for(int i : slidingWindow(nums,k))
            System.out.print(i + " ");

        System.out.println();
        for(int i : Window(nums,k))
            System.out.print(i + " ");
    }
    public static int[] Window(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        boolean first = true;
        Deque<Integer> DQ = new LinkedList<>();
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(first) {
                first = false;
                while(DQ.size() < k) {
                    DQ.add(nums[i]);
                    maxVal = Math.max(maxVal,nums[i]);
                    i++;
                }
                i--;
                res[idx++] = maxVal;
            } else {
                int top = DQ.pop();
                DQ.add(nums[i]);
                if(maxVal == top) {
                    if(maxVal < nums[i]) {
                        maxVal = nums[i];
                        res[idx++] = maxVal;
                    } else {
                        maxVal = Integer.MIN_VALUE;
                        for(Integer dq : DQ) {
                            maxVal = Math.max(maxVal,dq);
                        }
                        res[idx++] = maxVal;
                    }
                } else {
                    if(maxVal < nums[i]) {
                        maxVal = nums[i];
                    }
                    res[idx++] = maxVal;
                }
            }
        }
        return res;
    }
}
