package Trees;

import java.util.*;

public class KthAncestorTreeNode {

    public static void main(String[] args) {
        Deque<Integer> Q = new ArrayDeque<>();
        Q.add(1);
        Q.add(2);
        Q.add(3);
        Q.add(4);
        Q.add(5);
        List<Integer> list = List.of(1,2,3,4);
        System.out.println(Q.containsAll(list));
        System.out.println(Q);

    }
}
