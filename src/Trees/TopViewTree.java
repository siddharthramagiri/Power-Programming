package Trees;

import java.util.HashMap;

public class TopViewTree {
    public static void getTopView(BiNode root, int row, HashMap<Integer,Integer> dist) {
        if(root == null || dist.containsKey(row)) {
            return;
        }
        dist.put(row,root.data);
        getTopView(root.left,row - 1, dist);
        getTopView(root.right, row + 1, dist);
    }

    public static void main(String[] args) {
        BiNode root = new BiNode(1);
        root.left = new BiNode(2);
        root.right = new BiNode(3);
        root.left.left = new BiNode(4);
        root.left.left.right = new BiNode(8);
        root.left.left.right.right = new BiNode(9);
        root.left.left.left = new BiNode(5);
        root.right.left = new BiNode(6);
        root.right.right = new BiNode(7);

        HashMap<Integer,Integer> dist = new HashMap<>();
        getTopView(root, 0, dist);
        for(Integer k : dist.keySet()) {
            System.out.println(dist.get(k));
        }
    }
}
