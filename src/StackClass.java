import java.util.Arrays;

public class StackClass {

    private int[] stack = new int[5];
    private int count;

    public void push(int value) {
        // We should check if stack full or not
        if (count == stack.length) {
            var newStack = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        stack[count++] = value;

    }

    public int pop() {
       if (count == 0) throw new IllegalStateException();
       return stack[--count];
    }

    public int peek() {
        if (count == 0) throw new IllegalStateException();
        return stack[count-1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(stack, 0, count);
        return Arrays.toString(content);
    }
}
