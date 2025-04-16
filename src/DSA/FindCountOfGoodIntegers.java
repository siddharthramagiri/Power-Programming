package DSA;

public class FindCountOfGoodIntegers {
    static long count = 0;
    public static long countGoodIntegers(int n, int k) {
        backTrack(new StringBuilder(), k, n);
        return count;
    }
    public static void backTrack(StringBuilder sb, int k, int n) {
        if(n%2 == 0) {
            if(sb.length() == n/2) {
                String rev = enumerate(sb.toString(), sb.length() - 1);
                if(isValid(sb + rev, k)) count++;
                return;
            }
        } else {
            if(sb.length() == Math.ceil((float)n/2)) {
                String rev = enumerate(sb.toString(), sb.length() - 2);
                if(isValid(sb + rev, k)) count++;
                return;
            }
        }
        for(int i = 0; i < 10; i++) {
            if(sb.isEmpty() && i == 0)
                continue;
            backTrack(sb.append(i), k, n);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public static String enumerate(String s, int index) {
        StringBuilder sb = new StringBuilder();
        for(int i = index; i >=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public static boolean isValid(String num, int k) {
        return (Integer.parseInt(num) % k == 0);
    }

    public static void main(String[] args) {
        int n = 3, k = 5;
        System.out.println(countGoodIntegers(n, k));
    }
}
