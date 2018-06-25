
/**
 * Write a description of class Queue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Queue {
    // Inner class that defines a node.
    private class Node {
        int x;
        boolean empty;
        Node next;

        public Node(int x) {
            this.x = x;
        }

        public Node(Node v) {
            x = v.x;
            empty = v.empty;
            next = v.next;
        }
    }

    Node head;

    /**
     * Constructors for objects of class Queue
     */
    public Queue() {
        head = null;
    }

    public Queue(Queue v) {
        head = v.head;
    }

    /**
     * Enqueue.
     */
    public void enqueue(int x) {
        if (head == null) {
            head = new Node(x);
        } else {
            head.next = new Node(head);
            head.x = x;
        }
    }

    /**
     * Dequeue.
     */
    public int dequeue() {
        long startTime = System.nanoTime();
        if (head.empty) {
            System.out.println("Stack underflow");
            return -1;
        }
        Queue iter = new Queue(this);
        if (iter.head.next == null) {
            return iter.head.x;
        }
        while (iter.head.next.next != null) {
            iter.head = iter.head.next;
        }
        int firstInLine = iter.head.next.x;
        iter.head.next = null;
        long time = System.nanoTime() - startTime;
        System.out.println("Tiempo para hacer un dequeue: " + time/1000000.0 + " milisegundos.");
        return firstInLine;
    }

    /**
     * Show first in line.
     */
    public int showFirstInLine() {
        long startTime = System.nanoTime();
        if (head.empty) {
            System.out.println("Stack underflow");
            return -1;
        }
        Queue iter = new Queue(this);
        if (iter.head.next == null) {
            return iter.head.x;
        }
        while (iter.head.next.next != null) {
            iter.head = iter.head.next;
        }
        long time = System.nanoTime() - startTime;
        System.out.println("Tiempo para mostrar el primero en línea: " + time/1000000.0 + " milisegundos.");
        return iter.head.next.x;
    }

    /**
     * Search.
     */
    public int search(int v) {
        if (head.empty) {
            System.out.println("No items in the queue.");
            return -1;
        }
        Queue iter = new Queue(this);
        if (iter.head.next == null) {
            if (iter.head.x == v) {
                System.out.println("The item has 1 item in front of it.");
                return 1;
            }
            if (iter.head.next.x == v) {
                System.out.println("The item is the first element in the queue");
                return 0;
            }
        }
        while (iter.head.next.next != null) {
            iter.head = iter.head.next;
        }
        return 0;
    }

    public static void main(String[] args) {
        long usedMemBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        Queue qu = new Queue();
        for (int i = 0; i < 10000; i++) {
            qu.enqueue((int) Math.floor(Math.random() * 101));
        }
        int deq = qu.dequeue();
        System.out.println("Dequeue: " + deq);
        deq = qu.dequeue();
        System.out.println("Dequeue: " + deq);
        deq = qu.dequeue();
        System.out.println("Dequeue: " + deq);
        System.out.println("First in line: " + qu.showFirstInLine());
        long usedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usedMemBefore;
        System.out.println("Memoria usada por el programa: " + usedMem/1048576.0 + "Mb");
    }
}
