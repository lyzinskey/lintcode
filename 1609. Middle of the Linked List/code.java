//Given a non-empty, singly linked list with head node head, return a middle node of linked list.

//If there are two middle nodes, return the second middle node.

//Example
//Example 1:
//
//Input: 1->2->3->4->5->null
//Output: 3->4->5->null

//Example 2:
//
//Input: 1->2->3->4->5->6->null
//Output: 4->5->6->null

//Notice
//The number of nodes in the given list will be between 1 and 100.




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
     * @param head: the head node
     * @return: the middle node
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }    
}



