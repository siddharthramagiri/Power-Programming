package linkedList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class RemoveNodeLL {
    public static Node removeNodes(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Deque<Node> Q = new ArrayDeque<>();
        Node curr = head.next;
        Node prev = head;
        int count = 0;
        while(curr != null) {
            if(prev.data <= curr.data) {
                Q.add(curr);
            }
            prev = curr;
            curr = curr.next;
            count++;
        }
        if(count == Q.size()) {
            Q.addFirst(head);
        }
        Node Dummy = new Node(0);
        Node temp = Dummy;
        while(!Q.isEmpty()) {
            temp.next = Q.poll();
            temp = temp.next;
        }
        return Dummy.next;
    }
    public static void main(String[] args) {
        LinkedList LL = new LinkedList();
        LL.insertHead(1);
        LL.insertLast(1);
        LL.insertLast(1);
        LL.insertLast(1);
//        LL.insertLast(1);

        LL.head = removeNodes(LL.head);
        LL.display();
    }
}
