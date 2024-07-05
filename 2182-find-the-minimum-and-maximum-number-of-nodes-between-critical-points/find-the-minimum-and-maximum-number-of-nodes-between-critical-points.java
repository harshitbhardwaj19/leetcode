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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int prevIndex = -1;
        int firstIndex = -1;
        ListNode prev = null;
        ListNode node = head;
        int i = 0;
        while(node != null){
            if(isCriticalPoint(node, prev)){
                if(prevIndex != -1){
                    min = Math.min(min, i-prevIndex);
                    max = Math.max(max, i-firstIndex);
                } else {
                    firstIndex = i;
                }
                prevIndex = i;
            }
            prev = node;
            node = node.next;
            i++;
        }

        if(min == Integer.MAX_VALUE){
            min = -1;
        }
        if(max == Integer.MIN_VALUE){
            max = -1;
        }
        return new int[]{min, max};
    }

    public boolean isCriticalPoint(ListNode node, ListNode prev){
        if(prev == null || node.next == null){
            return false;
        }

        if(node.val>prev.val && node.val>node.next.val){
            return true;
        }

        if(node.val<prev.val && node.val<node.next.val){
            return true;
        }

        return false;
    }
}