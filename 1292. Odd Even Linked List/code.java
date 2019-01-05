//Given a singly linked list, group all odd nodes together followed by the even nodes. 
//Please note here we are talking about the node number and not the value in the nodes.

//Example:
//Given 1->2->3->4->5->NULL,
//return 1->3->5->2->4->NULL.

//Notice
//The relative order inside both the even and odd groups should remain as it was in the input.
//The first node is considered odd, the second node even and so on ...




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

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {                
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = even;
        
        while (odd.next != null && odd.next.next != null) {
            odd.next = even.next;
            even.next = odd.next.next;
            odd = odd.next;
            even = even.next;
        }
        
        odd.next = firstEven;
        return head;
    }
}



