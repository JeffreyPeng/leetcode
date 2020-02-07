/**
 * 141. Linked List Cycle
 *
 * Given a linked list, determine if it has a cycle in it.
 * 
 * To represent a cycle in the given linked list, we use an integer pos which
 * represents the position (0-indexed) in the linked list where tail connects
 * to. If pos is -1, then there is no cycle in the linked list.
 * 
 * Example 1:
 * 
 * Input: head = [3,2,0,-4], pos = 1 Output: true Explanation: There is a cycle
 * in the linked list, where tail connects to the second node. Example 2:
 * 
 * Example 2:
 * 
 * Input: head = [1,2], pos = 0 Output: true Explanation: There is a cycle in
 * the linked list, where tail connects to the first node.
 * 
 * Example 3:
 * 
 * Input: head = [1], pos = -1 Output: false Explanation: There is no cycle in
 * the linked list.
 * 
 */
public class Q0141 {

    public static void main(String[] args) {
        Solution141.ListNode head = new Solution141.ListNode(1);
        head.next = new Solution141.ListNode(2);
        head.next = head;
        System.out.println(new Solution141().hasCycle(head));
    }
}

class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}