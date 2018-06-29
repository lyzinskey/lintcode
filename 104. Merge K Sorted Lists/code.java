//Merge k sorted linked lists and return it as one sorted list.

//Analyze and describe its complexity.

//Example
//Given lists:
//
//  [
//    2->4->null,
//    null,
//    -1->null
//  ],
//return -1->2->4->null.



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
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
     
     
    //using heap
    //Time complexity: O(nlogk)
    //
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new ListNodeComparator());

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = tail.next;
            if (head.next != null) {
                heap.add(head.next);
            }
        }

        return dummy.next;
    }
    
    private class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode A, ListNode B) {
            return A.val - B.val;
        }
    }
}




    //merge list two by two
    //Time Complexity: O(nlogk)
    //
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        while (lists.size() > 1) {
            List<ListNode> nodeList = new ArrayList<>();
            
            for (int i = 0; i < lists.size() - 1; i+=2) {
                ListNode merged = mergeTwoList(lists.get(i), lists.get(i + 1));
                nodeList.add(merged);
            }
            
            if (lists.size() % 2 == 1) {
                nodeList.add(lists.get(lists.size() - 1));
            }
            
            lists = nodeList;
        }
        
        return lists.get(0);
    }
    
    private ListNode mergeTwoList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            }
            else {
                tail.next = b;
                b = b.next;
            }
            
            tail = tail.next;
        }
        
        tail.next = (a != null) ? a : b;
        
        return dummy.next;
    }
    
    
    
    
    
    //Divide & Conquer
    //Time Complexity: O(nlogk)
    //
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        return mergeHelper(lists, 0, lists.size() - 1);
    }
    
    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwo(left, right);
    }
    
    
    
    private ListNode mergeTwo(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            }
            else {
                tail.next = b;
                b = b.next;
            }
            
            tail = tail.next;
        }
        
        tail.next = (a != null) ? a : b;
        
        return dummy.next;
    }    
    
    
    
