package Trees;

public class CheckBalanced {

    public static int checkBalanced(BiNode root) {
        if(root == null) return 0;
        int hl = checkBalanced(root.left);
        if(hl == -1) {
            return -1;
        }
        int hr = checkBalanced(root.right);
        if(hr == -1) {
            return -1;
        }
        if(Math.abs(hl - hr) > 1) return -1;
        return Math.max(hl,hr) + 1;
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

        System.out.println(checkBalanced(root));
    }
}
