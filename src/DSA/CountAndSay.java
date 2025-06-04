package DSA;

public class CountAndSay {
    public static String countAndSay(int n) {
        String[] dp = new String[n];
        dp[0] = "1";
        for(int i = 1; i < n; i++) {
            dp[i] = frequency(dp[i-1]);
        }
        return dp[n-1];
    }
    public static String frequency(String num) {
        int n = num.length();
        int i = 0, j = 1;
        StringBuilder sb = new StringBuilder();
        while(j < n) {
            if(num.charAt(i) != num.charAt(j)) {
                sb.append((j - i)).append(num.charAt(i));
                i=j;
            }
            j++;
        }
        sb.append((j - i)).append(num.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(countAndSay(n));
    }
}
