package DSA;

public class CountSubArraysWithScoreLessThanK {
    public static long countSubarrays(int[] nums, long k) {
        long count = 0;
        int i = 0, j = 0, n = nums.length;
        long currSum = 0;
        while(j < n) {
            currSum += nums[j];
            while(currSum*(j-i+1) >= k) {
                currSum -= nums[i];
                i++;
            }
            count += (j - i + 1);
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 5;
        System.out.println(countSubarrays(nums, k));
    }
}
