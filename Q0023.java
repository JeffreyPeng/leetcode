/**
 * 23. Merge k Sorted Lists
 *
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 * 
 */
public class Q0023 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode res = mergeKLists(new ListNode[] { l1, l2, l3 });
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        merge(lists, lists.length);
        return lists[0];
    }

    static void merge(ListNode[] lists, int n) {
        if (n == 1) {
            return;
        }
        for (int i = 0; i < n / 2; i++) {
            lists[i] = merge(lists[i], lists[n - i - 1]);
        }
        if (n % 2 == 0) {
            merge(lists, n / 2);
        } else {
            merge(lists, n / 2 + 1);
        }
    }

    // TODO need improve
    static ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }
        if (node1 == null) {
            node.next = node2;
        } else {
            node.next = node1;
        }
        return head.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}