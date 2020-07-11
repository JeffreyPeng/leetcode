import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * 
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue. pop() -- Removes the element
 * from in front of queue. peek() -- Get the front element. empty() -- Return
 * whether the queue is empty.
 */
public class Q0232 {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
    }

    private static class MyQueue {
        int front;
        Stack<Integer> inStack;
        Stack<Integer> outStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (inStack.isEmpty()) {
                front = x;
            }
            inStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (!outStack.isEmpty()) {
                return outStack.peek();
            }
            return front;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such: MyQueue obj =
     * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
     * obj.peek(); boolean param_4 = obj.empty();
     */
}