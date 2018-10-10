package StacksAndQueues;

// Create a queue using only two stacks

import java.util.Stack;

public class MyQueue<E> {
    Stack<E> stack1 = new Stack<>();
    Stack<E> stack2 = new Stack<>();

    boolean useStack1 = true;

    public void add(E node) {
        flipStack();

        stack2.push(node);

        flipStack();
    }

    public E remove() {
        return stack1.pop();
    }

    public E poll() {
        return stack1.peek();
    }

    private void flipStack() {
        while (!currentStack().empty()) {
            unusedStack().push(currentStack().pop());
        }

        useStack1 = !useStack1;
    }

    private Stack<E> currentStack() {
        if (useStack1)
            return stack1;

        return stack2;
    }

    private Stack<E> unusedStack() {
        if (useStack1) return stack2;

        return stack1;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }
}
