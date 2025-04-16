package DSA;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PartitionEqualSubSet {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum % 2 != 0) return false;
        int n = nums.length;
        int targetSum = sum/2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for(int i = n - 1; i >= 0; i--) {
            Set<Integer> newDp = new HashSet<>();
            for(Integer t : dp) {
                if(t + nums[i] == targetSum)
                    return true;
                newDp.add(t);
                newDp.add(t + nums[i]);
            }
            dp = newDp;
        }
        return dp.contains(targetSum);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5};
        System.out.println(canPartition(nums));
    }
}
