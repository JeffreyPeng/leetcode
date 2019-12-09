import java.util.HashSet;
import java.util.Set;

/**
 * 136. Single Number
 *
 * 
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,1] Output: 1 Example 2:
 * 
 * Input: [4,1,2,1,2] Output: 4
 */
public class Q0136 {

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 1, 2, 1, 2 };
        System.out.println(new Solution136().singleNumber(arr));
    }
}

class Solution136 {
    // TODO need improve
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
                continue;
            }
            set.add(i);
        }
        return set.iterator().next();
    }
}