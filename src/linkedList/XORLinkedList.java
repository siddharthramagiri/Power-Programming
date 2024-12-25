package linkedList;

import java.util.HashMap;

public class XORLinkedList {
    static HashMap<Integer, XORNode> addressMap =  new HashMap<>();
    static int addressCounter = 1;
    public static int getAddress(XORNode node) {
        if(node == null) return 0;
        return addressMap.entrySet().stream()
                .filter(entry -> entry.getValue() == node)
                .map(entry -> entry.getKey())
                .findFirst()
                .orElse(0);
    }
    public static XORNode insert(XORNode head, int data) {
        XORNode newNode = new XORNode(data);
        int newNodeAddress = addressCounter++;
        addressMap.put(newNodeAddress, newNode);
        newNode.npx = getAddress(head);
        if(head != null) {
            head.npx = head.npx ^ newNodeAddress;
        }
        return newNode;
    }
    public static void printList(XORNode head) {
        XORNode curr = head;
        int prevAddress = 0;
        int nextAddress;
        while(curr != null) {
            System.out.print(curr.data + " ");
            nextAddress = prevAddress ^ curr.npx;
            prevAddress = getAddress(curr);
            curr = addressMap.getOrDefault(nextAddress,null);
        }
    }
    public static void printList2(XORNode head) {
        XORNode curr = head;
    }
    public static void main(String[] args) {
        XORNode head = new XORNode(5);
        head = insert(head,6);
        head = insert(head,7);
        head = insert(head,8);
        head = insert(head,9);
        printList(head);
    }
}

class XORNode {
    int data;
    int npx;
    public XORNode(int data) {
        this.data = data;
        this.npx = 0;
    }
}