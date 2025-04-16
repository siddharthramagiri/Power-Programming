package DSA;

import java.util.ArrayList;
import java.util.List;

public class SerializeandDeserializeBinaryTree {
    StringBuilder sb;
    int i;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        getAllNodes(root);
        return sb.substring(1);
    }
    public void getAllNodes(TreeNode root) {
        if(root == null) {
            this.sb.append(",null");
            return;
        }
        this.sb.append(",").append(root.val);
        getAllNodes(root.left);
        getAllNodes(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return setAllNodes(nodes, null);
    }
    public TreeNode setAllNodes(String[] nodes, TreeNode root) {
        if(nodes[i].equals("null")) {
            return null;
        }
        root = new TreeNode(Integer.parseInt(nodes[i]));
        i++;
        root.left = setAllNodes(nodes, root.left);
        i++;
        root.right = setAllNodes(nodes, root.right);
        return root;
    }
    public static void display(TreeNode root) {
        if(root == null) {
            System.out.println("null");
            return;
        }
        System.out.println(root.val);
        display(root.left);
        display(root.right);
    }
    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree ser = new SerializeandDeserializeBinaryTree();
        SerializeandDeserializeBinaryTree deser = new SerializeandDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        TreeNode ans = deser.deserialize(ser.serialize(root));
        display(ans);
//        SerializeandDeserializeBinaryTree SD = new SerializeandDeserializeBinaryTree();
//        SD.display(ans);
    }
}
