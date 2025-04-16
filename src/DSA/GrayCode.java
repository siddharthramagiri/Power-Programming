package DSA;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    static List<Integer> list;
    public static List<Integer> grayCode(int n) {
        list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(0);
        }
        backTrack(sb.toString(), 0);
        return list;
    }
    public static void backTrack(String str, int index) {
        if(index >= str.length()) {
            return;
        }
        for(int i = 0; i < 2; i++) {
            String x = str.substring(0, index) + i + str.substring(index + 1);
            if(!list.contains(Integer.parseInt(x,2))) {
                System.out.println(x);
                list.add(Integer.parseInt(x,2));
            }
            backTrack(x, index + 1);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(grayCode(n));
    }
}
