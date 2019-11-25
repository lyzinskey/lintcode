//A robot is located at the top-left corner of a m x n grid.

//The robot can only move either down or right at any point in time. 
//The robot is trying to reach the bottom-right corner of the grid.

//How many possible unique paths are there?

//Example
//Example 1:
//
//Input: n = 1, m = 3
//Output: 1	
//Explanation: Only one path to target position.

//Example 2:
//
//Input:  n = 3, m = 3
//Output: 6	
//Explanation:
//	D : Down
//	R : Right
//	1) DDRR
//	2) DRDR
//	3) DRRD
//	4) RRDD
//	5) RDRD
//	6) RDDR

//Notice
//m and n will be at most 100.
//The answer is guaranteed to be in the range of 32-bit integers




public class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }                
            }
        }
        return dp[m - 1][n - 1];
    }
}



