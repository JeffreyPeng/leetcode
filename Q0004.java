/**
 * 4. Median of Two Sorted Arrays There are two sorted arrays nums1 and nums2 of
 * size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0 Example 2:
 * 
 * nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 */
public class Q0004 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
    }

    // TODO need improve
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int[] num = new int[nums1.length + nums2.length];
        int k = 0;

        while (k < num.length) {
            if (j >= nums2.length) {
                num[k++] = nums1[i++];
                continue;
            }
            if (i >= nums1.length) {
                num[k++] = nums2[j++];
                continue;
            }
            if (nums1[i] < nums2[j]) {
                num[k++] = nums1[i++];
            } else {
                num[k++] = nums2[j++];
            }
        }
        if (num.length % 2 == 1) {
            return num[num.length / 2];
        } else {
            return (num[num.length / 2] + num[num.length / 2 - 1]) / 2.0;
        }
    }
}
