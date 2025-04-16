package DSA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectKDisjointSpecialStrings {
    public static boolean maxSubstringLength(String s, int k) {
        if(k == 0) return true;
        int n = s.length();
        if(k > n) return false;
        List<Character> inside = new ArrayList<>();
        List<Character> outside = new ArrayList<>();
        for(char ch : s.toCharArray()) {
            outside.add(ch);
        }
        while(inside.size() < k) {
            inside.add(outside.removeFirst());
        }
        int i = -1;
        while(n >= 0) {
            i++;
            boolean valid = false;
            if(i < k && !outside.contains(inside.get(i))) {
                valid = true;
                if(i == k - 1) {
                    int temp = i;
                    boolean distinct = true;
                    while(temp >= 0) {
                        char removed = inside.removeFirst();
                        if(inside.contains(removed)) {
                            distinct = false;
                            inside.add(removed);
                            break;
                        }
                        inside.add(removed);
                        temp--;
                    }
                    if(distinct) return true;
                    else valid = false;
                }
            }
            if(!valid) {
                while(i >= 0) {
                    outside.add(inside.removeFirst());
                    inside.add(outside.removeFirst());
                    i--;
                }
                i = -1;
            }
            n--;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "iqoi";
        int k = 4;
        System.out.println(maxSubstringLength(s,k));
    }
}
