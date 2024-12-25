package CodeForce;
import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> index = new HashMap<>();
        int n2 = nums2.length;
        for(int i = 0; i < n2; i++) {
            index.put(nums1[i],i);
        }
        int n1 = nums1.length;
        for(int i = 0; i < n1; i++) {
            int idx = index.getOrDefault(nums1[i],-1);
            if(idx == -1) {
                nums1[i] = -1;
            } else {
                nums1[i] = getMax(idx,nums2);
            }
        }
        return nums1;
    }
    public static int getMax(int idx, int[] arr) {
        for(int i = idx; i < arr.length; i++) {
            if(arr[idx] < arr[i]) {
                return arr[i];
            }
        }
        return -1;
    }
    public static int[] nextGreaterElements(int[] nums) {

        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        for(int i : nextGreaterElements(nums))
            System.out.print(i);
    }
}
