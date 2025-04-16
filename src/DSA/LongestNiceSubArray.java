package DSA;

import java.util.HashMap;

public class LongestNiceSubArray {
    public static void main(String[] args) {
        int[] nums = {45106826,547958667,823366125,332020148,611677524,510346561,
                555831456,436600904,12594192,127206768,540754485,201997978,473116514,
                233000361,538246458,729745279,343417143,892046691,376031730};
        System.out.println(longestSubArray(nums));
    }

    static int start = 0;
    static HashMap<Integer, Integer> indices = new HashMap<>();
    public static int longestSubArray(int[] nums) {
        int n = nums.length;
        int end = 1;
        char[] binary = Long.toBinaryString(nums[0]).toCharArray();
        int len = binary.length;
        int index = 0;
        for(int i = len - 1; i >= 0; i--) {
            if(binary[i] == '1') {
                indices.put(index, 0);
            }
            index++;
        }
        int max = 1;
        while(end < n && start < n) {
            binary = Long.toBinaryString(nums[end]).toCharArray();
            if(isValid(binary, end)) {
                max = Math.max(max, end - start + 1);
                end++;
            }
            if(start > end) {
                end = start + 1;
            }
        }
        return max;
    }
    public static boolean isValid(char[] binary, int idx) {
        int n = binary.length;
        int index = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(binary[i] == '1'){
                if(indices.containsKey(index)) {
                    start = indices.get(index) + 1;
                    indices.entrySet().removeIf(entry -> entry.getValue() == start-1);
                    return false;
                }
                indices.put(index, idx);
            }
            index++;
        }
        return true;
    }
}
