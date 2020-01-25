import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1296. Divide Array in Sets of K Consecutive Numbers
 *
 * Given an array of integers nums and a positive integer k, find whether it's
 * possible to divide this array into sets of k consecutive numbers
 * Return True if its possible otherwise return False.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,3,4,4,5,6], k = 4 Output: true Explanation: Array can be
 * divided into [1,2,3,4] and [3,4,5,6]. Example 2:
 * 
 * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3 Output: true Explanation:
 * Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11]. Example
 * 3:
 * 
 * Input: nums = [3,3,2,2,1,1], k = 3 Output: true Example 4:
 * 
 * Input: nums = [1,2,3,4], k = 3 Output: false Explanation: Each array should
 * be divided in subarrays of size 3.  
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10^5 1 <= nums[i] <= 10^9 1 <= k <= nums.length
 */
public class Q1296 {

    public static void main(String[] args) {
        System.out.println(new Solution1296().isPossibleDivide(new int[] { 1, 2, 3, 3, 4, 4, 5, 6 }, 4));
        System.out.println(new Solution1296().isPossibleDivide(new int[] { 3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11 }, 3));
        System.out.println(new Solution1296().isPossibleDivide(new int[] { 3, 3, 2, 2, 1, 1 }, 3));
        System.out.println(new Solution1296().isPossibleDivide(new int[] { 1, 2, 3, 4 }, 3));
    }
}

// TODO timeout
class Solution1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length == k || k == 1) {
            return true;
        }
        if (nums.length % k != 0) {
            return false;
        }
        List<Integer> arrList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(arrList);
        LinkedList<Integer> list = new LinkedList<>(arrList);
        while (list.size() != 0) {
            int last = list.get(0);
            list.remove(0);
            for (int i = 0; i < k - 1; i++) {
                int pos = 0;
                while (pos < list.size() && list.get(pos) != last + 1) {
                    pos++;
                }
                if (pos == list.size()) {
                    return false;
                } else {
                    last++;
                    list.remove(pos);
                }
            }
        }
        return true;
    }
}
