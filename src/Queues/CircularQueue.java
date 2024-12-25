package Queues;

public class CircularQueue {
    int[] queue;
    int front, rear, size;
    CircularQueue(int size) {
        this.size = size;
        this.rear = -1;
        this.front = -1;
        queue = new int[size];
    }
    public void enqueue(int data) {
        if((rear + 1) % size == front) {
            System.out.println("Queue is Full");
            return;
        }
        if(front == -1) front = 0;
        rear=(rear + 1) % size;
        queue[rear] = data;
        System.out.println("Enqueued : " + data);
    }
    public void dequeue() {
        if(front == -1) {
            System.out.println("Queue is Empty");
            return;
        }
        int data = queue[front];
        queue[front] = 0;
        if(front == rear) {
            front = rear = -1;
        } else {
            front = (front+1) % size;
        }
        System.out.println("Dequeued : " + data);
    }
    public void display() {
        int i = front;
        while(true) {
            System.out.println(queue[i]+ " ");
            if(i == rear) return;
            i = (i + 1) % size;
        }
    }

    public static void main(String[] args) {
        CircularQueue CQ = new CircularQueue(5);
        CQ.enqueue(5);
        CQ.enqueue(4);
        CQ.enqueue(4);
        CQ.enqueue(4);

    }
}
