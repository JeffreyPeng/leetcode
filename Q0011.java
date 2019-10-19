/**
 * 11. Container With Most Water Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai). n vertical lines are
 * drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find
 * two lines, which together with x-axis forms a container, such that the
 * container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * IMG here
 * 
 * Example:
 * 
 * Input: [1,8,6,2,5,4,8,3,7] Output: 49
 */
public class Q0011 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }) == 49);
    }

    // TODO need improve
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int l = j - i;
                if (max < h * l) {
                    max = h * l;
                }
            }
        }
        return max;
    }
}