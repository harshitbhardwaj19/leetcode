/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode arr[] = new ListNode[k];
        ListNode node = head;
        while(node!=null){
            size++;
            node=node.next;
        }
        int chunkSize = size/k;

        int count = 0;
        node = head;
        for(int i = 0; i<size%k; i++){
            arr[count++] = node;
            for(int j = 0; j<chunkSize; j++){
                node=node.next;
            }
            ListNode next = node.next;
            node.next = null;
            node = next;
        }
        if(chunkSize == 0){
            return arr;
        }
        int rem = size - (chunkSize+1)*count;
        for(int i = 0; i<rem/chunkSize; i++){
            arr[count++] = node;
            for(int j = 0; j<chunkSize-1; j++){
                node=node.next;
            }
            ListNode next = node.next;
            node.next = null;
            node = next;
        }

        return arr;
    }
}