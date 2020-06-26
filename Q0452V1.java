import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * 
 * There are a number of spherical balloons spread in two-dimensional space. For
 * each balloon, provided input is the start and end coordinates of the
 * horizontal diameter. Since it's horizontal, y-coordinates don't matter and
 * hence the x-coordinates of start and end of the diameter suffice. Start is
 * always smaller than end. There will be at most 104 balloons.
 * 
 * An arrow can be shot up exactly vertically from different points along the
 * x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart
 * ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An
 * arrow once shot keeps travelling up infinitely. The problem is to find the
 * minimum number of arrows that must be shot to burst all balloons.
 * 
 */
public class Q0452V1 {

    public static void main(String[] args) {
    }
}

class Solution452V1 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, (a,b) -> a[1] - b[1]);
        // Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int[] last = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            if (last[1] < curr[0]) {
                last = curr;
                count++;
            }
        }
        return count;
    }
}
