package Trees;
import java.util.*;
public class ReverseOddLevelsBinaryTree {
    public HashMap<Integer, Stack<TreeNode>> map;
    public TreeNode reverseOddLevels(TreeNode root) {
        map = new HashMap<>();
        levelTraverse(root, 0);
        modifyTree(root, 0);
        return root;
    }
    public void levelTraverse(TreeNode root, int level) {
        if(root == null) return;
        if(level % 2 != 0) {
            Stack<TreeNode> stack = map.getOrDefault(level, new Stack<TreeNode>());
            stack.push(root);
            map.put(level, stack);
        }
        levelTraverse(root.left, level + 1);
        levelTraverse(root.right, level + 1);
    }
    public void modifyTree(TreeNode root, int level) {
        if(root == null) return;
        if(level % 2 != 0) {
            Stack<TreeNode> stack = map.get(level);
            // TreeNode node = stack.pop();
            // map.put(level, stack);
            root.data = stack.pop().data;
            for(TreeNode node : stack) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
        modifyTree(root.left, level + 1);
        modifyTree(root.right, level + 1);
    }
    public static void main(String[] args) {

    }
}
