package DSA;

import java.util.Scanner;

public class NewFibonacciiSequence {
    public static int getAbsDifference(String binary) {
        int zeros = 0;
        int ones = 0;
        for(char ch : binary.toCharArray()) {
            if(ch == '1') ones++;
            else zeros++;
        }
        return Math.abs(zeros-ones);
    }
    public static String getBinaryString(int num) {
        if(num == 0) {
            return "0";
        }
        StringBuilder binary = new StringBuilder();
        while(num > 0) {
            binary.insert(0, num%2);
            num /= 2;
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int[] arr = {4,5,6};
        int maxN = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
            maxN = Math.max(maxN, arr[i]);
        }
        String[] fibSeq = new String[maxN + 1];
        int[] ans = new int[n];
        fibSeq[1] = "0";
        fibSeq[2] = "1";
        for(int i = 3; i <= maxN; i++) {
            fibSeq[i] = fibSeq[i-2] + fibSeq[i-1];
        }
        for(int i = 0; i < n; i++) {
            ans[i] = getAbsDifference(fibSeq[arr[i]]);
        }

        for(int i : ans) System.out.print(i + " ");
    }
}
