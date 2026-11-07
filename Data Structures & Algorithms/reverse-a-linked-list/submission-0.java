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

    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        return reverse(head , null);
    }

    private ListNode reverse(ListNode head, ListNode prev) {
        ListNode temp = head.next;
        head.next = prev;
        if(temp != null) {
           return reverse(temp , head);
        }
        return head;
    }
}
