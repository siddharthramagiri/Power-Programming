package DSA;

import java.util.Arrays;

public class NextGreaterElementIII {
//    static int nextG;
//    public static int nextGreatest(int n) {
//        nextG = Integer.MAX_VALUE;
//        getGretestElement("", Integer.toString(n), n);
//        return nextG==Integer.MAX_VALUE? -1 : nextG;
//    }
//    public static void getGretestElement(String up, String p, int n) {
//        if(p.isEmpty()) {
//            if(Integer.parseInt(up) > n) {
//                nextG = Math.min(nextG, Integer.parseInt(up));
//            }
//            return;
//        }
//        char num = p.charAt(0);
//        for(int i = 0; i <= up.length(); i++) {
//            String left = up.substring(0,i);
//            String right = up.substring(i);
//            getGretestElement(left+num+right, p.substring(1),n);
//        }
//    }

    public static int nextGreaterElement(int n) {
        String num = "" + n;
        int first = Integer.parseInt(num.charAt(0) + "");
        int nextG = Integer.MAX_VALUE;
        int minIdx = -1;
        boolean updated = false;
        for(int i = 1; i < num.length(); i++) {
            int currNum = Integer.parseInt(num.substring(i, i+1));
            if(currNum >= first)
                if(nextG >= currNum) {
                    updated = true;
                    nextG = currNum;
                    minIdx = i;
                }
        }
        if(!updated) return -1;

        num = num.substring(0,minIdx) + num.substring(minIdx+1);
        char[] numsArr = num.toCharArray();
        Arrays.sort(numsArr);
        num = nextG + new String(numsArr);
        n = Integer.parseInt(num);
        return n;
    }

    public static void main(String[] args) {
        int n = 2147483486;
        System.out.println(nextGreaterElement(n));
    }
}
