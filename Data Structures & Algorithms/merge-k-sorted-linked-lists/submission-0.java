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
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        
        return mergeLists(lists, 0 , lists.length - 1);       

    }

    private ListNode mergeLists(ListNode[] lists, int left , int right) {
        if(left > right) {
            return null;
        }
        if(left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        ListNode leftNode = mergeLists(lists , left , mid);
        ListNode rightNode = mergeLists(lists , mid + 1, right);

        return mergeTwoLists(leftNode , rightNode);
            
    }

    private ListNode mergeTwoLists(ListNode head1 , ListNode head2) {
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                tail.next = head1;
                head1 =  head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;    
        }
        if(head1 == null) {
            tail.next = head2;
        } else {
            tail.next = head1;
        }
        return dummy.next;                     
    }
}
