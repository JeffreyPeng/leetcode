/**
7. Reverse Integer
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class Q0007 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }

    // TODO need improve
    public static int reverse(int x) {
        int flag = 1;
        if (x == 0) {
            return x;
        }
        if (x < 0) {
            flag = -1;
            x = Math.abs(x);
        }
        long tmp = 0;
        for (int i = 0; i < 10; i++) {
            int pow = (int) Math.pow(10, i);
            if (x < pow) {
                break;
            }
            int digit = x / pow % 10;
            tmp = tmp * 10 + digit;
        }
        if (tmp > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) tmp * flag;
    }
}