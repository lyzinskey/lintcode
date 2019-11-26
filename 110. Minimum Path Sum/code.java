//Given a m x n grid filled with non-negative numbers, 
//find a path from top left to bottom right which minimizes the sum of all numbers along its path.

//Example
//Example 1:
//	Input:  [[1,3,1],[1,5,1],[4,2,1]]
//	Output: 7
//	
//	Explanation:
//	Path is: 1 -> 3 -> 1 -> 1 -> 1

//Example 2:
//	Input:  [[1,3,2]]
//	Output: 6
//	
//	Explanation:  
//	Path is: 1 -> 3 -> 2

//Notice
//You can only go right or down in the path..




public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;        
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}




