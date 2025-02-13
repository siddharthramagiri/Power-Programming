package Trees;

import java.util.List;

public class BalancedBinaryTree {
    class Node {
        int val, height;
        Node left, right;
        public Node () {}
        public Node(int val) {
            this.val = val;
            height = 0;
        }
    }

    private Node root;
    private int Height(Node root) {
        return root==null? -1 : root.height;
    }

    private int getBalance(Node root) {
        return root==null? 0 : (Height(root.left)- Height(root.right));
    }

    private Node leftRotate(Node root) {
        if(root == null || root.right == null) return root;
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        root.height = Math.max(Height(root.left), Height(root.right)) - 1;
        newRoot.height = Math.max(Height(root.left), Height(root.right)) + 1;
        return newRoot;
    }
    private Node rightRotate(Node root) {
        if(root == null || root.right == null) return root;
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        root.height = Math.max(Height(root.left), Height(root.right)) + 1;
        newRoot.height = Math.max(Height(root.left), Height(root.right)) - 1;
        return newRoot;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    public Node insert(Node root, int val) {
        if(root == null) return new Node(val);

        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val);
        else return root;
        // Update Heights...
        root.height = Math.max(Height(root.left), Height(root.right)) + 1;
        int balance = getBalance(root);
        if(balance > 1 && val < root.left.val) return rightRotate(root);
        if(balance < -1 && val > root.right.val) return leftRotate(root);
        if(balance > 1 && val > root.left.val) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(balance < -1 && val < root.right.val) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }
    public void levelOrder(Node root) {
        int height = getHeight(root);
        for(int level = 0; level < height; level++) {
            levelTraverse(root,level,0, height);
            System.out.println();
        }
    }
    public void levelTraverse(Node root, int level, int row, int height) {
        if(root == null) return;
        if(level == row) {
            for(int i = height; i >= level; i--)
                System.out.print(" ");
            System.out.print(root.val + "  ");
        }
        levelTraverse(root.left, level, row+1, height);
        levelTraverse(root.right, level, row+1, height);
    }
    public int getHeight(Node root) {
        return (root == null)? 0
                : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(20);
        tree.insert(25);
        tree.insert(15);
        tree.insert(30);
        tree.insert(40);
//        tree.insert(6);

        tree.inorder(tree.root);
        System.out.println();
        tree.levelOrder(tree.root);

    }
}
