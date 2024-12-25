package linkedList;
import java.util.HashSet;

public class Intersection {
    public static Node Intersection(Node head1, Node head2) {
        HashSet<Node> set = new HashSet<>();
        Node curr = head1;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        curr = head2;
        while (curr != null) {
            if (set.contains(curr))
                return curr;
            curr = curr.next;
        }
        return null;
    }

    public static Node IntersectionUsingN2(Node head1, Node head2) {
        Node curr1 = head1;
        while(curr1 != null){
            Node curr2 = head2;
            while(curr2 != null) {
                if(curr2 == curr1) return curr1;
                curr2 = curr2.next;
            }
            curr1 = curr1.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(0);
        l1.next.next.next = new Node(3);
        l1.next.next.next.next = new Node(5);

        Node l2 = new Node(6);
        l2.next = new Node(7);
        l2.next.next = new Node(8);
        l2.next.next.next = new Node(9);

        l1.next.next.next.next.next = l2.next.next;

        Node inter = Intersection(l1, l2);

        LinkedList LL = new LinkedList();
        LL.head= inter;
        LL.display();

        inter = IntersectionUsingN2(l1,l2);
        LL.head = inter;
        LL.display();
    }
}
