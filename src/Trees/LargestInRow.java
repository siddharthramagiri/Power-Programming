package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class LargestInRow {
    public static List<Integer> largestValues(TreeNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map = getMaxinLevel(root, 0, map);
        List<Integer> list = new ArrayList<>(map.values());
        return list;
    }
    public static TreeMap<Integer, Integer> getMaxinLevel
            (TreeNode root, int level, TreeMap<Integer, Integer> map) {
        if(root == null) return map;
        map.put(level, Math.max(root.data,map.getOrDefault(level,root.data)));
        map = getMaxinLevel(root.left, level + 1, map);
        map = getMaxinLevel(root.right, level + 1, map);
        return map;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(largestValues(root));
    }
}
