import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 */
public class Q0215v2 {

    public static void main(String[] args) {
    }
}

class Solution215v2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
