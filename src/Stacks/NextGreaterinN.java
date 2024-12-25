package Stacks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class NextGreaterinN {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        boolean first = true;
        while(i < n) {
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                int top = stack.peek();
                if(nums[i] > nums[top]) {
                    res[top] = nums[i];
                    stack.pop();
                    continue;
                } else {
                    stack.push(i);
                }
            }
            i++;
            if(i >= n && first) {
                first = false;
                i = i % n;
            }
        }
        return res;
    }
    public static int[] getNextGreatest(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < n) {
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                int top = stack.peek();
                if(arr[i] > arr[top]) {
                    res[top] = arr[i];
                    stack.pop();
                    continue;
                } else {
                    stack.push(i);
                }
            }
            i++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {5,15,10,8,6,12,9,18};
        for(int i : getNextGreatest(arr))
            System.out.print(i + " ");

        System.out.println("\nCircular : ");
        int[] arr1 = {1,2,3,4,3};
        for(int i :  nextGreaterElements(arr1))
            System.out.print(i + " ");
    }
}
