package DSA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateBinaryStringsWithoutAdjacentZeros {
    static Set<String> res;
    public static List<String> validStrings(int n) {
        res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        backTrack(sb, n);

        return new ArrayList<>(res);
    }
    public static void backTrack(StringBuilder sb, int n) {
        if(sb.length() == n) {
            res.add(sb.toString());
            return;
        }
        char lastChar = '1';
        if(!sb.isEmpty())
            lastChar = sb.charAt(sb.length() - 1);
        char[] chars = new char[]{'0', '1'};
        for(char ch : chars) {
            if(lastChar == '0') {
                backTrack(sb.append('1'), n);
            } else {
                backTrack(sb.append(ch), n);

            }

        }
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(validStrings(n));
    }
}
