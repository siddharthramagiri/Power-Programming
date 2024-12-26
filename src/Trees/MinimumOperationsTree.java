package Trees;

import java.util.*;

public class MinimumOperationsTree {
    public static int minimumOperations(TreeNode root) {
        TreeMap<Integer, ArrayList<Integer>> lists = new TreeMap<>();
        LevelTraverse(root, 0, lists);
        System.out.println(lists);
        return SortSwaps(lists);
    }
    public static void LevelTraverse(TreeNode root, int level,
               TreeMap<Integer, ArrayList<Integer>> list) {
        if(root == null) return;
        ArrayList<Integer> l = list.getOrDefault(level, new ArrayList<>());
        l.add(root.data);
        list.put(level,l);
        LevelTraverse(root.left, level + 1, list);
        LevelTraverse(root.right, level + 1, list);
    }
    public static int SortSwaps(TreeMap<Integer, ArrayList<Integer>> map) {
        int count = 0;
        int[] arr;
        int[] temp;
        for(int key : map.keySet()) {
            ArrayList<Integer> list = map.get(key);

            int n = list.size();
            arr = new int[n];
            temp = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = list.get(i);
                temp[i] = list.get(i);
            }
            Arrays.sort(temp);
            for(int i = 0; i < n; i++) {
                if(temp[i] != arr[i]) {
                    int j = getIndex(arr,temp[i], n);
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                    count++;
                }
            }
            System.out.println("Operations : " + count);
        }
        return count;
    }
    public static int getIndex(int[] arr, int d, int n) {
        for(int i = 0; i < n; i++) {
            if(arr[i] == d) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
//        root.right.left.left = new TreeNode(9);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(10);

        System.out.println(minimumOperations(root));

    }
}
