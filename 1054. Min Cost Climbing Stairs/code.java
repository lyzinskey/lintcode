//On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

//Once you pay the cost, you can either climb one or two steps. 
//You need to find minimum cost to reach the top of the floor, 
//and you can either start from the step with index 0, or the step with index 1.

//Example
//Example 1:
//
//Input: cost = [10, 15, 20]
//Output: 15
//Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

//Example 2:
//
//Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//Output: 6
//Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

//Notice
//1.cost will have a length in the range [2, 1000].
//2.Every cost[i] will be an integer in the range [0, 999].




public class Solution {
    /**
     * @param cost: an array
     * @return: minimum cost to reach the top of the floor
     */
    public int minCostClimbingStairs(int[] cost) {
        int twoPrev = cost[0];
        int onePrev = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int curr = Math.min(twoPrev, onePrev) + cost[i];
            twoPrev = onePrev;
            onePrev = curr;
        }
        return Math.min(twoPrev, onePrev);
    }
}



