package DSA;

public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int n = getLength(head);
        if(n == 0 || k == 0) return head;
        int i = 1;
        if(k>=n){
            k=k%n;
        }
        k=n-k;
        ListNode Dummy = new ListNode(0);
        ListNode dumm = Dummy;
        ListNode curr = head;
        while(i < k) {
            curr = curr.next;
            i++;
        }
        dumm.next = curr.next;
        curr.next = null;
        while(dumm.next != null) {
            dumm = dumm.next;
        }
        dumm.next = head;
        return Dummy.next;
    }
    public static int getLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            length++;
        }
        return length;
    }
    public static void display(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode res = rotateRight(head, 4);
        display(res);
    }
}
