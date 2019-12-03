import java.util.ArrayList;
import java.util.List;

/**
 * 155. Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 * 
 * 
 * Example:
 * 
 * MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
 * minStack.push(-3); minStack.getMin(); --> Returns -3. minStack.pop();
 * minStack.top(); --> Returns 0. minStack.getMin(); --> Returns -2.
 * 
 * 
 */
public class Q0155 {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // 返回 -3.
        minStack.pop();
        System.out.println(minStack.top()); // 返回 0.
        System.out.println(minStack.getMin()); // 返回 -2.
    }
}

// TODO need improve
class MinStack {

    private List<Node> list = new ArrayList<>();
    private int top = -1;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        Node node = new Node(x, x);
        if (top != -1) {
            Node topNode = list.get(top);
            if (topNode.min < x) {
                node.min = topNode.min;
            }
        }
        list.add(node);
        top++;
    }

    public void pop() {
        list.remove(top);
        top--;
    }

    public int top() {
        if (top == -1) {
            return 0;
        }
        return list.get(top).value;
    }

    public int getMin() {
        return list.get(top).min;
    }
}

class Node {
    public Node(int value, int min) {
        this.value = value;
        this.min = min;
    }

    int value;
    int min;
}
/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */