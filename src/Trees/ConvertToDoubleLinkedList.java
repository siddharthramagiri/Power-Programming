package Trees;

public class ConvertToDoubleLinkedList {
    static BiNode prev = null;
    static BiNode head = null;

    public static void doublyLL(BiNode root) {
        if(root == null) return;
        doublyLL(root.left);
        if(prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        doublyLL(root.right);
    }
    public static void display() {
        BiNode curr = head;
        while(curr != null) {
            System.out.print(curr.data + "=>");
            curr = curr.right;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        BiNode root = new BiNode(10);
        root.left = new BiNode(12);
        root.left.left = new BiNode(25);
        root.left.right = new BiNode(30);
        root.right = new BiNode(15);
        root.right.left = new BiNode(36);

        doublyLL(root);
        display();

    }
}