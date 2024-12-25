package Trees;
import java.util.*;

public class BinaryTree {
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

//        System.out.println(height(res));
//        LevelOrderTraversal(res,height(res));
//        LevelOrderTraversal(root,height(root));
//        System.out.println();
    }
    public static BiNode insert(BiNode curr, int data) {
        if(curr == null) return new BiNode(data);
        if(data < curr.data) curr.left = insert(curr.left,data);
        if(data>curr.data) curr.right = insert(curr.right, data);
        else return curr;
        return curr;
    }

    public static void InOrder(BiNode root) {
        if(root != null) {
            InOrder(root.left);
            System.out.print(root.data + " => ");
            InOrder(root.right);
        }
    }
    public static void preOrder(BiNode root) {
        if(root != null) {
            System.out.print(root.data + " => ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void postOrder(BiNode root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " => ");
        }
    }

    public static int height(BiNode root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh) + 1;
    }

    public static void levelTraverse(BiNode root, int level) {
        if(root != null) {
            if(level == 0)
                System.out.print(root.data + " ");
            levelTraverse(root.left, level - 1);
            levelTraverse(root.right, level - 1);
        }
    }

    public static void LevelOrderTraversal(BiNode root, int height) {
        for(int level = 0; level < height; level++) {
            levelTraverse(root,level);
            System.out.println();
        }
    }
}