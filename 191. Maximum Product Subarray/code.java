//Find the contiguous subarray within an array (containing at least one number) which has the largest product.

//Example
//Example 1:
//
//Input:[2,3,-2,4]
//Output:6

//Example 2:
//
//Input:[-1,2,4,1]
//Output:8

//Notice
//The product of the largest subsequence of the product, less than 2147483647




public class Solution {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    // keep track of max subarray and min subarray
    // Time: O(n)
    // Space: O(1)
    public int maxProduct(int[] nums) {        
        int max = nums[0];
        int min = nums[0];
        int res = Math.max(max, min);
        int prevMax = max;
        int prevMin = min;
        for (int i = 1; i < nums.length; i++) {
            prevMax = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            prevMin = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));            
            res = Math.max(res, Math.max(prevMax, prevMin));
            max = prevMax;
            min = prevMin;
        }
        return res == Integer.MIN_VALUE ? Math.max(max, min) : res;
    }
}



