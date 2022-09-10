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
        ListNode slow = head;
        ListNode fast = head;
        ListNode tempHead = new ListNode();
        tempHead.next = head;
        ListNode prev= tempHead;
        for(int i = 0; i<n;i++){
            fast = fast.next;
        }
      
        while(fast!=null){
            prev = prev.next;
            slow=slow.next;
            fast = fast.next;
            
        }
        prev.next = slow.next;
        slow.next = null;
        return tempHead.next;
    }
}
