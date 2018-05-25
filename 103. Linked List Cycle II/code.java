//Given a linked list, return the node where the cycle begins.

//If there is no cycle, return null.

//Example
//Given -21->10->4->5, tail connects to node index 1，return 10

//Challenge
//Can you solve it without using extra space?


/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
 
 
     public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow){    
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        while (head != slow.next){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
    
    
