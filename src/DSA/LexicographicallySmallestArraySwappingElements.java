package DSA;

import java.util.*;

public class LexicographicallySmallestArraySwappingElements {
    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        List<Deque<Integer>> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int[] copy = new int[n];
        for(int i = 0; i < n; i++) copy[i] = nums[i];
        Arrays.sort(copy);
        int group = 0;
        list.add(new ArrayDeque<>());
        list.get(group).offer(copy[0]);
        map.put(copy[0], group);
        for(int i = 1; i < n; i++) {
            if(copy[i] - list.get(group).peekLast() > limit) {
                group++;
                list.add(new ArrayDeque<>());
            }
            map.put(copy[i], group);
            list.get(group).offer(copy[i]);
        }
        System.out.println(list);
        System.out.println(map);
        for(int i = 0; i < n; i++) {
            int index = map.get(nums[i]);
            nums[i] = list.get(index).pollFirst();
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,3,9,8};
        int limit = 2;
        int[] res = lexicographicallySmallestArray(nums, limit);
        for(int i : res) System.out.print(i + " ");
    }
}
