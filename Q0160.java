/**
 * 160. Intersection of Two Linked Lists
 *
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 */
public class Q0160 {

    public static void main(String[] args) {
    }
}

class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}