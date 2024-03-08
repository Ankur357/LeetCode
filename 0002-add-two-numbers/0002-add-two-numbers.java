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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        while(first!=null || second!=null){
            int sum = carry;
            if(first!=null){
                sum+=first.val;
                first = first.next;
            }
            if(second!=null){
                sum+=second.val;
                second = second.next;
            } 
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            tmp.next = newNode;
            tmp = tmp.next;
         }
         if(carry==1){
             ListNode node = new ListNode(carry);
             tmp.next = node;
             return dummy.next;
         }
         return dummy.next;
    }
}