package Trees;

public class RightViewBT {
    static int max = 0;
    public static void rightTraverse(BiNode root, int level, int row) {
        if(root == null) {
            return;
        }
        if(max == row && level == 0) {
            System.out.println(root.data);
            max++;
        }
        rightTraverse(root.right,level - 1,row);
        rightTraverse(root.left,level - 1,row);

    }
    public static void getRightView(BiNode root, int height) {
        for(int i = 0; i < height; i++) {
            rightTraverse(root, i, i);
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

        getRightView(root, BinaryTree.height(root));

    }
}
