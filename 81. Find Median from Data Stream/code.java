//Numbers keep coming, return the median of numbers at every time a new number added.

//Example
//For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].
//For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].
//For numbers coming list: [2, 20, 100], return [2, 2, 20].

//Challenge
//Total run time in O(nlogn).

//Clarification
//What's the definition of Median?
//Median is the number that in the middle of a sorted array. 
//If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. 
//For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.


public class Solution {
    /**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
     
    private PriorityQueue<Integer> smallHalf = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> largeHalf = new PriorityQueue<>();
    
    public int[] medianII(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        if (length == 0) {
            return result;
        }
        
        for (int i = 0; i < length; i++) {
            addNum(nums[i]);
            result[i] = findMedian();
        }
        return result;
    }
    
    private void addNum(int value) {
        if (smallHalf.isEmpty() || value <= smallHalf.peek()) {
            smallHalf.offer(value);
            if (smallHalf.size() > largeHalf.size() + 1) {
                largeHalf.offer(smallHalf.poll());
            }
        }
        else {
            largeHalf.offer(value);
            if (smallHalf.size() < largeHalf.size()) {
                smallHalf.offer(largeHalf.poll());
            }
        }            
    }
    
    private int findMedian() {
        return smallHalf.peek();        
    }    
}



