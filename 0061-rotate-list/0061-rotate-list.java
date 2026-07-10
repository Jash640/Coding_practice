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
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        
        if (head == null || head.next == null) return head;
        
        
        ListNode count = head;
        while (count.next != null) {
            len++;
            count = count.next;
        }
        len++; 
        
        k = k % len;
        

        ListNode p = head;
        for (int i = 0; i < (len - k - 1); ++i) {
            p = p.next;
        }
        
        count.next = head;
        head = p.next;
        p.next = null;
        
        return head;
    }
}