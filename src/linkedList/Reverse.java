package linkedList;

public class Reverse {
    public static void reverse(LinkedList LL) {
        Node curr = LL.head;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        LL.head = prev;
    }
    public static void main(String[] args) {
        LinkedList LL = new LinkedList();
        LL.insertHead(0);
        LL.insertLast(2);
        LL.insertLast(3);
        LL.insertLast(4);
        LL.insertLast(5);
        reverse(LL);
        LL.display();
    }
}
