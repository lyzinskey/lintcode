//You are a professional robber planning to rob houses along a street. 
//Each house has a certain amount of money stashed, 
//the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
//and it will automatically contact the police if two adjacent houses were broken into on the same night.

//Given a list of non-negative integers representing the amount of money of each house, 
//determine the maximum amount of money you can rob tonight without alerting the police.

//Example
//Example 1:
//
//Input: [3, 8, 4]
//Output: 8
//Explanation: Just rob the second house.

//Example 2:
//
//Input: [5, 2, 1, 3]
//Output: 8
//Explanation: Rob the first and the last house.

//Challenge
//O(n) time and O(1) memory.



public class Solution {
    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        long sum = 0;
        long prev = 0;
        
        for (int i = 0; i < A.length; i++) {
            long temp = sum;
            sum = Math.max(A[i] + prev, sum);
            prev = temp;
        }
        return sum;
    }
}

