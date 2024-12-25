package Stacks;

import java.util.Stack;

public class BackSpaceCompare {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> Sstack = new Stack<>();
        Stack<Character> Tstack = new Stack<>();
        int n1 = s.length();
        int n2 = t.length();
        for(int i = 0; i < n1; i++) {
            char ch = s.charAt(i);
            if(ch == '#') {
                Sstack.pop();
                continue;
            }
            Sstack.push(ch);
        }
        for(int i = 0; i < n2; i++) {
            char ch = t.charAt(i);
            if(ch == '#') {
                Tstack.pop();
                continue;
            }
            Tstack.push(ch);
        }
//        System.out.println(Sstack);
//        System.out.println(Tstack);
//        while(!Sstack.isEmpty() && !Tstack.isEmpty()) {
//            if(Sstack.pop() != Tstack.pop())
//                return false;
//        }
//        return Sstack.size() == Tstack.size();
        return Sstack.equals(Tstack);
    }
    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompare(s,t));
    }
}
