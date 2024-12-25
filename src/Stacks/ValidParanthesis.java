package Stacks;

import java.util.Stack;

public class ValidParanthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if(!stack.isEmpty() && ch == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (!stack.isEmpty() && ch == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (!stack.isEmpty() && ch == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "]";
        System.out.println(isValid(s));
    }
}
