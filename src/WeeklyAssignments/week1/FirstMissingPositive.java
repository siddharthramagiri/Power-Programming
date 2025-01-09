package WeeklyAssignments.week1;


public class FirstMissingPositive {
    public static void swap(int[] nums, int val) {
        if(val >= nums.length || val == nums[val] || nums[val] < 0) return;
        int temp = nums[val];
        nums[val] = 1;
        swap(nums,temp);
    }
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
//        for(int i = 0; i < n; i++) {
//            if(nums[i] >= 0 && nums[i] < n) {
//                int temp = nums[i];
//                nums[i] = 1;
//                swap(nums, temp);
//            } else {
//                nums[i] = 0;
//            }
//        }
//        int i = 1;
//        for(i = 1; i < n; i++) {
//            if(nums[i] == 0) return i;
//        }
        int[] arr = new int[n + 1];
        for(int i : nums) {
            if(i > 0 && i <= n)
                arr[i] = 1;
        }
        int i = 1;
        for(i = 1; i <= n; i++) {
            if(arr[i] == 0) return i;
        }
        return i;
    }
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(firstMissingPositive(nums));
    }
}
