package linkedList;

import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        LinkedList LL = new LinkedList();
        LL.insertHead(1);
        LL.insertLast(2);
        LL.insertLast(3);
        LL.insertLast(4);
        LL.insertLast(5);
        LL.insertLast(4);
        LL.insertLast(3);
        LL.insertLast(2);
        LL.insertLast(1);
        boolean res = isPalindrome(LL);
        System.out.println("Using Stack : " + res);
        boolean res2 = PalindromeLL(LL.head);
        System.out.println("By Reversing : " + res2);
    }

    public static boolean PalindromeLL(Node head) {
        Node mid = FindMid(head);
        Node revMid = reverseLL(mid);
        Node curr = head;
        while(curr.next != null && revMid.next != null) {
            if(curr.data != revMid.data) {
                return false;
            }
            curr = curr.next;
            revMid = revMid.next;
        }
        return true;
    }

    public static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static Node FindMid(Node head) {
        Node slow = head;
        Node fast = head;
        while(slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            System.out.println("Slow ptr : " + slow.data);
            System.out.println("Fast ptr : " + fast.data);
        }
        return slow;
    }

    public static boolean isPalindrome(LinkedList LL) {
        Stack<Integer> stack = new Stack<>();
        Node curr = LL.head;
        while (curr != null) {
            stack.push(curr.data);
            curr = curr.next;
        }
        curr = LL.head;
        while (curr != null) {
            if (stack.pop() != curr.data)
                return false;
            curr = curr.next;
        }
        return true;
    }

}
