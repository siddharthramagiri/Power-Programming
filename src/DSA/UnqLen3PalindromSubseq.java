package DSA;

import java.util.HashSet;

public class UnqLen3PalindromSubseq {
    public static int countPalindromicSubsequence(String s) {
        int n = s.length();
        int first = 0, last = n - 1;
        int count = 0;
        HashSet<String> set = new HashSet<>();
        while(first < (n - 1)) {
            char F = s.charAt(first);
            char L = s.charAt(last);
            if(F == L) {
                for(int j = first + 1; j < last; j++) {
                    String str = F + "" + s.charAt(j) + L;
                    if(!set.contains(str)) {
                        set.add(str);
                        count++;
                    }
                }
            }
            last--;
            if(last == first) {
                last = n - 1;
                first++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "bbcbaba";
        System.out.println(countPalindromicSubsequence(s));
    }
}
