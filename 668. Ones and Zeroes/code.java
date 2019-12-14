//In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

//For now, suppose you are a dominator of m 0s and n 1s respectively. 
//On the other hand, there is an array with strings consisting of only 0s and 1s.

//Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. 
//Each 0 and 1 can be used at most once.

//Example
//Example1
//
//Input:
//["10", "0001", "111001", "1", "0"]
//5
//3
//Output: 4
//Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are "10", "0001", "1", "0"

//Example2
//
//Input:
//["10", "0001", "111001", "1", "0"]
//7
//7
//Output: 5
//Explanation: All strings can be formed by the using of 7 0s and 7 1s.

//Notice
//The given numbers of 0s and 1s will both not exceed 100
//The size of given string array won't exceed 600.





/*This problem is a typical 0-1 knapsack problem, 
we need to pick several strings in provided strings 
to get the maximum number of strings using limited number 0 and 1. 
We can create a three dimensional array, 
in which dp[i][j][k] means the maximum number of strings we can get 
from the first i argument strs using limited j number of '0's and k number of '1's.

For dp[i][j][k], we can get it by fetching the current string i or discarding the current string, 
which would result in 
dp[i][j][k] = dp[i-1][j-numOfZero(strs[i])][i-numOfOnes(strs[i])] 
and dp[i][j][k] = dp[i-1][j][k]; 
We only need to treat the larger one in it as the largest number for dp[i][j][k].
*/
public class Solution {
    /**
     * @param strs: an array with strings include only 0 and 1
     * @param m: An integer
     * @param n: An integer
     * @return: find the maximum number of strings
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i < l; i++) {
            int[] bit = count(strs[i]);
            // starting from largest possible value to minimum value to save time
            for (int j = m; j >= bit[0]; j--) {
                for (int k = n; k >= bit[1]; k--) {                    
                    dp[j][k] = Math.max(dp[j][k], dp[j - bit[0]][k - bit[1]] + 1);                    
                }
            }
        }
        return dp[m][n];
    }
    
    private int[] count(String str) {
        int[] bit = new int[2];
        for (char ch : str.toCharArray()) {
            if (ch == '0') {
                bit[0]++;
            } else {
                bit[1]++;
            }
        }
        return bit;
    }    
}




