import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private  Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node first;
    public Node last;
    private int count = 0;

    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        count++;
    }

    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
           last.next = node;
           last = node;
//           last.next = first.next.next;
        }
        count++;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contain(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var node = first.next;
            first.next = null;
            first = node;
        }
        count--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var previousNode = getPrevious(last);
            last = previousNode;
            last.next = null;
            last.next = null;
        }
        count--;
    }

    public int size() {
        return count;
    }

    public void print() {
        var currentNode = first;
        while (currentNode != null) {
            if ( currentNode.next != null)
                System.out.println("node: " + currentNode.value + " next => " + currentNode.next.value);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[count];
        var current = first;

        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current  = current.next;
        }
        return array;
    }

    // To be removed
    public int[] convertLinkedListToArray() {
        // [10 -> 20 -> 30]
        // [10, 20, 30]

        if(first == null) throw new IllegalStateException();

        int[] newArr = new int[count];
        var current = first;

        var index = 0;

        while(current != null) {
            newArr[index] = current.value;
            current = current.next;
            index++;
        }

        return newArr;
    }

    public void oldReverse() {
        if (isEmpty()) return;

        var current = last;
        while (current != null) {
            var previous = getPrevious(current);
            if (previous != null) {
                current.next = previous;
                current = previous;
                current.next = null;
            } else {
                current.next = null;
                first = last;
                last = current;
                current = null;
            }
        }
    }

    public void reverse() {
        // [ 10 -> 20 -> 30]
        //   p     c      n
        var previous = first;
        var current = first.next;
        while (current !=  null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public void implementReverse() {
        // [ 10 -> 20 -> 30 -> 40]
        // [ 40 -> 30 -> 20 -> 10]

        // loop on linked list o(n)
        // store items in array
        // convert array to linked list

        // for on array
        // var node = node
        // ============================
        // map K, v
        // k =>
        // v =>

        // previous = first;
        // current = first.next;
        // next = current.next
        // current.next = previous;
        // previous = current;
        // current = next;


    }

    public int getKthFromTheEnd(int k) {
        // [10 -> 20 -> 30 -> 40 ]
        //        *           *
        if (isEmpty()) throw new IllegalArgumentException();
        var a = first;
        var b = first;

        for (int i = 0; i < k - 1 ; i++) {
            b = b.next;

            if (b == null)
                throw new IllegalArgumentException();
        }

        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return  a.value;
    }

    // To be removed
    public int implementGetKthFromTheEnd(int k) {
        // k = 3
        // [ 10 -> 20 -> 30 -> 40 -> 50 -> 60 ]
        //   a           b

        var a = first;
        var b = first;

        for (int i = 0; i < k-1; i++)
            b = b.next;

        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    public void printMiddle() {
        // [10 -> 20 -> 30 -> 40 -> 50 -> 30]
        //  **

        if (isEmpty()) throw new IllegalArgumentException();

        var a = first;
        var b = first;

        while(b != last && b.next != last) {
            a = a.next;
            b = b.next.next;
        }

        if (b == last)
            System.out.println("Middle Node is "+ a.value);
        else
            System.out.println("Middle Node is "+ a.value + ", " + a.next.value);
    }

    public void hasLoop() {
        // [10 -> 20 -> 30 -> 40 -> 50 ]
        //                          sf

        if (isEmpty()) throw new IllegalArgumentException();

        var slow = first;
        var fast = first;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
                // in normal case we should return true otherwise return false
            }
        }

        if (slow == fast)
            System.out.println("Middle Node has a loop");
        else
            System.out.println("Middle Node don't has a loop" );
    }

    private Node getPrevious(Node node) {
        var current =  first;
        while(current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
