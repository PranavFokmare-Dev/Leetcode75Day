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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode head = new ListNode();
        ListNode tempHead = head;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                head.next = p1;
     
                p1 = p1.next;
            }
            else{
                head.next = p2;

                p2 = p2.next;
            }
            head = head.next;
            head.next = null;
        }
        if(p1 !=null){
            head.next = p1;
        }
        if(p2!=null)
            head.next = p2;
        return tempHead.next;
    }
}
