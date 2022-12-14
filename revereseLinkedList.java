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
public ListNode reverseLinkedList(ListNode list) {
        if (list == null || list.next == null) return list;

        ListNode rest = reverseLinkedList(list.next);
        list.next.next = list;
        list.next = null;
        return rest;
    }
}
