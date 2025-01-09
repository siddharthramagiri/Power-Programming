package WeeklyAssignments.week1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class KthSamllestinMultiplyTable {
    public static int findKthNumber(int m, int n, int k) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                map.put(i*j, map.getOrDefault((i*j),0) + 1);
            }
        }
        System.out.println(map);
        int count = 0;
        for(Map.Entry<Integer,Integer> hm : map.entrySet()) {
            count += hm.getValue();
            if(count >= k) {
                return hm.getKey();
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(findKthNumber(9,9,81));
    }
}
