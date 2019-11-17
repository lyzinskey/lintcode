//There are a row of n houses, each house can be painted with one of the k colors. 
//The cost of painting each house with a certain color is different. 
//You have to paint all the houses such that no two adjacent houses have the same color.

//The cost of painting each house with a certain color is represented by a n x k cost matrix. 
//For example, costs[0][0] is the cost of painting house 0 with color 0; 
//costs[1][2] is the cost of painting house 1 with color 2, and so on... 
//Find the minimum cost to paint all houses.

//Example
//Example 1
//
//Input:
//costs = [[14,2,11],[11,14,5],[14,3,10]]
//Output: 10
//Explanation:
//The three house use color [1,2,1] for each house. The total cost is 10.

//Example 2
//
//Input:
//costs = [[5]]
//Output: 5
//Explanation:
//There is only one color and one house.

//Notice
//All costs are positive integers.

//Challenge
//Could you solve it in O(nk)?




public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int prevMin = 0;
        int prevSecondMin = 0;
        int prevColor = -1;

        for (int i = 0; i < costs.length; i++) {
            int currMin = Integer.MAX_VALUE;
            int currSecondMIN = Integer.MAX_VALUE;
            int currColor = 0;
            for (int j = 0; j < costs[0].length; j++) {
                int curr = prevColor != j ? prevMin + costs[i][j] : prevSecondMin + costs[i][j];
                if (curr < currMin) {
                    currSecondMIN = currMin;
                    currMin = curr;
                    currColor = j;
                } else if (curr < currSecondMIN) {
                    currSecondMIN = curr;
                }
            }
            prevMin = currMin;
            prevSecondMin = currSecondMIN;
            prevColor = currColor;
        }
        return prevMin;
    }
    
    
    
    
//     // dp
//     // Time: O(n * k * k)
//     // Space: O(nk)
//     public int minCostII(int[][] costs) {
//         if (costs == null || costs.length == 0 || costs[0].length == 0) {
//             return 0;
//         }
        
//         int[][] dp = new int[costs.length][costs[0].length];
//         for (int i = 0; i < costs[0].length; i++) {
//             dp[0][i] = costs[0][i];
//         }
        
//         for (int i = 1; i < costs.length; i++) {
//             for (int j = 0; j < costs[0].length; j++) {
//                 int min = Integer.MAX_VALUE;
//                 for (int k = 0; k < costs[0].length; k++) {
//                     if (j == k) {
//                         continue;
//                     }
//                     min = Math.min(dp[i - 1][k], min);
//                 }
//                 dp[i][j] = min + costs[i][j];
//             }
//         }
        
//         int result = Integer.MAX_VALUE;
//         for (int i = 0; i < costs[0].length; i++) {
//             result = Math.min(dp[costs.length - 1][i], result);
//         }
//         return result;
//     }    
}



