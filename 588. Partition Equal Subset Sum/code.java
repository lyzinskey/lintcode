//Given a non-empty array containing only positive integers, 
//find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

//Example
//Example 1:
//
//Input: nums = [1, 5, 11, 5], 
//Output: true
//Explanation:
//two subsets: [1, 5, 5], [11]

//Example 2:
//
//Input: nums = [1, 2, 3, 9], 
//Output: false

//Notice
//Each of the array element will not exceed 100.
//The array size will not exceed 200.




public class Solution {
    /**
     * @param nums: a non-empty array only positive integers
     * @return: true if can partition or false
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][sum + 1];
        
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }                
            }
        }
        return dp[len][sum];
    }    
}



