package Trees;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.TreeMap;

class TreeNode {
    int data;
    TreeNode left, right;
    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
public class PracticeTrees {

    public static TreeNode constructTree(int index, TreeNode root, int[] arr) {
        if(index < arr.length){
            TreeNode newNode = new TreeNode(arr[index]);
            root = newNode;
            root.left = constructTree(index*2 + 1, root.left, arr);
            root.right = constructTree(index*2 + 2, root.right, arr);
        }
        return root;
    }
    public static void inorderTranverse(TreeNode root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        inorderTranverse(root.left);
        inorderTranverse(root.right);
    }
    public static void LevelOrderTraverse(TreeNode root, int height) {
        for(int level = 0; level < height; level++) {
            LevelTraverse(root,level);
            System.out.println();
        }
    }
    public static void LevelTraverse(TreeNode root, int level) {
        if(root == null) return;
        if(level == 0)
            System.out.print(root.data + " ");
        LevelTraverse(root.left,level - 1);
        LevelTraverse(root.right, level - 1);
    }
    public static int height(TreeNode root) {
        if(root == null) return 0;
        return Math.max(height(root.left),height(root.right)) + 1;
    }
    public static TreeNode BinarySearchTree(int[] arr, TreeNode root) {
        for(int i = 0; i < arr.length; i++) {
            root = constructBST(arr[i],root);
        }
        return root;
    }
    public static TreeNode constructBST(int data, TreeNode root) {
        if(root == null) {
            return new TreeNode(data);
        }
        if(root.data > data) {
            root.left = constructBST(data, root.left);
        } else {
            root.right = constructBST(data, root.right);
        }
        return root;
    }
    public static class Pair {
        int data;
        int level;
        public Pair(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }
    public static void getBottomView(TreeNode root, TreeMap<Integer, Pair> hdist) {
        bottomView(root, hdist, 0, 0);
    }
    public static void bottomView(TreeNode root, TreeMap<Integer, Pair> hdist, int level, int d) {
        if(root == null) return;
        hdist.putIfAbsent(d, new Pair(root.data,level));
        if(hdist.get(d).level < level) {
            hdist.put(d, new Pair(root.data, level));
        }
        bottomView(root.left, hdist, level + 1, d - 1);
        bottomView(root.right, hdist, level + 1, d + 1);
    }

    public static void main(String[] args) {
//        int[] arr = {5,2,3,7,6,8};
//        TreeNode root = null;
//        root = constructTree(0,root,arr);
//        inorderTranverse(root);
//        System.out.println();
//        LevelOrderTraverse(root,height(root));
//        System.out.println();
//        root = BinarySearchTree(arr, root);
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.left.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        LevelOrderTraverse(root,height(root));

        TreeMap<Integer,Pair> hdist = new TreeMap<>();
        getBottomView(root, hdist);
        for(Integer i : hdist.keySet()) {
            System.out.print(hdist.get(i).data + " ");
        }
    }
}
