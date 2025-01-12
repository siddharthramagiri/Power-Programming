package DSA;

public class ShiftingLetterII {
    public static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] arr = new int[n];
        for(int[] shift : shifts) {
            if(shift[2] == 1) {
                arr[shift[0]]++;
                if(shift[1] + 1 < n) {
                    arr[shift[1] + 1]--;
                }
            } else {
                arr[shift[0]]--;
                if(shift[1] + 1 < n) {
                    arr[shift[1] + 1]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder(s);
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum = (sum + arr[i]) % 26;
            if(sum < 0) sum += 26;
            char shiftedChar = (char)('a' + (s.charAt(i) - 'a' + sum) % 26);
            sb.setCharAt(i,shiftedChar);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "dztz";
        int[][] shifts = {{0,0,0},{1,1,1},{0,2,1}};
        System.out.println(shiftingLetters(s,shifts));
    }
}
