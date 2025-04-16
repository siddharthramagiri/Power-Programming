package DSA;
import java.util.Arrays;

public class MaxNumberMarkedIndices {
    public static int maxNumOfMarkedIndices(int[] nums) {
        int  count = 0, n = nums.length;
        int l = 0, r = n/2;
        Arrays.sort(nums);
        while(r < n && l < n/2) {
            if(nums[l]*2 <= nums[r]) {
                l++;
                count+=2;
            }
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,78,27,48,14,86,79,68,77,20,57,21,18,67,5,51,
                70,85,47,56,22,79,41,8,39,81,59,74,14,45,49,15,10,
                28,16,77,22,65,8,36,79,94,44,80,72,8,96,78,39,92,69,
                55,9,44,26,76,40,77,16,69,40,64,12,48,66,7,59,10};
        System.out.println(maxNumOfMarkedIndices(nums));
    }
}
