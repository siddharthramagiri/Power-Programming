package WeeklyAssignments.week1;
import java.util.*;

public class Postfix {
    public static String postfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if((Character.isDigit(ch) || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))) {
                sb.append(ch);
            } else {
                if(stack.isEmpty() || ch == '(' || stack.contains('(')) {
                    stack.push(ch);
                } else if (ch == '+') {
                    while(!stack.isEmpty() && (stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/')) {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                } else if (ch == '-') {
                    while(!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '*' || stack.peek() == '/')) {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                } else if (ch == '*') {
                    while(!stack.isEmpty() && stack.peek() == '/') {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                } else if (ch == '/') {
                    while(!stack.isEmpty() && stack.peek() == '*') {
                        sb.append(stack.pop());
                    }
                    stack.push(ch);
                } else if (ch == ')') {
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "sin(x)+cos(2x)";
        System.out.println(s);
        System.out.println(postfix(s));
    }
}






