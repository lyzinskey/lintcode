//Given an array nums and a target value k, find the maximum length of a subarray that sums to k. 
//If there isn't one, return 0 instead.

//Example
//Example1
//
//Input:  nums = [1, -1, 5, -2, 3], k = 3
//Output: 4
//Explanation:
//because the subarray [1, -1, 5, -2] sums to 3 and is the longest.

//Example2
//
//Input: nums = [-2, -1, 2, 1], k = 1
//Output: 2
//Explanation:
//because the subarray [-1, 2] sums to 1 and is the longest.

//Challenge
//Can you do it in O(n) time?

//Notice
//The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.




public class Solution {
    /**
     * @param nums: an array
     * @param k: a target value
     * @return: the maximum length of a subarray that sums to k
     */
    // sum[i~j] = sum[0~j] - sum[0~i]
    //
    // Time: O(n)
    // Space: O(n)
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> hashmap = new HashMap<>();
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                res = i + 1;
            } else if (hashmap.containsKey(sum - k)) {
                res = Math.max(res, i - hashmap.get(sum - k));
            }
            if (!hashmap.containsKey(sum)) {
                hashmap.put(sum, i);
            }            
        }
        return res;
    }    
}



