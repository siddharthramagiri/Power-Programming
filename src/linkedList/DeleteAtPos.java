package linkedList;

public class DeleteAtPos {
    public static Node deleteNode(Node head, int pos) {
        int count = 1;
        if(head == null) {
            return head;
        }
        Node curr = head;
        while(curr.next != null) {
            count++;
            if (count >= pos)
                break;
            curr = curr.next;
        }
        if(curr.next != null) {
            curr.next = curr.next.next;
        }
        return head;
    }
    public static void main(String[] args) {
        LinkedList LL = new LinkedList();
        LL.insertHead(1);
        LL.insertLast(2);
        LL.insertLast(3);
        LL.insertLast(4);
        LL.insertLast(5);
        LL.insertLast(6);
        LL.insertLast(7);
        LL.head = deleteNode(LL.head, 3);
        LL.display();
    }
}
