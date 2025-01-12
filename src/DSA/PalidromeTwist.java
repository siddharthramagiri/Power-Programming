package DSA;

import java.util.HashSet;
import java.util.Stack;

public class PalidromeTwist {
    static int count = 0;
    public static boolean checkPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        boolean ans = true;
        return palindrome(str,0,str.length()-1, stack, set, ans);
    }
    public static boolean palindrome(String str, int l, int r, Stack<Character> stack, HashSet<Character> set, boolean ans) {
        if(l >= r) {
            if(str.length() % 2 != 0) {
                    stack.push(str.charAt(l));
            }
            if(set.contains(stack.peek())) {
                set.remove(stack.peek());
                stack.pop();
            }
            if(set.size() + stack.size() > 1 || count > 1) ans = false;
            return ans;
        }
        stack.push(str.charAt(l));
        if(stack.peek() == str.charAt(r)) {
            stack.pop();
        }
        else {
            set.add(str.charAt(r));
            while(set.contains(stack.peek())) {
                count++;
                set.remove(stack.peek());
                stack.pop();
            }
        }
        ans = palindrome(str, l + 1, r - 1, stack, set, ans);
        return ans;
    }
    public static boolean isPalindrome(String str, int l, int r, boolean flag) {

        return true;
    }
    public static void main(String[] args) {
        String str = "daeed";
        System.out.println(isPalindrome(str,0,str.length()-1,true));
        System.out.println(checkPalindrome(str));
    }
}
