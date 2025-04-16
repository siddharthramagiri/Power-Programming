package DSA;

public class FindSpecialSubstringLengthK {
    public static boolean hasSpecialSubstring(String s, int k) {
        int n = s.length();
        if(n == 1 && k == 1) return true;
        for(int i = 0; i + k <= n; i++) {
            if(isSpecial(s.substring(i,i+k))) {
                if(i - 1 < 0 && i + k >= n) return true;
                if(i - 1 < 0) {
                    if(i + k < n && s.charAt(i + k) != s.charAt(i)) {
                        return true;
                    }
                }
                if(i + k >= n) {
                    if(i - 1 >= 0 && s.charAt(i - 1) != s.charAt(i)) {
                    System.out.println(s.charAt(i-1) + " , " + s.charAt(i));
                        return true;
                    }
                }
                if(i - 1 >= 0 && s.charAt(i-1) != s.charAt(i)) {
                    if(i + k < n && s.charAt(i+k) != s.charAt(i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean isSpecial(String s) {
        int n = s.length();
        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) != s.charAt(i+1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ii";
        int k = 2;
        System.out.println(hasSpecialSubstring(s, k));
    }
}
