import java.util.Random;

/**
 * 215. Kth Largest Element in an Array
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 */
public class Q0215v1 {

    public static void main(String[] args) {
    }
}

class Solution215v1 {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int i = 0, j = nums.length - 1;
        while (true) {
            if (i == j)
                return nums[i];
            Random random = new Random();
            int pivot = i + random.nextInt(j - i);
            int x = partition(nums, i, j, pivot);
            if (x == k)
                return nums[x];
            if (x < k)
                i = x + 1;
            if (x > k)
                j = x - 1;
        }
    }

    int partition(int[] a, int p, int q, int pivot) {
        swap(a, pivot, q);
        int i = p, j = p;
        for (; j < q; j++) {
            if (a[j] < a[q]) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, q);
        return i;
    }

    void swap(int[] a, int i, int j) {
        if (i == j)
            return;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
