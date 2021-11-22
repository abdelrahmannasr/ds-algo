import java.util.Arrays;

public class TwoStacks {

    private int[] stack;
    private int count1;
    private int count2;
    private int size;

    public TwoStacks(int size) {
        stack = new int[size];
        this.size = size;
        count2 = size;
    }

    public void push1(int value) {
        // [10, 20, 0, 20, 10]
        if(isFull1()) throw new StackOverflowError();
        stack[count1++] = value;
    }

    public void push2(int value) {
        if(isFull2()) throw new StackOverflowError();
        stack[--count2] = value;
    }

    public int pop1() {
        if(isEmpty1()) throw new IllegalStateException();
        return stack[--count1];
    }

    public int pop2() {
        if(isEmpty2()) throw new IllegalStateException();
        return stack[++count2];
    }

    public boolean isEmpty1() {
        return count1 == 0;
    }

    public boolean isEmpty2() {
        return count2 == size;
    }

    public boolean isFull1() {
        return (count2 - count1) == 0;
    }

    public boolean isFull2() {
        return (count2 - count1) == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }
}
