/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = slow.next;
        slow.next = null;

        ListNode nextNext = next.next;
        next.next = null;
        ListNode head2 = reverse(next, nextNext);
        ListNode head1 = head;
        // printList(head1);
        // System.out.print("!!!!!!!!!!!!!!!!");
        // printList(head2);

        while (true) {
            ListNode next1 = head1.next;

            if (head2 == null) {
                return;
            }

            ListNode next2 = head2.next;

            head1.next = head2;
            head2.next = next1;

            if (next1 == null) {
                return;
            }

            head1 = next1;
            head2 = next2;

        }
    }

    public ListNode reverse(ListNode head, ListNode next) {
        if (next == null) {
            return head;
        }

        ListNode nextNext = next.next;
        next.next = head;

        return reverse(next, nextNext);
    }

    public void printList(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " -> ");
        printList(head.next);
    }
}