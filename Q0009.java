/**
 * 9. Palindrome Number
 * 
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward.
 * 
 * Example 1:
 * 
 * Input: 121 Output: true Example 2:
 * 
 * Input: -121 Output: false Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * 
 * Input: 10 Output: false Explanation: Reads 01 from right to left. Therefore
 * it is not a palindrome. Follow up:
 * 
 * Coud you solve it without converting the integer to a string?
 */
public class Q0009 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    // TODO need improve
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int i = x;
        int j = 0;
        while (i != 0) {
            int tmp = i % 10;
            if (j * 10 > Integer.MAX_VALUE - tmp) {
                return false;
            }
            j = j * 10 + tmp;
            i /= 10;
        }
        return x == j;
    }
}
