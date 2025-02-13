package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class InsufficientNodesRootToLeafPaths {
    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return calSum(0, limit, root);
    }
    public TreeNode calSum(int sum , int limit, TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) {
            return (sum + root.val < limit) ? null : root;
        }
        root.left = calSum(sum + root.val , limit , root.left);
        root.right = calSum(sum + root.val , limit , root.right);
        return (root.left == null && root.right == null)? null : root;
    }

    public static TreeNode constructTree(int i, int[] arr, TreeNode root) {
        if(i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;
            root.left = constructTree((i*2+1), arr, root.left);
            root.right = constructTree((i*2+2), arr, root.right);
        }
        return root;
    }

    public static int getHeight(TreeNode root) {
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    int count = 0;
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        perfectSubTree(root, list);
        Collections.sort(list);
        System.out.println(list);
        return list.get(list.size() - k);
    }

    public void perfectSubTree(TreeNode root, List<Integer> list) {
        if(root == null) return;
        int d = getHeight(root);
        if(isPerfect(root, d)) {
            list.add(getNodesCount(root));
            count = 0;
        }
        perfectSubTree(root.left, list);
        perfectSubTree(root.right, list);
    }

    public boolean isPerfect(TreeNode root, int d) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return d == 1;
        else if(root.left == null || root.right == null) return false;

        return isPerfect(root.left, d - 1) && isPerfect(root.right, d - 1);
    }
    public int getNodesCount(TreeNode root) {
        if(root != null) {
            count++;
            getNodesCount(root.left);
            getNodesCount(root.right);
        }
        return count;
    }

    public static void main(String[] args) {
        InsufficientNodesRootToLeafPaths INR = new InsufficientNodesRootToLeafPaths();
//        TreeNode tree = new TreeNode(5);
//        tree.left = new TreeNode(4);
//        tree.right = new TreeNode(8);
//        tree.left.left = new TreeNode(11);
//        tree.left.left.left = new TreeNode(7);
//        tree.left.left.right = new TreeNode(1);
//        tree.right.left = new TreeNode(17);
//        tree.right.right = new TreeNode(4);
//        tree.right.right.left = new TreeNode(5);
//        tree.right.right.right = new TreeNode(3);
        TreeNode root = null;
        int[] arr = {1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14};
        TreeNode tree = constructTree(0,arr,root);

        LevelOrderTraverse(tree);
        System.out.println();
        TreeNode res = INR.sufficientSubset(tree, 1);
        LevelOrderTraverse(res);
//        root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(2);
//        root.left.left.left = new TreeNode(1);
//        root.left.left.right = new TreeNode(8);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(7);
//        root.right.left.left = new TreeNode(6);
//        root.right.left.right = new TreeNode(8);
//        // LevelOrderTraverse(root);
//        System.out.println(INR.kthLargestPerfectSubtree(root, 2));
    }
    public static void LevelOrderTraverse(TreeNode root) {
        int height = getHeight(root);
        for(int l = 0; l < height; l++) {
            levelTraverse(root, l, 0);
        }
    }
    public static void levelTraverse(TreeNode root, int l, int row) {
        if(root == null) {
            System.out.print("null ");
            return;
        }
        if(l == row) {
            System.out.print(root.val + " ");
            return;
        }
        levelTraverse(root.left, l, row + 1);
        levelTraverse(root.right, l, row + 1);
    }
}
