package DSA;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SwappingNodesinLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        int len = getLength(head);
        int kfEnd = len - k + 1;
        Stack<ListNode> stack = new Stack<>();
        int i = 1;
        while(curr != null) {
            if(i == k || i == kfEnd) {
                stack.push(new ListNode(curr.data));
            }
            curr = curr.next;
            i++;
        }
        curr = head;
        ListNode Dummy = new ListNode(0);
        ListNode dumm = Dummy;
        i = 1;
        while(curr != null) {
            if(i == k || i == kfEnd) {
                dumm.next = stack.pop();
            } else {
                dumm.next = curr;
            }
            dumm = dumm.next;
            curr = curr.next;
            i++;
        }
        return Dummy.next;
    }
    public int getLength(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        return len;
    }

    public void display(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.data + "=>");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        SwappingNodesinLinkedList SWL = new SwappingNodesinLinkedList();
        ListNode res = SWL.swapNodes(head, 2);
        SWL.display(res);

    }
}
