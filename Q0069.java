/**
 * 69. Sqrt(x)
 * 
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a
 * non-negative integer.
 * 
 * Since the return type is an integer, the decimal digits are truncated and
 * only the integer part of the result is returned.
 */
public class Q0069 {

    public static void main(String[] args) {
        System.out.println(new Solution69().mySqrt(2147395599));
    }
}

class Solution69 {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int i = 0, j = x;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (m > x / m) {
                j = m - 1;
            } else if (m < x / m) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return j;
    }
}
