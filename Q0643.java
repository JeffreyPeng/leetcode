/**
 * 
 * 643. Maximum Average Subarray I
 * 
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output the
 * maximum average value.
 * 
 * Example 1:
 * 
 * Input: [1,12,-5,-6,50,3], k = 4 Output: 12.75 Explanation: Maximum average is
 * (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 * Note:
 * 
 * 1 <= k <= n <= 30,000. Elements of the given array will be in the range
 * [-10,000, 10,000].
 * 
 */
public class Q0643 {

	public static void main(String[] args) {
		System.out.println(findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4));
	}

	public static double findMaxAverage(int[] nums, int k) {
		int len = nums.length;
		double sum = 0, maxSum = 0;

		int i = 0, j = 0;
		while (j < len) {
			if (j < k) {
				sum += nums[j];
				maxSum = sum;
				j++;
			} else {
				sum -= nums[i];
				sum += nums[j];
				if (sum > maxSum)
					maxSum = sum;
				i++;
				j++;
			}

		}
		return maxSum / k;
	}
}
