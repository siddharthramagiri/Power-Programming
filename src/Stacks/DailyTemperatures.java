package Stacks;

import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> idxStack = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(idxStack.isEmpty())
                idxStack.push(i);
            else {
                int top = idxStack.peek();
                if(arr[i] > arr[top]) {
                    ans[top] = i - idxStack.pop();
                    i--;
                } else {
                    idxStack.push(i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(temperatures);
        for (int i : res)
            System.out.println(i);
    }
}
