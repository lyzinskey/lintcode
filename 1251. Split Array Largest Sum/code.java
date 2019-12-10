//Given an array which consists of non-negative integers and an integer m, 
//we are going to split the array into m non-empty continuous subarrays. 
//Write an algorithm to minimize the largest sum among these m subarrays.

//Example
//Example 1:
//
//Input：[7,2,5,10,8], m = 2
//Output：18
//Explanation：
//    There are four ways to split nums into two subarrays.
//    The best way is to split it into [7,2,5] and [10,8],
//    where the largest sum among the two subarrays is only 18.

//Example 2:
//
//Input：[1,4,4], m = 3
//Output：4
//Explanation：
//    There is a way to split nums into three subarrays.
//    The best way is to split it into [1], [4] and [4],
//    where the largest sum among the three subarrays is only 4.

//Notice
//If n is the length of array, assume the following constraints are satisfied:
//
//1 ≤ n ≤ 1000
//1 ≤ m ≤ min(50, n)




public class Solution {
    /**
     * @param nums: a list of integers
     * @param m: an integer
     * @return: return a integer
     */
    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[nums.length][m + 1];
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        
        for (int i = 0; i < nums.length; i++) {
            dp[i][1] = sum[i];
        }
        
        for (int i = 2; i <= m; i++) {
            for (int j = i - 1; j < nums.length; j++) {
                dp[j][i] = Integer.MAX_VALUE;      
                for (int k = 0; k < j; k++) {
                    dp[j][i] = Math.min(dp[j][i], Math.max(dp[k][i - 1], sum[j] - sum[k]));
                }
            }
        }
        return dp[nums.length - 1][m];
    }    
}



