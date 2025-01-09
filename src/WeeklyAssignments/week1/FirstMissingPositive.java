package WeeklyAssignments.week1;


public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
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
        int[] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
    }
}
