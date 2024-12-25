package Trees;

public class DeepestLeavesSum {
    public static int height(BiNode root) {
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    public static int deepestLeavesSum(BiNode root) {
        int level = height(root);
        int sum = 0;
        sum = deepest(root, level, sum);
        return sum;
    }
    public static int deepest(BiNode root, int level, int sum) {
        if(root == null) return 0;
        if(level == 1){
            sum = root.data;
            return sum;
        }
        int l = deepest(root.left , level - 1, sum);
        int r = deepest(root.right , level - 1, sum);
        return (l + r);
    }

    public static void main(String[] args) {
        BiNode root = new BiNode(1);
        root.left = new BiNode(2);
        root.right = new BiNode(3);
        root.left.left = new BiNode(4);
        root.left.right = new BiNode(5);
        root.left.left.left = new BiNode(7);
        root.right.right = new BiNode(6);
        root.right.right.right = new BiNode(8);

        System.out.println(deepestLeavesSum(root));
    }
}
