package Trees;

public class MirrorTree {
    public static boolean isMirror(BiNode root1, BiNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.data != root2.data) {
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        } else {
            return false;
        }
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

        System.out.println(isMirror(root,root));
    }
}
