import java.util.Arrays;
import java.util.Stack;

public class StackQueue {

    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public StackQueue() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void enqueue(int value) {
        enqueueStack.push(value);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        moveEnqueueStackToDequeueStack();

        return  dequeueStack.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        moveEnqueueStackToDequeueStack();

        return  dequeueStack.peek();
    }

    private void moveEnqueueStackToDequeueStack() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty())
                dequeueStack.push(enqueueStack.pop());
        }
    }

    public void print() {
        System.out.println(Arrays.toString(enqueueStack.toArray()));
        System.out.println(Arrays.toString(dequeueStack.toArray()));
    }

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    @Override
    public String toString() {
        return Arrays.toString(enqueueStack.toArray());
    }
}
