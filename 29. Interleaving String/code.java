//Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

//Example
//Example 1:
//
//Input:
//"aabcc"
//"dbbca"
//"aadbbcbcac"
//Output: true

//Example 2:
//
//Input:
//""
//""
//"1"
//Output: false

//Example 3:
//
//Input:
//"aabcc"
//"dbbca"
//"aadbbbaccc"
//Output: false

//Challenge
//O(n2) time or better





public class Solution {
    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = s2.charAt(j - 1) == s3.charAt(j - 1) ? dp[i][j - 1] : false;
                } else if (j == 0) {
                    dp[i][j] = s1.charAt(i - 1) == s3.charAt(i - 1) ? dp[i - 1][j] : false;
                } else {
                    if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j] || 
                       s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}



