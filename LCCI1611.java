/**
 * 16.11. Diving Board LCCI
 * 
 * You are building a diving board by placing a bunch of planks of wood
 * end-to-end. There are two types of planks, one of length shorter and one of
 * length longer. You must use exactly K planks of wood. Write a method to
 * generate all possible lengths for the diving board.
 * 
 * return all lengths in non-decreasing order.
 * 
 */
public class LCCI1611 {

    public static void main(String[] args) {
    }
}

class SolutionLCCI1611 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0)
            return new int[0];
        if (shorter == longer)
            return new int[] { shorter * k };
        int[] result = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            result[i] = shorter * (k - i) + longer * i;
        }
        return result;
    }
}
