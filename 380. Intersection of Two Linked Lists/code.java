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



    
    
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);
        int diff = Math.abs(lenA - lenB);
        
        if (lenA > lenB) {
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
    
    private int length(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        return length;
    }
}



