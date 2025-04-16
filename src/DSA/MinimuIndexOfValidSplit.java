package DSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimuIndexOfValidSplit {
    public static int minimumIndex(List<Integer> nums) {
        HashMap<Integer, Integer> lFreq = new HashMap<>();
        HashMap<Integer, Integer> rFreq = new HashMap<>();
        int n = nums.size();
        int[][] lMax = new int[n][2];
        int[][] rMax = new int[n][2];
        int maxFl = 0;
        for(int i = 0; i < n; i++) {
            int val = nums.get(i);
            lFreq.put(val, lFreq.getOrDefault(val, 0) + 1);
            int freq = lFreq.get(val);
            if(maxFl < freq) {
                maxFl = freq;
                lMax[i][0] = maxFl;
                lMax[i][1] = nums.get(i);
            } else {
                lMax[i][0] = maxFl;
                lMax[i][1] = lMax[i-1][1];
            }
        }
        int maxFr = 0;
        for(int i = n - 1; i >= 0; i--) {
            int val = nums.get(i);
            rFreq.put(val, rFreq.getOrDefault(val, 0) + 1);
            int freq = rFreq.get(val);
            if(maxFr < freq) {
                maxFr = freq;
                rMax[i][0] = maxFr;
                rMax[i][1] = nums.get(i);
            } else {
                rMax[i][0] = maxFr;
                rMax[i][1] = rMax[i+1][1];
            }
        }
//        for(int[] i : lMax) {
//            System.out.print("(" + i[0] + "," + i[1] + ") ");
//        }
//        System.out.println();
//        for(int[] i : rMax) {
//            System.out.print("(" + i[0] + "," + i[1] + ") ");
//        }
        for(int i = 0; i < n - 1; i++) {
            if(lMax[i][0]*2 > (i + 1) && rMax[i+1][0]*2 > (n - (i + 1))) {
                if(lMax[i][1] == rMax[i+1][1]) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,3,7,2,2};
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            list.add(i);
        }
        System.out.println(minimumIndex(list));
    }
}
