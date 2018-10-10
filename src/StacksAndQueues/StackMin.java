package StacksAndQueues;

// Create a stack that can return the minimum value of the stack in O(1) time

import java.util.Stack;

public class StackMin {
    public static class MinNode {
        int data;
        int min;

        public MinNode(int num) {
            data = num;
        }
    }

    public static class MinStack {
        Stack<MinNode> stack = new Stack<>();
        int minVal = -1;

        public void push(int num) {

            MinNode node = new MinNode(num);

            if (minVal == -1) {
                minVal = node.data;
            }
            else {
                node.min = minVal;

                if (node.data < minVal) {
                    minVal = node.data;
                }
            }

            stack.push(node);
        }

        public MinNode pop() {
            MinNode poppedNode = stack.pop();

            minVal = poppedNode.min;

            return poppedNode;
        }

        public int getMinVal() {
            return minVal;
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(7);
        stack.push(6);
        stack.push(2);
        stack.push(5);
        stack.push(9);

        System.out.println(stack.getMinVal());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMinVal());
        stack.pop();
        System.out.println(stack.getMinVal());

    }
}
