import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class FirstNonRepeating {
    public static String getNonRepeat(String str) {
        Queue<Character> Q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(Q.contains(ch)) {
                Q.poll();
                sb.append("-1");
            } else {
                Q.add(ch);
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "aabcbcd";
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= str.length(); i++) {
            boolean found = false;
            HashMap<Character,Integer> freq = new HashMap<>();
            if (i == 1) { sb.append(str.charAt(i)); continue; }
            for(int j = 0; j < i; j++) {
                char ch = str.charAt(j);
                freq.put(ch,freq.getOrDefault(ch,0) + 1);
            }
            for(int j = 0; j < i; j++) {
                char ch = str.charAt(j);
                if(freq.get(ch) == 1) {
                    sb.append(ch);
                    found = true;
                    break;
                }
            }
            if(!found) sb.append("-1");
        }
        System.out.println(sb.toString());
        System.out.println(getNonRepeat(str));
    }
}
