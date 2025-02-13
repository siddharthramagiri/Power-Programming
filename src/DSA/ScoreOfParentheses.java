package DSA;

import java.util.Stack;

public class ScoreOfParentheses {
    public static int scoreOfParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 1;
        int sub = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                stack.push(ch);
                sub++;
            } else {
                count = count + sub;
                sub = 0;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println(scoreOfParentheses(s));
    }
}
