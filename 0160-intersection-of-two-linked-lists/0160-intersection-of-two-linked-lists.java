/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode firstHead, ListNode secondHead) {
        if(firstHead==null || secondHead==null) return null;
        ListNode first = firstHead;
        ListNode second = secondHead;
        while(first!=second){
            first = first.next;
            second = second.next;
            if(first==second) return first;
            if(first==null) first = secondHead;
            if(second==null) second = firstHead;
        }
        return first;
    }
}