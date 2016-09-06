package algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingTwoQueues {
    
    private Deque<Integer> enQueue = new LinkedList<Integer>();
    private Deque<Integer> deQueue = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        enQueue.addLast(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        for (int i = 0; i < enQueue.size() - 1; i++) {
            deQueue.addLast(enQueue.getFirst());
            enQueue.removeFirst();
        }
        enQueue = deQueue;
        deQueue = new  LinkedList<Integer>();
    }

    // Get the top element.
    public int top() {
        for (int i = 0; i < enQueue.size() - 1; i++) {
            deQueue.addLast(enQueue.getFirst());
            enQueue.removeFirst();
        }
        int r = enQueue.getFirst();
        deQueue.addLast(enQueue.getFirst());
        enQueue.removeFirst();
        enQueue = deQueue;
        deQueue = new  LinkedList<Integer>();
        return r;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return enQueue.isEmpty();
    }
}
