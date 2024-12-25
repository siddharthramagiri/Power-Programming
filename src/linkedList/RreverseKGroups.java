package linkedList;
import java.util.ArrayList;

public class RreverseKGroups {
    public static int getLength(Node head) {
        Node curr = head;
        int len = 0;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        System.out.println(len);
        return len;
    }
    public static Node reverseKGroup(Node head, int k) {
        int n = getLength(head) / k;
        ArrayList<Node> Nodes = new ArrayList<>();
        Node curr = head;
        Node Dummy = new Node(0);
        Node temp = Dummy;

        while (curr != null) {
            if (n > 0) {
                if (n > 0) {
                    if (Nodes.size() < k) {
                        Nodes.add(curr);
                        curr = curr.next;
                    } else {
                        while (Nodes.size() != 0) {
                            temp.next = Nodes.removeLast();
                            temp = temp.next;
                        }
                        n--;
                    }
                } else {
                    break;
                }
            }
        }
        while (Nodes.size() != 0) {
            temp.next = Nodes.removeLast();
            temp = temp.next;
        }
        temp.next = curr;
        return Dummy.next;
    }
    
    public static void main (String[] args) {
        LinkedList LL = new LinkedList();
        LL.insertHead(1);
        LL.insertLast(2);
        LL.insertLast(3);
        LL.insertLast(4);
        LL.insertLast(5);
        LL.display();
        LL.head = reverseKGroup(LL.head, 2);
        LL.display();
    }
}

