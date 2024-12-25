package linkedList;

class DNode{
    int data;
    DNode next;
    DNode prev;
    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class DoubleLinkedList {
    DNode head = null;
    public void insertHead(int data) {
        DNode newNode = new DNode(data);
        newNode.next = head;
        newNode.prev = null;
        if(head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }
    public void display() {
        DNode curr = head;
        DNode last = null;
        while(curr != null) {
            System.out.print(curr.data + "=>");
            last = curr;
            curr = curr.next;
        }
        System.out.println("NULL");
        System.out.println("Reverse Traverse");
        while(last != null) {
            System.out.print(last.data + "=>");
            last = last.prev;
        }
        System.out.println("NULL");
    }
    public void insertLast(int data) {
        DNode newNode = new DNode(data);
        DNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        newNode.prev = curr;
        newNode.next = null;
        curr.next = newNode;
    }
    public static void main(String[] args) {
        DoubleLinkedList DLL = new DoubleLinkedList();
        DLL.insertHead(1);
        DLL.insertLast(2);
        DLL.insertLast(3);
        DLL.insertLast(4);
        DLL.insertLast(5);
        DLL.insertLast(6);
        DLL.display();

    }
}
