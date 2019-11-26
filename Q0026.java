/**
 * 26. Remove Duplicates from Sorted Array
 *
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * Example 1:
 * 
 * Given nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 * 
 * It doesn't matter what you leave beyond the returned length.
 * 
 */
public class Q0026 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] { 1, 1, 2 }));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1; 
        }
        int dup = 0, len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                dup++;
            }
            nums[i - dup] = nums[i];
        }
        return len - dup;
    }
}
