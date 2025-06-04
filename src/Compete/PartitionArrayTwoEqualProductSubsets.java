package Compete;

public class PartitionArrayTwoEqualProductSubsets {
    public boolean checkEqualPartitions(int[] nums, long target) {
        return backtrack(nums, 0, 1, 1, 0, 0, target);
    }

    private boolean backtrack(int[] nums, int index, long prod1, long prod2, int count1, int count2, long target) {
        if (index == nums.length) {
            return count1 > 0 && count2 > 0 && prod1 == target && prod2 == target;
        }
        int num = nums[index];

        if (num != 0 && prod1 <= target / num) {
            if (backtrack(nums, index + 1, prod1 * num, prod2, count1 + 1, count2, target)) {
                return true;
            }
        }

        if (num != 0 && prod2 <= target / num) {
            if (backtrack(nums, index + 1,prod1, prod2 * num, count1, count2 + 1, target)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {14,1,8,23,12,19,24,15,7};
        int target = 1;
        System.out.println(new PartitionArrayTwoEqualProductSubsets().checkEqualPartitions(nums, target));
    }
}
