package DSA;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        // // // // KADANS's ALGORITHM
        for(int i = 0; i < n; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray MSA = new MaxSubArray();
        System.out.println(MSA.maxSubArray(nums));
    }
}
