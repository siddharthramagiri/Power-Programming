package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
public class BurningTree {
    public static int minTime(Node root, int target) {
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        int maxElement = maxElement(root, root.data);
        for(int i = 0; i <= maxElement; i++) {
            graph.add(new ArrayList<>());
        }
        constructGraph(graph, root, root.data);
        System.out.println(graph);
        // BFS
        boolean[] visited = new boolean[maxElement + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(target);
        visited[target] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            while(size-- > 0) {
                int node = queue.poll();
                for(int neighbour : graph.get(node)) {
                    if(!visited[neighbour]) {
                        flag = true;
                        visited[neighbour] = true;
                        queue.add(neighbour);
                    }
                }
            }
            if(flag) count++;
        }
        return count;
    }
    public static void constructGraph(List<List<Integer>> graph, Node root, int parentNode) {
        if(root.left == null && root.right == null) return;
        if(root.left != null) {
            graph.get(parentNode).add(root.left.data);
            graph.get(root.left.data).add(parentNode);
            constructGraph(graph, root.left, root.left.data);
        }
        if(root.right != null) {
            graph.get(parentNode).add(root.right.data);
            graph.get(root.right.data).add(parentNode);
            constructGraph(graph, root.right, root.right.data);
        }
    }
    public static int maxElement(Node root, int max) {
        if(root == null) return max;
        int left = maxElement(root.left, root.left == null? max : root.left.data);
        int right = maxElement(root.right, root.right == null? max : root.right.data);
        return Math.max(left, right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
//        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.right.right = new Node(10);

        System.out.println(minTime(root, 10));

    }
}
