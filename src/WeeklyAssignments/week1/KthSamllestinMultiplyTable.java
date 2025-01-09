package WeeklyAssignments.week1;

import java.util.Map;
import java.util.TreeMap;

public class KthSamllestinMultiplyTable {
    public static int findKthNumber(int m, int n, int k) {
        int left = 0, right = m*n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(lessThanK(mid, m, n) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public static int lessThanK(int element, int m, int n) {
        int sum = 0;
        for(int i = 1; i < m; i++) {
            sum += Math.min(element/i, n);
        }
        return sum;
    }
//    BRUTE FORCE aproach
    public static int findKthNumber2(int m, int n, int k) {
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
        System.out.println(findKthNumber(1,3,2));
    }
}
