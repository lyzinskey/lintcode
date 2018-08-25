//Given a linked list, swap every two adjacent nodes and return its head.

//Example
//Given 1->2->3->4, you should return the list as 2->1->4->3.

//Challenge
//Your algorithm should use only constant space. 
//You may not modify the values in the list, only nodes itself can be changed.



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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode next = curr.next;
        curr.next = swapPairs(curr.next.next);
        next.next = curr;
        return next;
    }
}



