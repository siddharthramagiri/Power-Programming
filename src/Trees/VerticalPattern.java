package Trees;

import java.util.ArrayDeque;
import java.util.TreeMap;

public class VerticalPattern {

    public static void getVerticalPattern(BiNode root, int row, TreeMap<Integer, ArrayDeque<BiNode>> Hdist) {
        if(root == null) return;
        Hdist.putIfAbsent(row, new ArrayDeque<>());
        Hdist.get(row).add(root);

        getVerticalPattern(root.left, row - 1, Hdist);
        getVerticalPattern(root.right, row + 1, Hdist);
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

        TreeMap<Integer, ArrayDeque<BiNode>> Hdist = new TreeMap<>();
        getVerticalPattern(root, 0, Hdist);
        for(Integer i : Hdist.keySet()) {
            while(!Hdist.get(i).isEmpty()) {
                System.out.print(Hdist.get(i).poll().data + " ");
            }
            System.out.println();
        }
    }
}
