package DSA;

public class MinLenOfStringAfterOperations {
    public static int minimumLength(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int sum = 0;
        for(int i = 0; i < 26; i++) {
            int count = freq[i];
            while(count > 2) {
                count-=2;
            }
            sum+=count;
        }
        return sum;
    }
    public static void main(String[] args) {
        String s = "abaacbcbb";
        System.out.println(minimumLength(s));
    }
}
