package Trees;

public class SubTrees {
//    public static boolean isSubtree(BiNode root, BiNode subRoot) {
//        if(root != null) {
//            if(root == subRoot) return true;
//            boolean ans = isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
//            return ans;
//        }
//        return false;
//    }
    public static boolean isSubtree(BiNode root, BiNode subRoot) {
        if(root == null) return (subRoot == null);
        if(isIdentical(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static boolean isIdentical(BiNode root, BiNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.data == subRoot.data) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {


        BiNode root = new BiNode(3);
        root.right = new BiNode(5);
        root.left = new BiNode(4);

        BiNode subRoot = new BiNode(4);
        subRoot.left = new BiNode(1);
        subRoot.right = new BiNode(2);

        System.out.println(isSubtree(root,subRoot));
    }
}
