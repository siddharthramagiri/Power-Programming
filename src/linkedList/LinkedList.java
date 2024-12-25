package linkedList;

import java.util.HashSet;
import java.util.Stack;

public class LinkedList {
    Node head = null;

    public void insertHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "=>");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public void DeleteLast() {
        Node prev = head;
        if (head == null) {
            System.out.println("Linked List is Empty");
        }
        Node curr = prev.next;
        while (curr.next != null) {
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = null;
    }

}
