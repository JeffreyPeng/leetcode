/**
 2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 */
public class Q0002 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2).next(new ListNode(4).next(new ListNode(3)));
        ListNode l2 = new ListNode(5).next(new ListNode(6).next(new ListNode(4)));
        addTwoNumbers(l1, l2).print();
    }

    // TODO need improve
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);

        ListNode pre = null;
        ListNode node = head;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            int v2 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + node.val;

            if (sum > 9) {
                node.val = sum % 10;
                node.next = new ListNode(1);
            } else {
                node.val = sum;
                node.next = new ListNode(0);
            }
            pre = node;
            node = node.next;
        }
        // delete last 0
        if (node.val == 0 && pre != null) {
            pre.next = null;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    // addition ---
    public ListNode next(ListNode next) {
        this.next = next;
        return this;
    }
    public void print() {
        System.out.print(val);
        ListNode nextNode = next;
        while (nextNode != null) {
            System.out.print(" -> " + nextNode.val);
            nextNode = nextNode.next;
        }
    }
}