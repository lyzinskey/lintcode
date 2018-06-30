//Given a continuous stream of numbers, 
//write a function that returns the first unique number whenever terminating number is reached(include terminating number). 
//If there no unique number before terminating number or you can't find this terminating number, return -1.

//Example
//Given a stream [1, 2, 2, 1, 3, 4, 4, 5, 6] and a number 5
//return 3

//Given a stream [1, 2, 2, 1, 3, 4, 4, 5, 6] and a number 7
//return -1



public class Solution {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        Map<Integer, ListNode> hashmap = new HashMap<>();
        Set<Integer> duplicate = new HashSet<>();
        ListNode head = new ListNode(0);
        ListNode tail = head;
        
        for (int i = 0; i < nums.length; i++) {
            if (duplicate.contains(nums[i])) {
                continue;
            }
            
            if (hashmap.containsKey(nums[i])) {
                duplicate.add(nums[i]);
                ListNode prev = hashmap.get(nums[i]);
                prev.next = prev.next.next;
                hashmap.remove(nums[i]);
                if (prev.next != null) {
                    hashmap.put(prev.next.val, prev);
                }
                else {
                    tail = prev;
                }
                continue;
            }
            
            hashmap.put(nums[i], tail);
            ListNode node = new ListNode(nums[i]);
            tail.next = node;
            tail = node;
            
            if (nums[i] == number) {
                return head.next.val;
            }            
        }
        
        return -1;
    }
}


