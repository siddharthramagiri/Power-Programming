package DSA;

import java.util.HashSet;

public class FindElementsinContaminatedBinaryTree {
    TreeNode root;
    HashSet<Integer> set = new HashSet<>();
    public FindElementsinContaminatedBinaryTree(TreeNode root) {
        this.root = root;
        this.root.val = 0;
        change(this.root, 0);
    }
    public void change(TreeNode root, int r) {
        if(root != null) {
            if(root.left != null) root.left.val = 2*r+1;
            if(root.right != null) root.right.val = 2*r+2;
            set.add(root.val);
            change(root.left, root.left != null ? root.left.val : 0);
            change(root.right, root.right != null ? root.right.val : 0);
        }
    }
    public boolean find(int target) {
        return set.contains(target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);
        FindElementsinContaminatedBinaryTree FE = new FindElementsinContaminatedBinaryTree(root);
        System.out.println(FE.find(1));

    }
}
