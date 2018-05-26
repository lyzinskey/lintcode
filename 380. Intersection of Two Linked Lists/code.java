//Write a program to find the node at which the intersection of two singly linked lists begins.

//Example
//The following two linked lists:
//
//A:          a1 → a2
//                   ↘
//                    c1 → c2 → c3
//                   ↗            
//B:     b1 → b2 → b3
//begin to intersect at node c1.

//Challenge
//Your code should preferably run in O(n) time and use only O(1) memory.


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
 
     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        
        ListNode connect = headA;
        while (connect.next != null){
            connect = connect.next;
        }
        connect.next = headB;

        ListNode slow = headA;
        ListNode fast = headA.next;

        while (fast != slow){
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        while (headA != slow.next){
            headA = headA.next;
            slow = slow.next;
        }
        return headA;
    }
    
    
