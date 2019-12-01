/**
 * 25. Reverse Nodes in k-Group
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
 * 
 */
public class Q0025 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = reverseKGroup(head, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = reverseK(head, k);
        ListNode result = newHead;
        while (newHead != head) {
            ListNode pre = head;
            head = head.next;
            newHead = reverseK(head, k);
            pre.next = newHead;
        }
        return result;
    }
    static ListNode reverseK(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        int i = k;
        while (head.next != null) {
            if (i-- <= 1) {
                break;
            }
            // make next be newHead
            ListNode next = head.next;
            head.next = next.next;
            next.next = newHead;
            newHead = next;
        }
        if (i > 1) {
            // last part less than k, reverse back
            newHead = reverseK(newHead, k - i + 1);
        }
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
