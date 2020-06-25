//Given n, how many structurally unique BSTs (binary search trees) that store values 1...n?

//Example
//Example 1:
//
//Input:n = 3,
//Output: 5
//Explanation:there are a total of 5 unique BST's.
//1           3    3       2      1
// \         /    /       / \      \
//  3      2     1       1   3      2
// /      /       \                  \
//2     1          2                  3





public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    // dp[i]: number of different BST which contains i nodes
    // dp[i] = sum of dp[left subtree] * dp[right subtree]
    //
    // e.g. n = 4, dp[4] = dp[1] * dp[4-1] + dp[2] * dp[4-2] + dp[3] * dp[4-3]   
    // 假设左子树有i个点，那么dp[i]是所有不同左子树的数量，右子树有n-i个点，对应dp[n-i]，
    // 因此左子树i，右子树n-i这个组合能组成的所有不同BST数量是dp[i] * dp[n-i]，
    // 1～n-1遍历所有可能的i即可
    //
    // Time: O(n^2)
    // Space: O(n)
    public int numTrees(int n) {
        if (n == 0) {
            return 1;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}



