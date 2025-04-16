package DSA;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ConstructBinaryTreefromPrePost {
    HashMap<Integer, Integer> map;
    HashSet<Integer> used;
    Stack<Integer> stack = new Stack<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        map = new HashMap<>();
        int n = postorder.length;
        for(int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        used = new HashSet<>();
        TreeNode root = new TreeNode(preorder[0]);
        used.add(preorder[0]);
        stack.push(preorder[0]);
        insert(root, 1, preorder);
        return root;
    }
    public void insert(TreeNode root, int preIdx, int[] preorder) {
        if(root == null) return;
        while(preIdx < preorder.length && used.contains(preorder[preIdx])) {
            preIdx++;
        }
        if(preIdx >= preorder.length) return;
        //Left
        if(map.get(stack.peek()) > map.get(preorder[preIdx])) {
            root.left = new TreeNode(preorder[preIdx]);
            stack.push(preorder[preIdx]);
            used.add(preorder[preIdx]);
            insert(root.left, preIdx + 1, preorder);
        } else {
            stack.pop();
            return;
        }
        // Right
        while(preIdx < preorder.length && used.contains(preorder[preIdx])) {
            preIdx++;
        }
        if(preIdx >= preorder.length) return;
        if(map.get(stack.peek()) > map.get(preorder[preIdx])) {
            root.right = new TreeNode(preorder[preIdx]);
            stack.push(preorder[preIdx]);
            used.add(preorder[preIdx]);
            insert(root.right, preIdx + 1, preorder);
        } else {
            stack.pop();
            return;
        }
        stack.pop();
    }
    public void display(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        ConstructBinaryTreefromPrePost CBP = new ConstructBinaryTreefromPrePost();
        int[] preorder = {2,1}, postorder = {1,2};
        TreeNode root = CBP.constructFromPrePost(preorder, postorder);
        CBP.display(root);
    }
}
