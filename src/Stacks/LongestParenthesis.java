package Stacks;

import java.util.Stack;

public class LongestParenthesis {
    public static int longestValidParentheses(String str) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        int n = str.length();
        stack.push(-1);
        for(int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else
                    maxLen = Math.max(maxLen, i - stack.peek());
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = ")()())";
        System.out.println(longestValidParentheses(str));
    }
}
