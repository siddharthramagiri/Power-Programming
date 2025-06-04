package Compete;
import java.util.*;

public class BiggerIsBetter {
    public static String getLexicographical(StringBuilder sb, int n) {
        String string = sb.toString();
        String reversed = sb.reverse().toString();
        StringBuilder ans = new StringBuilder();
        boolean updated = false;
        for(int i = 0; i < n; i++) {
            char f = string.charAt(i);
            char l = reversed.charAt(i);
            if(f < 'z' && l < 'z') {
                updated = true;
                int ch = Math.max(f, l)+1;
                ans.append((char)ch);
            }
        }
        return (!updated)? "-1" : ans.toString();
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        System.out.print("ENter no. of testcases : ");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            System.out.print("Enter size : ");
            int size = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            System.out.println("Enter string : ");
//            for(int j = 0; j < size; j++) {
                sb.append(sc.next());
//            }
            System.out.println(getLexicographical(sb, size));
        }
    }
}
