package Trees;

public class CreateTree {

    public static BiNode createTree(int i, int[] arr, BiNode root) {
        if(i < arr.length) {
            BiNode temp = new BiNode(arr[i]);
            root = temp;
            root.left = createTree((i*2+1), arr, root.left);
            root.right = createTree((i*2+2), arr, root.right);
        }
        return root;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,8};
        BiNode root = null;
        BiNode res = createTree(0, arr, root);
        BinaryTree.LevelOrderTraversal(res,BinaryTree.height(res));
    }
}
