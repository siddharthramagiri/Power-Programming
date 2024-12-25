package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LeftViewBT {
    static int max = 0;
    public static void getLeftView(BiNode root, int height) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            Queue<Integer> Q = new ArrayDeque<>();
            LeftTraverse(Q, root, i ,i);
//            System.out.print(Q.poll() + " ");
            ans.add(Q.poll());
        }
        System.out.println(ans);
    }
    public static void LeftTraverse(Queue<Integer> Q, BiNode root, int level, int row) {
        if(root == null) return;
        if(max == row && level == 0) {
            Q.add(root.data);
            max++;
        }
        LeftTraverse(Q, root.left, level - 1, row);
        LeftTraverse(Q, root.right, level - 1, row);
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

        BinaryTree.LevelOrderTraversal(root,BinaryTree.height(root));
        getLeftView(root, BinaryTree.height(root));
    }
}
