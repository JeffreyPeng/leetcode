/**
 * 215. Kth Largest Element in an Array
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 */
public class Q0215 {

    public static void main(String[] args) {
    }
}

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return recu(nums, n - k, 0, n - 1);
    }

    int recu(int[] a, int k, int i, int j) {
        int x = partition(a, i, j);
        if (x < k) {
            return recu(a, k, x + 1, j);
        }
        if (x > k) {
            return recu(a, k, 0, x - 1);
        }
        return a[x];
    }

    int partition(int[] a, int p, int q) {
        int i = p, j = p;
        for (; j < q; j++) {
            if (a[j] <= a[q]) {
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