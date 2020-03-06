//You are given coins of different denominations and a total amount of money amount. 
//Write a function to compute the fewest number of coins that you need to make up that amount. 
//If that amount of money cannot be made up by any combination of the coins, return -1.

//Example
//Example1
//
//Input: 
//[1, 2, 5]
//11
//Output: 3
//Explanation: 11 = 5 + 5 + 1

//Example2
//
//Input: 
//[2]
//3
//Output: -1

//Notice
//You may assume that you have an infinite number of each kind of coin.




public class Solution {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    // dp[i][j]: min cost to make up j amount using first i types of coins
    // dp[i][j] = min(dp[i][j], dp[i][j - coin_i] + 1)
    //
    // Time: O(n * amount)
    // Space: O(n * amount) -> O(amount)     
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin]);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
        }
        return dp[amount];
    }
}



