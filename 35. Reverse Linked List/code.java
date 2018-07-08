//Reverse a linked list.

//Example
//For linked list 1->2->3, the reversed linked list is 3->2->1

//Challenge
//Reverse it in-place and in one-pass



// Recursive solution
//
/**
 * Definition for ListNode
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
    /**
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode newHead = reverse(head.next);
        
        head.next.next = head;
        head.next = null;
        return newHead;    
    }
}



// Iterative solution
//
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
    
        while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
        }
  
        return prev;        
    }
    
    
