import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class LexicographicalOrder {

    public static int[] lexicalOrder(int[] arr) {
        int n = arr.length;
        HashMap<Character, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String s = arr[i] + "";
            PriorityQueue<Integer> pq = map.getOrDefault(s.charAt(0), new PriorityQueue<Integer>());
            pq.offer(arr[i]);
            map.put(s.charAt(0), pq);
        }
//        System.out.println(map);
        int prev = n;
        for(Map.Entry<Character, PriorityQueue<Integer>> m : map.entrySet()) {
            PriorityQueue<Integer> pq = m.getValue();
            int i = prev - pq.size();
            prev = i;
            while (!pq.isEmpty()) {
                arr[i] = pq.poll();
                i++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {10,2,32,22,11,1,4,8,9,15,20,3,77};
        int[] res = lexicalOrder(arr);
        for(int i : res) System.out.print(i + " ");
    }
}
