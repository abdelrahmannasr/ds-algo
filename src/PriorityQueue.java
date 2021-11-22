import java.util.Arrays;

public class PriorityQueue {
    private int[] priorityQueue;
    private int count;

    public PriorityQueue(int length) {
        priorityQueue = new int[length];
    }

    public void enqueue(int value) {
        if (count == priorityQueue.length) throw new IllegalStateException();
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (priorityQueue[i] > value)
                priorityQueue[i + 1] = priorityQueue[i];
            else
                break;
        }
        priorityQueue[i + 1] = value;
        count++;
    }

    public int dequeue() {
        if(isEmpty()) throw new IllegalStateException();

        return priorityQueue[--count];
    }

    public int remove() {
        if (isEmpty()) throw new IllegalStateException();

        return priorityQueue[--count];
    }

    public boolean isEmpty() {
        return count ==0;
    }

    @Override
    public String toString() {
        return Arrays.toString(priorityQueue);
    }
}
