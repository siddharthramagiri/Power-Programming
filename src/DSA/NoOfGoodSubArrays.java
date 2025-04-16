package DSA;

import java.util.HashMap;

public class NoOfGoodSubArrays {
    public static long countGood(int[] nums, int k) {
        long result = 0;
        int i = 0, j = 0, n = nums.length;
        long pairs = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(j = 0; j < n; j++) {
            pairs += map.getOrDefault(nums[j], 0);
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            while(pairs >= k && i < n) {
                result += (n - j);
                map.put(nums[i], map.get(nums[i])-1);
                pairs -= map.get(nums[i]);
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int k = 10;
        System.out.println(countGood(nums, k));
    }
}
