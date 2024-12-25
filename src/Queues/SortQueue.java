package Queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SortQueue {
    public static Deque<Integer> merge(Deque<Integer> left, Deque<Integer> right) {
        Deque<Integer> res = new LinkedList<>();
        while(!left.isEmpty() && !right.isEmpty()) {
            if(left.peek() > right.peek()) {
                res.addLast(left.poll());
            } else {
                res.addLast(right.poll());
            }
        }
        while(!left.isEmpty()) {
            res.addLast(left.poll());
        }
        while(!right.isEmpty()) {
            res.addLast(right.poll());
        }
        return res;
    }
    public static void sortQ(Deque<Integer> Q) {
        if(!Q.isEmpty()) {
            Deque<Integer> leftQ = new LinkedList<>();
            Deque<Integer> rightQ = new LinkedList<>();
            int i = 0;
            int n = Q.size();
            while(i <= n/2) {
                leftQ.add(Q.pollFirst());
                i++;
            }
            while(!Q.isEmpty()) {
                rightQ.add(Q.pollFirst());
            }

            sortQ(leftQ);
            sortQ(rightQ);

            Q = merge(leftQ,rightQ);
            System.out.println(Q);
        }
    }
    public static void Sort(Deque<Integer> Q) {
        int n = Q.size();
        Deque<Integer> lessQ = new LinkedList<>();
        Deque<Integer> greatQ = new LinkedList<>();
        System.out.println(Q);
        while(!Q.isEmpty()) {
           int num1 = Q.peekFirst();
           int num2 = Q.peekLast();
           if(num1 < num2) {
               lessQ.add(Q.pollFirst());
               greatQ.add(Q.pollLast());
           } else {
               lessQ.add(Q.pollLast());
               greatQ.add(Q.pollFirst());
           }
        }
        System.out.println(Q);
        System.out.println(lessQ);
        System.out.println(greatQ);
    }
    public static void main(String[] args) {
        Deque<Integer> Q = new ArrayDeque<>();
        Q.add(5);
        Q.add(4);
        Q.add(1);
        Q.add(2);
        Q.add(3);
//        Sort(Q);
        sortQ(Q);
    }
}
