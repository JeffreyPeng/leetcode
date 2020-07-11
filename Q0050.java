/**
 * 50. Pow(x, n)
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 */
public class Q0050 {

    public static void main(String[] args) {
        System.out.println(new Solution50().myPow(2, 10));
        System.out.println(new Solution50().myPow(4, 5));
        System.out.println(new Solution50().myPow(4, -5));
        System.out.println(Math.pow(4, -5));
    }
}

class Solution50 {
    public double myPow(double x, int n) {
        // for the case -MaxInt overflow
        long N = n;
        if (n > 0) {
            return recur(x, N);
        }
        if (n < 0) {
            return 1 / recur(x, -N);
        }
        return 1;
    }

    private double recur(double x, long n) {
        if (n == 1) {
            return x;
        }
        double t = recur(x, n / 2);
        return n % 2 == 1 ? t * t * x : t * t;
    }
}