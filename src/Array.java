import java.util.Arrays;
import java.util.HashSet;

public class Array {

    private int [] items;
    private int count;

    public Array(int length) {
        this.items = new int[length];
    }

    public void insert(int item) {
        if(items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++)
                newItems[i] = items[i];
            items = newItems;
        }
        items[count++] = item;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i+1];
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++)
            if (items[i] == item) return i;
        return -1;
    }

    public int max() {
        int max = items[0];
        for (int i = 0; i < count; i++)
                if (items[i] > max) {
                    max = items[i];
                }
        return  max;
    }

    public void reverse() {
        int[] reversItems = new int[count];
//        for (int i = count-1; i >= 0; i--) {
//            int j = count-(i+1);
//            reversItems[j] = items[i];
//        }
        int j = count;
        for (int i = 0; i < count; i++) {
            reversItems[j-1] = items[i];
            j--;
        }

        items = reversItems;
    }

    public void insertAt(int item, int index) {

        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        int[] newItems = new int[count+1];
        newItems[index] = item;
        count++;

        // [0, 0, 3, 0, 0]

        int j = 0;
        for (int i = 0; i < items.length; i++) {
            j = i;
            if(i >= index) j++;
            newItems[j] = items[i];
        }
        items = newItems;
    }

    public int[] intersect(int[] arr) { //0(n)
        int[] intersectionArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            if (indexOf(arr[i]) != -1)
                intersectionArr[i] = arr[i];
        return intersectionArr;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }
}
