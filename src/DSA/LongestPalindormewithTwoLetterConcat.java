package DSA;
import java.util.*;

public class LongestPalindormewithTwoLetterConcat {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int len = 0, n = words.length;
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        boolean flag = false;
        for(String word : words) {
            if(isPalindrome(word)) {
                if(map.get(word) >= 2) {
                    map.put(word, map.get(word) - 2);
                    len += 4;
                } else if (map.get(word) == 1) {
                    flag = true;
                }
            } else {
                String revWord = word.charAt(1) + "" + word.charAt(0);
                if(map.getOrDefault(revWord, 0) >= 1 && map.getOrDefault(word, 0) >= 1) {
                    len += 4;
                    map.put(word, map.get(word) - 1);
                    map.put(revWord, map.get(revWord) - 1);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        set.addAll(list);
        if(flag) len+=2;
        return len;
    }
    public boolean isPalindrome(String word) {
        return word.charAt(0) == word.charAt(1);
    }
    public static void main(String[] args) {
        String[] words = {"em","pe","mp","ee","pp","me","ep","em","em","me"};
        LongestPalindormewithTwoLetterConcat LPC = new LongestPalindormewithTwoLetterConcat();
        System.out.println(LPC.longestPalindrome(words));
    }
}
