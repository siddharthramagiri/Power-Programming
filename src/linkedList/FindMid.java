package linkedList;

public class FindMid {
    public static int findMid(LinkedList ll) {
        Node fast = ll.head;
        Node slow = ll.head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        LinkedList LL = new LinkedList();
        LL.insertHead(0);
        LL.insertLast(2);
        LL.insertLast(3);
        LL.insertLast(4);
        LL.insertLast(5);


//        Node l1 = new Node(1);
//        l1.next = new Node(2);
//        l1.next.next = new Node(0);
//        l1.next.next.next = new Node(3);
//        l1.next.next.next.next = new Node(5);

         int mid = findMid(LL);
         System.out.println(mid);
    }
}
