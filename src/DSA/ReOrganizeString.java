package DSA;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ReOrganizeString {

    public static String reorganizeString(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
                (a,b) ->
                        freq.get(b) - freq.get(a)
        );
        pq.addAll(freq.keySet());
        System.out.println(freq);
        System.out.println(pq);

        if((s.length() + 1)/2 < freq.get(pq.peek())) return "";

        StringBuilder sb = new StringBuilder();
        while(pq.size() >= 2) {
            Character ch1 = pq.poll();
            Character ch2 = pq.poll();
            sb.append(ch1).append(ch2);

            if(freq.get(ch1) == 1) freq.remove(ch1);
            else freq.put(ch1, freq.get(ch1)-1);

            if(freq.get(ch2) == 1) freq.remove(ch2);
            else freq.put(ch2, freq.get(ch2)-1);

            pq.clear();
            pq.addAll(freq.keySet());
        }
        if(!pq.isEmpty()) {
            char ch = pq.poll();
            if(freq.get(ch) > 1) {
                return "";
            } else {
                sb.append(ch);
            }
        }
        System.out.println(sb.toString());

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "bfrbs";
        System.out.println(reorganizeString(s));
    }
}
