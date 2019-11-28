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
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String source, String target) {
        if (source.isEmpty() || target.isEmpty()) {
            return 0;
        }

        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int[][] dp = new int[s.length + 1][t.length + 1];

        for (int i = 1; i < s.length + 1; i++) {
            for (int j = 1; j < t.length + 1; j++) {     
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s.length][t.length];
    }
}



