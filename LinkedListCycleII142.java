/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean cycle = false;
        while(slow!=null && fast!=null){
            fast = fast.next;
            slow = slow.next;
            if(fast!=null && fast.next!=null)
                fast=fast.next;
            if(fast == slow && fast!=null){
                cycle =true;
                break;
            }
        }
        if(!cycle)return null;
        
        fast = fast.next;
        slow.next = null;
        ListNode right = fast;
        ListNode left = slow;
        
        ListNode l2 = right;
        ListNode l1 = head;
        int lenL1 = getLen(l1);
        int lenL2 = getLen(l2);
        if(lenL2>lenL1){
            int x = lenL2 - lenL1;
            while(x-->0){
                l2 = l2.next;
            }
        }
        else{
            int x = lenL1-lenL2;
            while(x-->0){
                l1 = l1.next;
            }
        }
        
        while(l1!=l2){
            l1 = l1.next;
            l2 = l2.next;
            
        }
        left.next = right;
        return l1;
    }
    private int getLen(ListNode l){
        int x =0;
        ListNode temp =  l;
        while(temp!=null){
            x++;
            temp = temp.next;
        }
        return x;
    }
}
