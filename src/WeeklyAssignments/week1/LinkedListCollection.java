package WeeklyAssignments.week1;

import java.util.*;

public class LinkedListCollection {
    static LinkedList<Integer> LL = new LinkedList<>();

    public static void display() {
        for(Integer i : LL) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            if (n == 1) {
                while(sc.hasNextInt()) {
                    int data = sc.nextInt();
                    if(data != -1)
                        LL.add(data);
                    else break;
                }
                System.out.println("LINKED LIST CREATED");
            } else if (n == 2) {
                if(LL.size() == 0)
                    System.out.println("The list is empty");
                else display();
            } else if (n == 3) {
                int data = sc.nextInt();
                LL.addFirst(data);
                System.out.println("The linked list after insertion at the beginning is:");
                display();
            } else if (n == 4) {
                int data = sc.nextInt();
                LL.addLast(data);
                System.out.println("The linked list after insertion at the end is:");
                display();
            } else if (n == 5) {
                int val = sc.nextInt();
                int data = sc.nextInt();
                ListIterator<Integer> it = LL.listIterator();
                boolean updated = false;
                while(it.hasNext()) {
                    if(it.next() == val) {
                        it.previous();
                        it.add(data);
                        updated = true;
                        break;
                    }
                }
                if(!updated) {
                    System.out.println("Value not found in the list");
                }
                System.out.println("The linked list after insertion before a value is:");
                display();
            } else if (n == 6) {
                int val = sc.nextInt();
                int data = sc.nextInt();
                ListIterator<Integer> it = LL.listIterator();
                boolean updated = false;
                while(it.hasNext()) {
                    if(it.next() == val) {
                        it.add(data);
                        updated = true;
                        break;
                    }
                }
                if(!updated) {
                    System.out.println("Value not found in the list");
                }
                System.out.println("The linked list after insertion after a value is:");
                display();
            } else if (n == 7) {
                LL.removeFirst();
                System.out.println("The linked list after deletion from the beginning is:");
                display();
            } else if (n == 8) {
                LL.removeLast();
                System.out.println("The linked list after deletion from the end is:");
                display();
            } else if (n == 9) {
                int val = sc.nextInt();
                ListIterator<Integer> it = LL.listIterator();
                Integer prev = null;
                boolean updated = false;
                while(it.hasNext()) {
                    int current = it.next();
                    if(current == val && prev != null) {
                        it.previous();
                        it.previous();
                        it.remove();
                        updated = true;
                        break;
                    }
                    prev = current;
                }
                if(!updated) {
                    System.out.println("Value not found in the list");
                }
                System.out.println("The linked list after deletion before a value is:");
                display();
            } else if (n == 10) {
                int val = sc.nextInt();
                ListIterator<Integer> it = LL.listIterator();
                boolean updated = false;
                while(it.hasNext()) {
                    if(it.next() == val && it.hasNext()) {
                        it.next();
                        it.remove();
                        updated = true;
                        break;
                    }
                }
                if(!updated) {
                    System.out.println("Value not found in the list");
                }
                System.out.println("The linked list after deletion after a value is:");
                display();
            } else if (n == 11) {
                break;
            } else {
                System.out.println("Invalid option! Please try again");
            }
        }
    }
}
