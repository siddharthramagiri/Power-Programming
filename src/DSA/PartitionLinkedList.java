package DSA;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class ListNode {
    int data;
    ListNode next;
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
public class PartitionLinkedList {
    public static ListNode partitionQ(ListNode head, int x) {
        Deque<ListNode> lesser = new ArrayDeque<>();
        Deque<ListNode> greater = new ArrayDeque<>();
        ListNode curr = head;
        while(curr != null) {
            if(curr.data < x) {
                lesser.offer(curr);
            } else {
                greater.offer(curr);
            }
            curr = curr.next;
        }
        ListNode Dummy = new ListNode(0);
        ListNode dum = Dummy;
        while(!lesser.isEmpty()) {
            dum.next = lesser.pollFirst();
            dum = dum.next;
        }
        while(!greater.isEmpty()) {
            dum.next = greater.pollFirst();
            dum = dum.next;
        }
        dum.next = null;
        return Dummy.next;
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode lesser = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode left = lesser;
        ListNode right = greater;
        while(head != null) {
            if(head.data < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = greater.next;
        return lesser.next;
    }

    public static void display(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.data + " => ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        int x = 3;
        display(head);

        ListNode res = partition(head, x);
        display(res);
    }
}
