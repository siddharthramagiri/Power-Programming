package DSA;

public class NoOfWonderFulSubStrings {

    public static long wonderfulSubstrings(String word) {
        int n = word.length();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                String str = word.substring(i,j);
                if(isOdd(str)) {
                    ans++;
                }
            }
        }
        return ans;
    }
    public static boolean isOdd(String word) {
        int[] freq = new int[26];
        for(char ch : word.toCharArray())
            freq[ch-'a']++;

        int count = 0;
        for(int i : freq)
            if(i%2 != 0) count++;

        return count <= 1;
    }

    public static void main(String[] args) {
        String word = "he";
        System.out.println(wonderfulSubstrings(word));
    }
}
