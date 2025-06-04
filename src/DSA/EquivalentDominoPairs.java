package DSA;
import java.util.HashMap;
import java.util.Map;

public class EquivalentDominoPairs {
    public static int numEquivDominoPairs(int[][] dominoes) {
//        int max = 0;
//        HashMap<String, Integer> map = new HashMap<>();
//        for(int[] domino : dominoes) {
//            map.put(domino[0]+""+domino[1], map.getOrDefault(domino[0]+""+domino[1], 0)+1);
//            map.put(domino[1]+""+domino[0], map.getOrDefault(domino[1]+""+domino[0], 0)+1);
//        }
//        for(Map.Entry<String, Integer> entry : map.entrySet()) {
//            max = Math.max(max, entry.getValue());
//        }
//        System.out.println(map);
//        return max - 1;

        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] a : dominoes) {
            int max = Math.max(a[0], a[1]), min = Math.min(a[0], a[1]);
            int key = min * 10 + max;
            int pairs = map.getOrDefault(key, 0);
            cnt += pairs;
            map.put(key, 1 + pairs);
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[][] dominos = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        System.out.println(numEquivDominoPairs(dominos));
    }
}
