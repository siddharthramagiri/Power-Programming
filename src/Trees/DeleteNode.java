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
//            Logic to delete
//            No childs
            if(root.left == null && root.right == null) {
                return null;
            }
//            Only One Left Child
            else if(root.left == null) {
                return root.right;
            }
//            Only One Right Child
            else if(root.right == null) {
                return root.left;
            }
            // When Node has More than 2 Childs
            BiNode successor = findMin(root.right);
            root.data = successor.data;
            root.right = deletenode(root.right, successor.data);
        }
        return root;
    }
    public static BiNode findMin(BiNode root) {
        if(root.left != null) {
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

        BiNode dlt = deletenode(root, 3);
        BinaryTree.LevelOrderTraversal(dlt,BinaryTree.height(dlt));
    }
}
