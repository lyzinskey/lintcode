//You are given coins of different denominations and a total amount of money. 
//Write a function to compute the number of combinations that make up that amount. 
//You may assume that you have infinite number of each kind of coin.

//Example
//Example1
//
//Input: amount = 10 and coins = [10] 
//Output: 1

//Example2
//
//Input: amount = 8 and coins = [2, 3, 8]
//Output: 3
//Explanation:
//there are three ways to make up the amount:
//8 = 8
//8 = 3 + 3 + 2
//8 = 2 + 2 + 2 + 2

//Notice
//You can assume below:
//0 <= amount <= 5000
//1 <= coin <= 5000
//the number of coins is less than 500
//the answer is guaranteed to fit into signed 32-bit integer




public class Solution {
    /**
     * @param amount: a total amount of money amount
     * @param coins: the denomination of each coin
     * @return: the number of combinations that make up the amount
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }    
}



