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
        
        int diff = 0;
        ListNode res = head;
        ListNode curr = head;
        ListNode prev = head;

        while(curr != null) {
            if(diff < n) {
                diff++;
                curr = curr.next;
            } else {
                prev = res;
                res = res.next;
                curr = curr.next;
            }
        }
        if(res == head) {
            return head.next;
        }
        prev.next = res.next;
        return head;       
    }
}
