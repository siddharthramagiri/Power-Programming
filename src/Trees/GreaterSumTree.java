package Trees;

import java.util.HashMap;

public class GreaterSumTree {
    static int sum = 0;
    public static TreeNode bstToGst(TreeNode root) {
        Decreasing(root);
        return root;
    }

    public static void Decreasing(TreeNode root) {
        if(root == null) return;
        Decreasing(root.left);
        sum += root.data;
        root.data = sum;
        Decreasing(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

//        PracticeTrees.LevelOrderTraverse(root,PracticeTrees.height(root));
        root = bstToGst(root);
        PracticeTrees.LevelOrderTraverse(root,PracticeTrees.height(root));
    }
}
