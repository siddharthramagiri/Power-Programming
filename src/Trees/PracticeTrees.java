package Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
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

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(15);
        root.right.right.left.left = new TreeNode(7);

//        LevelOrderTraverse(root,height(root));

//        TreeMap<Integer,Pair> hdist = new TreeMap<>();
//        getBottomView(root, hdist);
//        for(Integer i : hdist.keySet()) {
//            System.out.print(hdist.get(i).data + " ");
//        }

//        TreeNode ans = lowestCommonAncestor(root, new TreeNode(6), new TreeNode(7));
//        LevelOrderTraverse(ans,height(ans));

        TreeNode ans = deleteNode(root, 5);
        LevelOrderTraverse(ans,height(ans));
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.data < key) root.right =  deleteNode(root.right, key);
        else if(root.data > key) root.left =  deleteNode(root.left, key);
        else { // if root is found
            if(root.left == null && root.right == null) {
                return null;
            } else if (root.right == null) return root.left;
            else if (root.left == null) return root.right;
            else {
                TreeNode Isuccessor = FindMin(root.right);
                root.data = Isuccessor.data;
                root.right = deleteNode(root.right, Isuccessor.data);
            }
        }
        return root;
    }
    public static TreeNode FindMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static ArrayList<Integer> getPath(TreeNode root, int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        path(root, arr, n);
        return arr;
    }
    public static boolean path(TreeNode root,ArrayList<Integer> arr, int n) {
        if(root == null) return false;
        arr.add(root.data);
        if(root.data == n) return true;
        if(path(root.left, arr, n) || path(root.right,arr, n)) return true;
        arr.removeLast();
        return false;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.data == p.data || root.data == q.data)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return (left == null) ? right : (right == null) ? left : root;
    }
}
