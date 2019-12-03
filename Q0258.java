/**
 * 258. Add Digits
 *
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * Example:
 * 
 * Input: 38 Output: 2 Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 * Since 2 has only one digit, return it. Follow up: Could you do it without any
 * loop/recursion in O(1) runtime?
 * 
 */
public class Q0258 {

    public static void main(String[] args) {
        System.out.println(new Solution().addDigits(38));
    }
}

class Solution {
    // O(1): return = (num - 1) % 9 + 1;
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        return addDigits(num % 10 + addDigits(num / 10));
    }
}