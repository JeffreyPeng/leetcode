import java.util.Arrays;

/**
 * 56. Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]] Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * 
 * Input: [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4] and [4,5]
 * are considered overlapping. NOTE: input types have been changed on April 15,
 * 2019. Please reset to default code definition to get new method signature.
 * 
 */
public class Q0056 {

    public static void main(String[] args) {
        int[][] arr = new int[][] { new int[] { 1, 3 }, new int[] { 2, 6 }, new int[] { 8, 10 }, new int[] { 15, 18 } };
        Arrays.stream(arr).forEach(a -> System.out.print(Arrays.toString(a)));
        System.out.println();
        int[][] merge = new Solution56().merge(arr);
        Arrays.stream(merge).forEach(a -> System.out.print(Arrays.toString(a)));
        System.out.println();
    }
}

class Solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int len = intervals.length;
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] a = intervals[i];
            int[] b = intervals[i + 1];
            if (a[1] < b[0]) {
                // disjoin
                continue;
            } else {
                // overlapping
                b[0] = a[0];
                b[1] = Math.max(a[1], b[1]);
                intervals[i] = new int[0];
                len--;
            }
        }
        int i = 0;
        int[][] result = new int[len][];
        for (int[] a : intervals) {
            if (a.length != 0) {
                result[i] = a;
                i++;
            }
        }
        return result;
    }
}