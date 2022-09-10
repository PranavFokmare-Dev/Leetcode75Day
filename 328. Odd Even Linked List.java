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
    public ListNode oddEvenList(ListNode head) {
        ListNode evenHead = new ListNode();
        ListNode oddHead = new ListNode();
        ListNode evenPtr = evenHead;
        ListNode oddPtr = oddHead;
        ListNode p = head;
        int len = 1;
        while(p!=null){
            if(len%2==0){
                evenPtr.next = p;
                p=p.next;
                evenPtr = evenPtr.next;
                evenPtr.next = null;
                
            }
            else{
                oddPtr.next = p;
                p=p.next;
                oddPtr = oddPtr.next;
                oddPtr.next = null;
            }
            len++;
        }
        oddPtr.next = evenHead.next;
        return oddHead.next;
        
    }
}
