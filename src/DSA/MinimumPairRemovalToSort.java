package DSA;

public class MinimumPairRemovalToSort {
    public static int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int operation = 0;
        for(int i = n - 1; i >= 1; i--) {
            if(nums[i-1] > nums[i]) {
                int tempSum = 0;
                int j = i;
                while(j < n) {
                    tempSum += nums[j];
                    operation++;
                    if(tempSum >= nums[i-1]) {
                        nums[i] = tempSum;
                        int k = i;
                        while(j < n) {
                            nums[k++] = nums[j++];
                        }
                        break;
                    }
                    j++;
                }
                if(nums[i-1] > nums[i]) {
                    nums[i-1] += tempSum;
                    n = i;
                }
            }
        }
        return operation;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        System.out.println(minimumPairRemoval(nums));
    }
}
