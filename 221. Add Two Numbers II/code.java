//You have two numbers represented by linked list, where each node contains a single digit. 
//The digits are stored in forward order, such that the 1's digit is at the head of the list. 
//Write a function that adds the two numbers and returns the sum as a linked list.

//Example
//Example 1:
//
//Input: 6->1->7   2->9->5
//Output: 9->1->2

//Example 2:
//
//Input: 1->2->3   4->5->6
//Output: 5->7->9




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
     * @param l1: The first list.
     * @param l2: The second list.
     * @return: the sum list of l1 and l2.
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode node = new ListNode(1);
        int sum = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            node.val = sum % 10;
            ListNode head = new ListNode(1);
            head.next = node;
            node = head;
            sum /= 10;
        }
        
        if (sum > 0) {
            ListNode head = new ListNode(1);
            head.next = node;
            node = head;
        }
        return node.next;
    }
}



