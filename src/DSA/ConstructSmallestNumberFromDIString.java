package DSA;

import java.util.ArrayList;
import java.util.List;

public class ConstructSmallestNumberFromDIString {
    public static List<String> nums;
    public static String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder sb = new StringBuilder();
        nums = new ArrayList<>();
        for(int i = 1; i <= n + 1; i++) {
            sb.append(i);
        }
        permutations("", sb.toString(), pattern);
//        Collections.sort(nums);
        return nums.getFirst();
    }
    public static void permutations(String unprocessed, String processed, String pattern) {
        if(processed.isEmpty()) {
            if(isMatched(unprocessed, pattern)) {
                nums.add(unprocessed);
            }
            return;
        }
        char num = processed.charAt(0);
        for(int i = 0; i <= unprocessed.length(); i++) {
            String left = unprocessed.substring(0,i);
            String right = unprocessed.substring(i);
            permutations(left+num+right, processed.substring(1), pattern);
        }
    }
    public static boolean isMatched(String num, String pattern) {
        int n = pattern.length();
        for(int i = 0; i < n; i++) {
            if(pattern.charAt(i) == 'D' && num.charAt(i) < num.charAt(i+1)) return false;
            if(pattern.charAt(i) == 'I' && num.charAt(i) > num.charAt(i+1)) return false;
        }
        return true;
    }

    public static String smallestNumber2(String pattern) {
        int n = pattern.length();
        StringBuilder sb = new StringBuilder();
        nums = new ArrayList<>();
        for(int i = 1; i <= n + 1; i++) {
            sb.append(i);
        }
        boolean[] used = new boolean[n+2];
        permuteAll("", sb.toString(), used, pattern);
        return nums.getFirst();
    }
    public static void permuteAll(String ans, String number, boolean[] used, String pattern) {
        if(ans.length() == number.length()) {
            if(isMatched(ans, pattern))
                nums.add(ans);
            return;
        }
        for(int i = 0; i < number.length(); i++) {
            if(!used[i]) {
                used[i] = true;
                permuteAll(ans+number.charAt(i), number, used, pattern);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        System.out.println(smallestNumber2(pattern));
    }
}
