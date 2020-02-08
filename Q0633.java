/**
 * 633. Sum of Square Numbers
 * 
 * Given a non-negative integer c, your task is to decide whether there're two
 * integers a and b such that a2 + b2 = c.
 * 
 * Example 1:
 * 
 * Input: 5 Output: True Explanation: 1 * 1 + 2 * 2 = 5  
 * 
 * Example 2:
 * 
 * Input: 3 Output: False
 */
public class Q0633 {

    public static void main(String[] args) {
        System.out.println(new Solution0633().judgeSquareSum(5));
    }
}

class Solution0633 {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
