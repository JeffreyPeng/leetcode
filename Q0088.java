import java.util.Arrays;

/**
 * 
 * 88. Merge Sorted Array
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note:
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively. You may assume that nums1 has enough space (size that is
 * greater or equal to m + n) to hold additional elements from nums2. Example:
 * 
 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * 
 * Output: [1,2,2,3,5,6]
 */
public class Q0088 {

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        new Solution0088().merge(nums1, 3, new int[] { 2, 5, 6 }, 3);
        System.out.println(Arrays.toString(nums1));
    }
}

class Solution0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }
}