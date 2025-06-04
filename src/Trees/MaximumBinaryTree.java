package Trees;

public class MaximumBinaryTree {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        int left = 0, right = nums.length;
        int maxIndex = 0, max = 0;
        for(int i = left; i < right; i++) {
            if(max <= nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructTree(root.left, nums, left, maxIndex);
        root.right = constructTree(root.right, nums, maxIndex + 1, right);
        return root;
    }
    public static TreeNode constructTree(TreeNode root, int[] nums, int left, int right) {
        if(left < 0 || right > nums.length || left >= right) return null;

        int maxIndex = 0, max = 0;
        for(int i = left; i < right; i++) {
            if(max <= nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        root = new TreeNode(max);
        root.left = constructTree(root.left, nums, left, maxIndex);
        root.right = constructTree(root.right, nums, maxIndex + 1, right);
        return root;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = constructMaximumBinaryTree(nums);
//        PracticeTrees.inorderTranverse(root);
        PracticeTrees.LevelOrderTraverse(root, PracticeTrees.height(root));
    }
}
