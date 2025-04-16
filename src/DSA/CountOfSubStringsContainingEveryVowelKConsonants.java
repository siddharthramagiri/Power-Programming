package DSA;

public class CountOfSubStringsContainingEveryVowelKConsonants {

    public static long countOfSubstrings(String word, int k) {
        return countSubstrings(word, k) - countSubstrings(word, k + 1);
    }
    public static long countSubstrings(String word, int k) {
        int n = word.length();
        int l = 0, r = 0;
        int[] freq = new int[26];
        long count = 0;
        int cons = 0;
        while(r < n) {
            char ch = word.charAt(r);
            if(isConsonant(ch)) {
                cons++;
            }
            freq[ch - 'a']++;
            while(cons >= k && isAllVowelsPresent(freq)) {
                count += (n - r);
                char c = word.charAt(l);
                if(isConsonant(c)) cons--;
                freq[c - 'a']--;
                l++;
            }
            r++;
        }
        return count;
    }
    public static boolean isConsonant(char ch) {
        return (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u');
    }
    public static boolean isAllVowelsPresent(int[] freq) {
        return (freq[0] > 0 && freq['e'-'a'] > 0 && freq['i'-'a'] > 0 && freq['o'-'a'] > 0 && freq['u'-'a'] > 0);
    }

    public static void main(String[] args) {
        String word = "ieaouqqieaouqq";
        System.out.println(countOfSubstrings(word, 1));
    }
}
