import java.util.Arrays;

/**
 * 57. Insert Interval
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5] Output: [[1,5],[6,9]]
 * Example 2:
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]] Explanation: Because the new interval [4,8]
 * overlaps with [3,5],[6,7],[8,10]. NOTE: input types have been changed on
 * April 15, 2019. Please reset to default code definition to get new method
 * signature.
 * 
 */
public class Q0057 {

    public static void main(String[] args) {
        int[][] arr = new int[][] { new int[] { 1, 3 }, new int[] { 6, 6 } };
        int[] newInterval = new int[] { 2, 5 };
        Arrays.stream(arr).forEach(a -> System.out.print(Arrays.toString(a)));
        System.out.println();
        System.out.print(Arrays.toString(newInterval));
        System.out.println();
        int[][] merge = new Solution57().insert(arr, newInterval);
        Arrays.stream(merge).forEach(a -> System.out.print(Arrays.toString(a)));
        System.out.println();
    }
}

class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] all = new int[intervals.length + 1][];
        for (int i = 0; i < intervals.length; i++) {
            all[i] = intervals[i];
        }
        all[all.length - 1] = newInterval;
        return merge(all);
    }

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