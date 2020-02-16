//There are n cities connected by some flights. Each flight (u, v, w) starts from city u and arrives at v with a price w.

//Given n, flights, together with starting city src and the destination dst, 
//your task is to find the cheapest price from src to dst with at most K stops.
//If there is no such route, return -1.

//Example
//Example 1:
//
//Input: 
//  n = 3,
//  flights = [[0,1,100],[1,2,100],[0,2,500]],
//  src = 0, dst = 2, K = 0
//Output: 500

//Example 2:
//
//Input: 
//  n = 3,
//  flights = [[0,1,100],[1,2,100],[0,2,500]],
//  src = 0, dst = 2, K = 1
//Output: 200

//Notice
//The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
//The size of flights will be in range [0, n * (n - 1) / 2].
//The format of each flight will be [src, dst, price].
//The price of each flight will be in the range [1, 10000].
//K is in the range of [0, n - 1].
//There will not be any duplicated flights or self cycles.




public class Solution {
    /**
     * @param n: a integer
     * @param flights: a 2D array
     * @param src: a integer
     * @param dst: a integer
     * @param K: a integer
     * @return: return a integer
     */
    // Time: O(k|E|) -> O(kn^2)
    // Space: O(kn)
    //
    // dp[k][v]: min cost form src to v with at most k flights
    // init: dp[0~k-2][src] = 0
    // dp[k][v] = min(dp[k - 1][v], {dp[k - 1][u] + cost[u][v]})
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int infCost = 100000;
        int[][] dp = new int[K + 2][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], infCost);
        }
        dp[0][src] = 0;

        for (int i = 1; i <= K + 1; i++) {
            dp[i][src] = 0;
            for (int j = 0; j < flights.length; j++) {
                dp[i][flights[j][1]] = Math.min(dp[i][flights[j][1]], dp[i - 1][flights[j][0]] + flights[j][2]);
            }
        }
        return dp[K + 1][dst] >= infCost ? -1 : dp[K + 1][dst];
    }    
}



