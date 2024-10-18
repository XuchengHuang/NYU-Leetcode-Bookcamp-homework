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
        ListNode reverseList = reverse(head);

        int move = n - 2;
        ListNode pointer = reverseList;
        
        while (pointer != null && move > 0){
            move --;
            pointer = pointer.next;
        }
        
        if (n != 1){
            ListNode replace = pointer.next.next;
            pointer.next = replace;
        } else {
            if (pointer.next != null) {
                reverseList = pointer.next;
            } else {
                return null;
            }
        }
        
        ListNode result = reverse(reverseList);
        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }  
}