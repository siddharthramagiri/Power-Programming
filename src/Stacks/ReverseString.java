package Stacks;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {

        Stack<Character> stack = new Stack<>();
        String str = "abcdefg";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            stack.push(ch);
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop() + "");
        }
        System.out.println(sb.toString());
    }
}
