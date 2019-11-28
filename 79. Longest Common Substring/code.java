//Given two strings, find the longest common substring.
//Return the length of it.

//Example
//Example 1:
//	Input:  "ABCD" and "CBCE"
//	Output:  2
//	
//	Explanation:
//	Longest common substring is "BC"

//Example 2:
//	Input: "ABCD" and "EACB"
//	Output:  1
//	
//	Explanation: 
//	Longest common substring is 'A' or 'C' or 'B'

//Challenge
//O(n x m) time and memory.

//Notice
//The characters in substring should occur continuously in original string. This is different with subsequence.




public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String source, String target) {
        if (source.isEmpty() || target.isEmpty()) {
            return 0;
        }

        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        int[][] dp = new int[s.length + 1][t.length + 1];
        int max = 0;

        for (int i = 0; i < s.length + 1; i++) {
            for (int j = 0; j < t.length + 1; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }    
}




