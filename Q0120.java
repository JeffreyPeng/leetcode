import java.util.List;

/**
 * 120. Triangle
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 */
public class Q0120 {

}

class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int lastRow = triangle.size() - 1;
        Integer[] row = triangle.get(lastRow).toArray(new Integer[0]);
        for (int i = lastRow - 1; i >= 0; i--) {
            List<Integer> current = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                row[j] = current.get(j) + Math.min(row[j], row[j + 1]);
            }
        }
        return row[0];
    }
}