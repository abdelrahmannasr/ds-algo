import java.util.Arrays;

public class ArrayQueue {

    private int[] queue;
    private int count;
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
    }

    public void enqueue(int value) {
        // [10, 20, 30]
        // [30, 20, 10]
        if (count == queue.length) throw new IllegalStateException();
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        count++;
    }

    public int dequeue() {
        if (count == 0) throw new IllegalStateException();
        var item = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        count--;
        return item;
    }

    public int peek() {
        if (count == 0) throw new IllegalStateException();
        return front;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (queue[i] == item) return i;
        return -1;
    }

    @Override
    public String toString() {
//        var content = Arrays.copyOfRange(queue, front, count);
        return Arrays.toString(queue);
    }
}
