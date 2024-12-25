package Trees;

public class MaxValueinBTree {
    public static int MaxVal(BiNode root, int max) {
        if(root == null) {
            return (max == Integer.MIN_VALUE)? -1 : max;
        }
        max = Math.max(root.data, max);
        max = Math.max(MaxVal(root.left, max), MaxVal(root.right, max));
        return max;
    }
    public static BiNode searchBST(BiNode root, int val) {
        if(root ==  null) return root;
        if(root.data == val) return root;
        if(root.data > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
    public static void main(String[] args) {
        BiNode root = new BiNode(0);
        root.left = new BiNode(2);
        root.right = new BiNode(3);
        root.left.left = new BiNode(4);
        root.left.left.right = new BiNode(18);
        root.left.left.right.right = new BiNode(9);
        root.left.left.left = new BiNode(5);
        root.right.left = new BiNode(6);
        root.right.right = new BiNode(7);

        System.out.println(MaxVal(root,Integer.MIN_VALUE));
        BinaryTree.LevelOrderTraversal(root, BinaryTree.height(root));
        BiNode res = searchBST(root, 3);
        BinaryTree.LevelOrderTraversal(res, BinaryTree.height(res));
    }
}
