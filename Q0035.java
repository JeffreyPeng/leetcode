import java.util.Arrays;

/**
 * 35. Search Insert Position
 *
 * Output: 1 Example 3:
 * 
 * Input: [1,3,5,6], 7 Output: 4 Example 4:
 * 
 * Input: [1,3,5,6], 0 Output: 0
 */
public class Q0035 {

    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 3, 5, 6 };
        System.out.println(new Solution35().searchInsert(arr1, 5));
    }
}

class Solution35 {
    // TODO need improve
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[n - 1]) {
            return n;
        }
        int mid = -1, low = 0, high = n - 1;
        while (low <= high) {
            // mid = low + (high - low) / 2;
            mid = (low + high) >> 1;
            if (nums[mid] < target) {
                if (nums[mid + 1] >= target) {
                    return mid + 1;
                }
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return mid;
    }
}