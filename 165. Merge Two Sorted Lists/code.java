//Merge two sorted (ascending) linked lists and return it as a new sorted list. 
//The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.

//Example
//Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.



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
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            
            tail = tail.next;
        }
        
        tail.next = (l1 != null) ? l1 : l2;
        
        return dummy.next;
    }
}


