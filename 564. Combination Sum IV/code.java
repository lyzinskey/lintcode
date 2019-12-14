//Given an integer array nums with all positive numbers and no duplicates, 
//find the number of possible combinations that add up to a positive integer target.

//Example
//Example1
//
//Input: nums = [1, 2, 4], and target = 4
//Output: 6
//Explanation:
//The possible combination ways are:
//[1, 1, 1, 1]
//[1, 1, 2]
//[1, 2, 1]
//[2, 1, 1]
//[2, 2]
//[4]

//Example2
//
//Input: nums = [1, 2], and target = 4
//Output: 5
//Explanation:
//The possible combination ways are:
//[1, 1, 1, 1]
//[1, 1, 2]
//[1, 2, 1]
//[2, 1, 1]
//[2, 2]

//Notice
//A number in the array can be used multiple times in the combination.
//Different orders are counted as different combinations.




public class Solution {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }                
            }
        }
        return dp[target];
    }
}



