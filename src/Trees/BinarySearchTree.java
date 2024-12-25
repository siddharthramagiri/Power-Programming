package Trees;

public class BinarySearchTree {
    public static BiNode ConstructBST(int[] arr, BiNode root) {
        for(int i = 0; i < arr.length; i++) {
            root = insertTree(root,arr[i]);
        }
        return root;
    }
    public static BiNode insertTree(BiNode root, int n) {
        if(root == null) {
            return new BiNode(n);
        }
        if(n < root.data) {
            root.left =  insertTree(root.left, n);
        } else {
            root.right = insertTree(root.right, n);
        }
        return root;
    }
    public static void main(String[] args) {

        BiNode bst = null;
        bst = ConstructBST(new int[] {5,3,6,2,4,7},bst);
        BinaryTree.LevelOrderTraversal(bst,BinaryTree.height(bst));
    }
}
