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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int gap = 0;
        ListNode target = head;
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            if(gap < n) {
                gap++;
            } else {
                prev = target;
                target = target.next;
            }
            curr = curr.next;
        }
        if(target == head) {
            return head.next;
        }
        prev.next = target.next;
        return head;       
    }
}
