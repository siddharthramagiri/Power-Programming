package DSASheet;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String shortestStr = strs[0];
        for(String s : strs) {
            if(shortestStr.length() > s.length()) {
                shortestStr = s;
            }
        }
        System.out.println(shortestStr);
        String longest = "";
        for(int i = shortestStr.length(); i >= 0; i--) {
            boolean flag = true;
            for(String s : strs) {
                if(!s.startsWith(shortestStr.substring(0,i))) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                longest = shortestStr.substring(0, i);
                return longest;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String[] str = {"dog","racecar","car"};
        Arrays.sort(str);
//        for(String s : str) System.out.println(s);
        System.out.println(longestCommonPrefix(str));
    }
}
