package DSA;

import java.util.Stack;

public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        int i = 0, j = 0;
        while(i < n && j < n) {
            stack.push(pushed[i]);
            i++;
            while(!stack.isEmpty() && j < n && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5}, popped = {4,5,3,2,1};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
