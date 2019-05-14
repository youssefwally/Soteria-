import java.util.PriorityQueue;

public class Queues {
    private static PriorityQueue<Process> readyQueue = new PriorityQueue<Process>();
    private static PriorityQueue<Process> blockedQueue = new PriorityQueue<Process>();

    public static void addToReadyQueue(Process p) {
        readyQueue.add(p);
    }

    public static void addToBlockedQueue(Process p) {
        blockedQueue.add(p);
    }

    public static PriorityQueue<Process> getReadyQueue() {
        return readyQueue;
    }

    public static PriorityQueue<Process> getBlockedQueue() {
        return blockedQueue;
    }
    
}