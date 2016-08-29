package algorithm.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class PhoneDirectory {
    private boolean[] status = null;
    private List<Integer> nodes = null;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        status = new boolean[maxNumbers];
        nodes = new LinkedList<Integer>();
        for (int i = 0; i < maxNumbers; i++) {
            status[i] = true;
            nodes.add(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (nodes.size() == 0) {
            return -1;
        }
        int curr = nodes.get(0);
        nodes.remove(0);
        status[curr] = false;
        return curr;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return status[number]; // There should be a boundary check.
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (status[number]) {
            // No need to release
            return;
        }
        status[number] = true;
        nodes.add(number);
    }
}
