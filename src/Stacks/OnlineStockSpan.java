package Stacks;

import java.util.Stack;

public class OnlineStockSpan {

    public static int[] getSpan(int[] arr) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[i] <= stack.peek()) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                res[i] = i - stack.peek();
            } else {
                res[i] = i + 1;
            }
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {13,15,12,14,16,8,4,10,30};
        int[] ans = getSpan(arr);
        for(int i : ans) System.out.print(i + " " );
    }
}
