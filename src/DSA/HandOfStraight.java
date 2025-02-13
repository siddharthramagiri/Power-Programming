package DSA;
import java.util.*;

public class HandOfStraight {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0)
            return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : hand) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        while(!map.isEmpty()) {
            if(!getCards(map, groupSize)) return false;
        }
        return true;
    }
    public boolean getCards(TreeMap<Integer, Integer> map, int size) {
        int s = 0;
        int prevKey = 0;
        HashSet<Integer> keystoRemove = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if(s==0) {
                s++;
                prevKey = key;
                if(val == 1) {
                    keystoRemove.add(key);
                }
                else map.put(key, map.get(key)-1);
            } else {
                if(prevKey == key - 1) {
                    s++;
                    prevKey = key;
                    if(val == 1) keystoRemove.add(key);
                    else map.put(key, map.get(key)-1);
                } else {
                    return false;
                }
            }
            if(s == size) break;
        }
        for(Integer i : keystoRemove) {
            map.remove(i);
        }
        return s==size;
    }


    public static void main(String[] args) {
        HandOfStraight HS = new HandOfStraight();
        System.out.println(HS.isNStraightHand(new int[] {0,1}, 2));
    }
//    public boolean isNStraightHand(int[] hand, int groupSize) {
//        int n = hand.length;
//        if(n % groupSize != 0)
//            return false;
//        int max = 0;
//        for(int i : hand) max = Math.max(max, i);
//        int[] map = new int[max + 1];
//        for(int i = 0; i < n; i++) {
//            map[hand[i]]++;
//        }
//        while(true) {
//            int sum = getCards(map, max, groupSize);
//            if(sum == 0) return true;
//            else if(sum < groupSize) return false;
//        }
//    }
//    public int getCards(int[] map, int n, int size) {
//        int s = 0;
//        int prevKey = 0;
//        int sum = 0;
//        for(int i = 0; i <= n; i++) {
//            if(map[i] > 0 && s < size) {
//                int value = map[i];
//                if(s == 0) {
//                    s++;
//                    prevKey = i;
//                    map[i] = value-1;
//                } else {
//                    if(prevKey == i - 1) {
//                        s++;
//                        prevKey = i;
//                        map[i] = value-1;
//                    } else {
//                        return -1;
//                    }
//                }
//            }
//            if(s == size) break;
//        }
//        for(int i : map) sum += i;
//        return sum;
//    }
}
