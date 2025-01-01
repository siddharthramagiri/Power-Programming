package linkedList;

import java.util.Stack;

public class ReOrderList {

    public static void reorderList(Node head) {
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        curr = head;
        if(stack.size() % 2 == 0) {
            while (curr != stack.peek()) {
                Node temp = stack.pop();
                temp.next = curr.next;
                if (curr.next == temp) {
                    temp.next = null;
                    break;
                }
                curr.next = temp;
                curr = temp.next;
            }
        } else {
            while (curr != stack.peek()) {
                Node temp = stack.pop();
                temp.next = curr.next;
                if (curr.next == temp) {
                    temp.next = null;
                    break;
                }
                curr.next = temp;
                curr = temp.next;
            }
            if (curr == stack.peek())
                curr.next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList L1 = new LinkedList();
        L1.insertHead(1);
        L1.insertLast(2);
        L1.insertLast(3);
        L1.insertLast(4);
        L1.insertLast(5);
//        L1.insertLast(6);
        L1.display();
        reorderList(L1.head);
        L1.display();
    }
}
