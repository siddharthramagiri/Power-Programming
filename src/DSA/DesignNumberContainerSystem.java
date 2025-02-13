package DSA;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class DesignNumberContainerSystem {
    TreeMap<Integer, Integer> map;
    TreeMap<Integer, TreeSet<Integer>> ref;
    public DesignNumberContainerSystem() {
        map = new TreeMap<>();
        ref = new TreeMap<>();
    }

    public void change(int index, int number) {
        Integer val = map.get(index);
        if(val != null) {
            TreeSet<Integer> pq = ref.get(val);
            pq.remove(index);
            if(pq.isEmpty())
                ref.remove(val);
            else
                ref.put(val,pq);
        }
        map.put(index, number);
        TreeSet<Integer> pq = ref.getOrDefault(number, new TreeSet<>());
        pq.add(index);
        ref.put(number,pq);
    }

    public int find(int number) {
        if(!ref.containsKey(number)) {
            return -1;
        }
        TreeSet<Integer> pq = ref.get(number);
        return pq.first();
    }
    public static void main(String[] args) {
        DesignNumberContainerSystem obj = new DesignNumberContainerSystem();
        System.out.println(obj.find(10));
        obj.change(2,10);
        obj.change(1,10);
        obj.change(3,10);
        obj.change(5,10);
        System.out.println(obj.find(10));
        obj.change(1,20);
        System.out.println(obj.find(10));

    }
}
