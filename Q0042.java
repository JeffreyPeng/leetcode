import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. Trapping Rain Water
 *
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * Example:
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
 * 
 */
public class Q0042 {

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(arr));
    }

    // TODO need improve
    public static int trap(int[] height) {
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        int result = 0;
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int curr = height[i];
            if (max == 0 && curr == 0) {
                continue;
            }
            if (curr >= max) {
                // calc
                while (!stack1.isEmpty()) {
                    result += max - stack1.pop();
                }
                stack1.push(curr);
                max = curr;
            } else {
                stack1.push(curr);
            }
        }
        max = 0;
        while (!stack1.isEmpty()) {
            int curr = stack1.pop();
            if (max == 0 && curr == 0) {
                continue;
            }
            if (curr >= max) {
                // calc
                while (!stack2.isEmpty()) {
                    result += max - stack2.pop();
                }
                stack2.push(curr);
                max = curr;
            } else {
                stack2.push(curr);
            }
        }
        return result;
    }
}
