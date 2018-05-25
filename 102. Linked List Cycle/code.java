//Given a linked list, determine if it has a cycle in it.

//Example
//Given -21->10->4->5, tail connects to node index 1, return true


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


    //using two pointers to solve this problem without any extra space
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
            slow = slow.next;
        }
        return false;
    }
    
    
