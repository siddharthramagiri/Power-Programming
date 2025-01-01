package Trees;

public class DeleteNode {
    public static BiNode deletenode(BiNode root, int key) {
        if(root == null) {
            return null;
        }
        if(key < root.data) {
            root.left = deletenode(root.left, key);
        } else if (key > root.data) {
            root.right = deletenode(root.right, key);
        } else {
            if(root.left == null && root.right == null) {
                return null;
            }
            else if(root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                BiNode IS = findMin(root.right);
                root.data = IS.data;
                root.right = deletenode(root.right, IS.data);
            }
        }
        return root;
    }
    public static BiNode findMin(BiNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
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

        BinaryTree.LevelOrderTraversal(root,BinaryTree.height(root));
        BiNode dlt = deletenode(root, 3);
        BinaryTree.LevelOrderTraversal(dlt,BinaryTree.height(dlt));
    }
}
