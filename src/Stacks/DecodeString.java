package Stacks;

import java.util.HashSet;
import java.util.Stack;

public class DecodeString {
    public static String decode(String str) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String > strStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNumber = 0;
        for(char ch : str.toCharArray()) {
            if(Character.isDigit(ch)) {
                currNumber = currNumber * 10 + ch - '0';
            } else if (ch == '[') {
                numStack.push(currNumber);
                strStack.push(currStr.toString());
                currStr = new StringBuilder();
                currNumber = 0;
            } else if(ch == ']') {
                int n = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for(int i = 0; i < n; i++) {
                    temp.append(currStr);
                }
                currStr = temp;
            } else {
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
    public static void main(String[] args) {
        String str = "14[a]2[bc]";
        System.out.println(decode(str));
    }


    public static boolean isNum(char ch) {
        return (ch >= '0' && ch <= '9');
    }
    public static String decodeString(String str) {
        Stack<String> words = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        Stack<Character> par = new Stack<>();
        String sb = "";
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '[') {
                par.push(ch);
            } else if (ch == ']') {
                    String s = "";
                    int n = nums.pop();
                    String word = words.pop();
                    for(int j = 0; j < n; j++) {
                        s = s + word + sb;
                    }
                    sb = s;
            } else {
                int k = i;
                String s = "";
                boolean foundNum = false;
                while(isNum(str.charAt(k))) {
                    s = s + str.charAt(k);
                    k++;
                    foundNum = true;
                }
                if(foundNum) {
                    nums.push(Integer.parseInt(s));
                    i = k - 1;
                }
                s="";
                boolean foundChar = false;
                while(isString(str.charAt(k))) {
                    s = s + str.charAt(k);
                    k++;
                    foundChar = true;
                }
                if(foundChar) {
                    words.push(s);
                    i = k - 1;
                }
            }
        }
        System.out.println(words);
        System.out.println(nums);
        return sb;
    }
    public static boolean isString(char ch) {
        return (ch >= 'a' && ch < 'z');
    }
}
