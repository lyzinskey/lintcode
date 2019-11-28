//Given a sequence of integers, find the longest increasing subsequence (LIS).

//You code should return the length of the LIS.

//Example
//For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
//For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4

//Challenge
//Time complexity O(n^2) or O(nlogn)

//Clarification
//What's the definition of longest increasing subsequence?

//The longest increasing subsequence problem is to find a subsequence of a given sequence 
//in which the subsequence's elements are in sorted order, lowest to highest, 
//and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.
//
//https://en.wikipedia.org/wiki/Longest_increasing_subsequence




public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int[] dp = new int[array.length];
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 1; i < array.length; i++) {
            int max = 0;      
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            res = Math.max(dp[i], res);
        }
        return res;
    }   
}



