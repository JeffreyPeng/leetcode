import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals
 * 
 * Given a collection of intervals, find the minimum number of intervals you
 * need to remove to make the rest of the intervals non-overlapping.
 * 
 */
public class Q0435 {

    public static void main(String[] args) {
        int[][] intervals = new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 } };
        System.out.println(new Solution435().eraseOverlapIntervals(intervals));
    }
}

class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] pre = intervals[0];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (pre[1] <= intervals[i][0]) {
                pre = intervals[i];
                continue;
            }
            if (pre[1] > intervals[i][0]) {
                count++;
                if (pre[1] > intervals[i][1]) {
                    pre = intervals[i];
                }
            }
        }
        return count;
    }
}