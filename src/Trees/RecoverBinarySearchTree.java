package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RecoverBinarySearchTree {
    public static void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = getElements(root, list);
        System.out.println(list);
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        System.out.println(sortedList);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            if(!list.get(i).equals(sortedList.get(i))) {
                map.put(list.get(i), sortedList.get(i));
            }
        }
        System.out.println(map);
//        int s1 = -1, s2 = -1;
//        for(int i = 0; i < list.size(); i++) {
//            if(!list.get(i).equals(sortedList.get(i))) {
//                if(s1 == -1) {
//                    s1 = list.get(i);
//                } else {
//                    s2 = list.get(i);
//                    break;
//                }
//            }
//        }
//        System.out.println(s1 + " : " + s2);

        replace(root, map);
    }
    public static void replace(TreeNode root, HashMap<Integer, Integer> map) {
        if(root == null) return;
        replace(root.left, map);
        root.data = map.getOrDefault(root.data,root.data);
        replace(root.right, map);
    }
    public static List<Integer> getElements(TreeNode root, List<Integer> list) {
        if(root == null) return list;
        list = getElements(root.left, list);
        list.add(root.data);
        list = getElements(root.right, list);
        return list;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        PracticeTrees.LevelOrderTraverse(root,PracticeTrees.height(root));
        recoverTree(root);
        PracticeTrees.LevelOrderTraverse(root,PracticeTrees.height(root));
    }
}
