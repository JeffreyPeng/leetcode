import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * 
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. empty() -- Return whether the stack
 * is empty.
 */
public class Q0225 {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
    }

    private static class MyStack {
        Queue<Integer> workq;

        /** Initialize your data structure here. */
        public MyStack() {
            workq = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            int m = workq.size();
            workq.add(x);
            while (m > 0) {
                workq.add(workq.remove());
                m--;
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return workq.remove();
        }

        /** Get the top element. */
        public int top() {
            return workq.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return workq.isEmpty();
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such: MyStack obj =
     * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
}