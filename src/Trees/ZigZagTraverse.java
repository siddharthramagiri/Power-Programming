package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigZagTraverse {
    public static void main(String[] args) {
        BiNode root = new BiNode(3);
        root.left = new BiNode(9);
        root.right = new BiNode(20);
        root.right.left = new BiNode(15);
        root.right.right = new BiNode(7);
        ArrayList<List<Integer>> list = zigzagConvert(root,height(root));
        System.out.println(list);
    }
    public static ArrayList<List<Integer>> zigzagConvert(BiNode root, int height) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        boolean flag = true;
        for(int level = 0; level < height; level++) {
            Deque<Integer> Q = new ArrayDeque<>();
            Q = getLine(root,level,flag,Q);
            flag = !flag;
            ans.add(new ArrayList<>(Q));
            System.out.println();
        }
        return ans;
    }
    public static Deque<Integer> getLine(BiNode root, int level, boolean flag, Deque<Integer> Q) {
        if(root != null) {
            if(level == 0) {
                if(flag) Q.addLast(root.data);
                else Q.addFirst(root.data);
                System.out.print(root.data + " ");
            }
            getLine(root.left, level - 1, flag, Q);
            getLine(root.right, level - 1, flag, Q);
        }
        return Q;
    }
    public static int height(BiNode root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh) + 1;
    }

}
