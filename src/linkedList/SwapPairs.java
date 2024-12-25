package linkedList;

public class SwapPairs {

    public static Node swapPairs(Node head) {
        if(head == null || head.next == null) return head;
        Node first = head;
        Node second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }

    public static void main(String[] args) {
        LinkedList LL = new LinkedList();
        LL.insertHead(1);
        LL.insertLast(2);
        LL.insertLast(3);
        LL.insertLast(4);
        LL.insertLast(5);



        LL.display();
        LL.head = swapPairs(LL.head);
        LL.display();
    }
}
