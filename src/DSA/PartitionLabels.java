package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {

    public static List<Integer> partitionLabels(String s) {
        int[][] pos = new int[26][2];
        for(int i = 0; i < 26; i++) {
            pos[i][0] = 500;
            pos[i][1] = 0;
        }
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            pos[ch-'a'][0] = Math.min(pos[ch-'a'][0], i);
            pos[ch-'a'][1] = i;
        }
        Arrays.sort(pos, (a,b) -> a[0]-b[0]);
        List<Integer> ans = new ArrayList<>();
        int min = pos[0][0], max = pos[0][1];
        int i = 1;
        while(i < 26 && pos[i][0] < 500) {
            if(pos[i][0] > max) {
                ans.add(max - min + 1);
                min = pos[i][0];
                max = pos[i][1];
            } else max = Math.max(max, pos[i][1]);
            i++;
        }
        ans.add(max-min+1);
        return ans;
    }

    public static void main(String[] args) {
        String s = "eccbbbbdec";
        System.out.println(partitionLabels(s));

    }
}
