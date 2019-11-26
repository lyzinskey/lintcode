//We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.

//XX  <- domino
//
//XX  <- "L" tromino
//X
//
//Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.

//(In a tiling, every square must be covered by a tile. 
//Two tilings are different if and only if there are two 4-directionally adjacent cells on the board 
//such that exactly one of the tilings has both squares occupied by a tile.)

//Example
//Example 1:
//
//Input: 3
//Output: 5
//Explanation: The five different ways are listed below, different letters indicates different tiles:
//  1. XYZ  2. XXZ  3. XYY  4. XXY  5. XYY
//     XYZ     YYZ     XZZ     XYY     XXY

//Example 2:
//
//Input: 1
//Output: 1

//Notice
//N will be in range [1, 1000].




public class Solution {
    /**
     * @param N: a integer
     * @return: return a integer
     */
    
    // dp[i][0]: ways to cover i cols, both rows of col i are covered
    // dp[i][1]: ways to cover i cols, top row of col i is covered
    // dp[i][2]: ways to cover i cols, bottom row of col i is covered
    //
    // induction rule: 
    // dp[i][0] = dp[i - 1][0] + dp[i - 2][0] + dp[i - 1][1] + dp[i - 1][2]
    // dp[i][1] = dp[i - 2][0] + dp[i - 1][2]
    // dp[i][2] = dp[i - 2][0] + dp[i - 1][1]
    //
    // dp[i][1] is always equals to dp[i][2], so induction rule can be simplified to:
    // dp[i][0] = dp[i - 1][0] + dp[i - 2][0] + 2 * dp[i - 1][1]
    // dp[i][1] = dp[i - 2][0] + dp[i - 1][1] 
    public int numTilings(int N) {
        int module = 1000000007;
        long[][] dp = new long[N + 1][2];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + 2 * dp[i - 1][1]) % module;
            dp[i][1] = (dp[i - 2][0] + dp[i - 1][1]) % module;            
        }
        return (int) dp[N][0];
    }
}




