package DSA;


import java.util.ArrayList;
import java.util.List;

public class RecoverTreeFromPreorderTraversal {
    int index = 0;
    int n = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        List<Integer> list = new ArrayList<>();
//        list.getLast();
//        list.removeLast();
        n = traversal.length();
        return recursion(traversal, 0);
    }
    public TreeNode recursion(String traversal, int depth) {
        if(index >= n) return null;
        int count = 0;
        int tempI = index;
        while(tempI < n && !Character.isDigit(traversal.charAt(tempI))) {
            count++;
            tempI++;
        }
        if(count != depth) return null;
        int val = 0;
        index = tempI;
        while(index < n && Character.isDigit(traversal.charAt(index))) {
            val = val * 10 + (traversal.charAt(index) - '0');
            index++;
        }
        TreeNode node = new TreeNode(val);
        node.left = recursion(traversal, depth+1);
        node.right = recursion(traversal, depth+1);
        return node;
    }

    public void display(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            display(root.left);
            display(root.right);
        }
    }

    public static void main(String[] args) {
        RecoverTreeFromPreorderTraversal RTPT = new RecoverTreeFromPreorderTraversal();
        String traversal = "1-2--3---4-5--6---7";
        TreeNode root = RTPT.recoverFromPreorder(traversal);
        RTPT.display(root);
    }
}
