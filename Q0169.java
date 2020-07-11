import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 */
public class Q0169 {

    public static void main(String[] args) {
    }
}

class Solution169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Map.Entry<Integer, Integer> res = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (res == null) {
                res = entry;
                continue;
            }
            if (entry.getValue() > res.getValue()) {
                res = entry;
            }
        }
        return res.getKey();
    }
}