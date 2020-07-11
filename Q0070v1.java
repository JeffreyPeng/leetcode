/**
 * 70. Climbing Stairs
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * Example 1:
 * 
 * Input: 2 Output: 2 Explanation: There are two ways to climb to the top. 1. 1
 * step + 1 step 2. 2 steps Example 2:
 * 
 * Input: 3 Output: 3 Explanation: There are three ways to climb to the top. 1.
 * 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1 step
 * 
 */
public class Q0070v1 {

    public static void main(String[] args) {
        System.out.println(new Solution70v1().climbStairs(2));
        System.out.println(new Solution70v1().climbStairs(3));
    }
}

class Solution70v1 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int preOne = 1, preTwo = 1;
        for (int i = 2; i <= n; i++) {
            int current = preOne + preTwo;
            preTwo = preOne;
            preOne = current;
        }
        return preOne;
    }
}