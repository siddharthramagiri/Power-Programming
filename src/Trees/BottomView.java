package Trees;

import java.util.TreeMap;

public class BottomView {
    public static class Pair {
        BiNode node;
        int height;
        Pair(BiNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }
    public static boolean checkHeight(BottomView.Pair p, int height) {
        return (p.height < height);
    }
    public static void getBottomView(BiNode root, int row, TreeMap<Integer, BottomView.Pair> dist, int height) {
        if(root == null) return;
        if(dist.containsKey(row)) {
            if(checkHeight(dist.get(row),height)) {
                dist.put(row, new BottomView.Pair(root, height));
            }
        } else {
            dist.put(row, new BottomView.Pair(root, height));
        }
        getBottomView(root.left, row - 1, dist, height + 1);
        getBottomView(root.right, row + 1, dist, height + 1);
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
        root.right.right.right = new BiNode(10);
        TreeMap<Integer, Pair> Hdist = new TreeMap<>();
        getBottomView(root, 0, Hdist, 0);
        for(Integer i : Hdist.keySet()) {
            System.out.print(Hdist.get(i).node.data + " ");
        }
    }
}
