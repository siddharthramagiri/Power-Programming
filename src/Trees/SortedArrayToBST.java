package Trees;

public class SortedArrayToBST {
    public static int height(BiNode root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh) + 1;
    }
    public static BiNode sortedArrayToBST(int[] nums) {
        BiNode root = null;
        root = createBST(nums,root, 0, nums.length - 1);
        return root;
    }
    public static BiNode createBST(int[] arr, BiNode root, int left, int right) {
        if(left > right) return null;
        int mid = left + (right - left) / 2;
        if(root == null) {
            root = new BiNode(arr[mid]);
        }
        root.left = createBST(arr,root.left,left,mid - 1);
        root.right = createBST(arr,root.right,mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        BiNode root = null;
        root = sortedArrayToBST(arr);
        BinaryTree.LevelOrderTraversal(root,height(root));

    }
}
