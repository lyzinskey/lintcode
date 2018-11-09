//Given two strings, find the longest common subsequence (LCS).

//Your code should return the length of LCS.

//Example
//For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

//For "ABCD" and "EACB", the LCS is "AC", return 2.

//Clarification
//What's the definition of Longest Common Subsequence?

//https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
//http://baike.baidu.com/view/2020307.htm




public class Solution {
    public int longestCommonSubsequence(String source, String target) {
        if (source.length() == 0 || target.length() == 0) {
            return 0;
        }
    
        int[][] dp = new int[source.length() + 1][target.length() + 1];
    
        for (int i = 1; i <= source.length(); i++) {
            for (int j = 1; j <= target.length(); j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;          
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[source.length()][target.length()];
  }
}



