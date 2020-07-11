/**
 * 167. Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 * 
 */
public class Q0167 {

    public static void main(String[] args) {
    }
}

class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] { i + 1, j + 1 };
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}