/**
 * 19. Remove Nth Node From End of List
 *
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * 
 * Example:
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
 * 
 */
public class Q0019 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode res = removeNthFromEnd(head, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    
    // TODO need improve
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null) {
            if (n > 1) {
                n--;
            } else {
                pre = slow;
                slow = slow.next;
            }
            fast = fast.next;
        }
        if (pre == null) {
            // remove head
            head = head.next;
        } else {
            pre.next = pre.next.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
