package linkedList;

public class AddTwoNumbers {
    public static Node addTwoNumbers(Node l1, Node l2) {
        StringBuilder s1 = new StringBuilder();
        Node curr = l1;
        while(curr != null) {
            s1.append(curr.data);
            curr = curr.next;
        }
        curr = l2;
        StringBuilder s2 = new StringBuilder();
        while(curr != null) {
            s2.append(curr.data);
            curr = curr.next;
        }
        String str = (Long.parseLong(s1.reverse().toString())
                + Long.parseLong(s2.reverse().toString())) + "";
        Node dummy = new Node(0);
        Node temp = dummy;
        for(int i = str.length() - 1; i >= 0; i--) {
            temp.next = new Node(Integer.parseInt(str.charAt(i) + ""));
            temp = temp.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        Node l1 = new Node(9);
        l1.next = new Node(9);
        l1.next.next = new Node(9);
        l1.next.next.next = new Node(9);
        l1.next.next.next.next = new Node(9);
        l1.next.next.next.next.next = new Node(9);
        l1.next.next.next.next.next.next = new Node(9);

        Node l2 = new Node(9);
        l2.next = new Node(9);
        l2.next.next = new Node(9);
        l2.next.next.next = new Node(9);

        LinkedList LL = new LinkedList();
        Node ans = addTwoNumbers(l1,l2);
        LL.head = ans;
        LL.display();
    }
}
