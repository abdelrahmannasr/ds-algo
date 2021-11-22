import java.util.*;

public class main {
    public static void main(String[] args){
//        Arrays
//        Array numbers = new Array(3);
//        numbers.insert(10);
//        numbers.insert(20);
//        numbers.insert(30);
//        numbers.insert(40);
//        numbers.removeAt(2);
//        System.out.println(numbers.indexOf(30));
//        System.out.println(numbers.max());
//        numbers.reverse();
//        numbers.insertAt(35, 2);
//        int[] arr = {10, 20, 30};
//        System.out.println(Arrays.toString(numbers.intersect(arr)));
//        numbers.print();
//        *************************************************************
//        Linked List
//        LinkedList items = new LinkedList();
//        items.addFirst(40);
//        items.addFirst(30);
//        items.addFirst(20);
//        items.addFirst(10);
//        items.addLast(50);
//        items.removeFirst();
//        items.removeLast();
//        items.print();
//        System.out.println(Arrays.toString(items.toArray()));
//        System.out.println(items.indexOf(30));
//        System.out.println(items.contain(30));
//        System.out.println(items.size());
//        items.reverse();
//        items.print();
//        System.out.println(Arrays.toString(items.toArray()));
//        System.out.println(items.getKthFromTheEnd(3));
//        items.printMiddle();
//        items.hasLoop();
//        *************************************************************
//        Stack
//        StackExamples stackExamples = new StackExamples();
//        var reversedString = stackExamples.stringReverser("abcdef");
//        System.out.println(reversedString);
//
//        var isBalanced = stackExamples.isStringBalanced("([1] + [2])");
//        System.out.println(isBalanced);

//        StackClass stack = new StackClass();
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        stack.push(40);
//        System.out.println("First Print" + stack);
//        System.out.println("pop= " + stack.pop());
//        System.out.println("Print after pop" + stack);
//        System.out.println("peek= " + stack.peek());
//        System.out.println("Print after peek" + stack);

//        TwoStacks twoStack = new TwoStacks(5);
//        System.out.println("Is stack 1 is empty " + twoStack.isEmpty1());
//        System.out.println("Is stack 2 is empty " + twoStack.isEmpty2());
//        twoStack.push1(10);
//        twoStack.push2(10);
//        System.out.println("Is stack 1 is empty " + twoStack.isEmpty1());
//        System.out.println("Is stack 2 is empty " + twoStack.isEmpty2());
//        twoStack.push1(20);
//        twoStack.push2(20);
//        twoStack.push1(30);
//        System.out.println(twoStack);
//        twoStack.push2(30);
//        System.out.println(twoStack);
//        System.out.println("Is stack 1 is full " + twoStack.isFull1());
//        System.out.println("Is stack 2 is full " + twoStack.isFull2());

//        Queue
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
//        reverseQueue(queue);
//        System.out.println(queue);
//        ArrayQueue queue = new ArrayQueue(5);
//        queue.enqueue(10);
//        queue.enqueue(20);
//        queue.enqueue(30);
//        queue.enqueue(40);
//        queue.enqueue(50);
//        queue.dequeue();
//        queue.enqueue(60);
//        queue.dequeue();
//        queue.enqueue(70);
//        queue.dequeue();
//        queue.enqueue(80);
//        System.out.println(queue);
//        StackQueue queue = new StackQueue();
//        queue.enqueue(10);
//        queue.enqueue(20);
//        queue.enqueue(30);
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        queue.enqueue(10);
//        System.out.println(queue.dequeue());
//        queue.enqueue(20);
//        queue.enqueue(30);
//        queue.print();
//        System.out.println(queue);
//        PriorityQueue priorityQueue = new PriorityQueue(6);
//        priorityQueue.enqueue(5);
//        priorityQueue.enqueue(3);
//        priorityQueue.enqueue(6);
//        priorityQueue.enqueue(1);
//        priorityQueue.enqueue(4);
//        System.out.println(priorityQueue);
//        while (!priorityQueue.isEmpty())
//            System.out.println(priorityQueue.dequeue());
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
//        queue.add(40);
//        queue.add(50);
//        queue.add(60);
//        queue.add(70);
//        queue.add(80);
//        queue.add(90);
//        queue.add(100);
//        reverseFirstKQueue(queue, 3);
//        Hash Table
//        System.out.println(getNonRepeatedChar("a green apple"));
//        System.out.println(getFirstRepeatedChar("a green apple"));
//        HashTable table = new HashTable();
//        table.put(6, "A");
//        table.put(8, "B");
//        table.put(11, "C");
//        table.put(6, "A+");
//        table.remove(6);
//        System.out.println(table.get(6));
    }

    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

    public static void reverseFirstKQueue(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k > queue.size() || k <= 0) return;

        System.out.println("Queue: " + queue);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++)
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

        for (int i = 0; i < queue.size() - k; i++)
            queue.add(queue.remove());

        System.out.println("First k reversed queue: " + queue);
    }

    public static String getNonRepeatedChar(String input) {
        Map<Character, Integer> map = new HashMap<>();

        var chars = input.toCharArray();
        for (char ch : chars) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (char ch: chars) {
            var count = map.get(ch);
            if (count != null && count > 1) map.remove(ch);
        }
        return map.toString();
    }

    public static char getFirstRepeatedChar(String input) {
        Set<Character> set = new HashSet<>();

        var chars = input.toCharArray();
        for (char ch : chars) {
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
