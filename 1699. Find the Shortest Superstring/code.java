//Given an array A of strings, find any smallest string that contains each string in A as a substring.

//We may assume that no string in A is substring of another string in A.

//Example
//Example 1:
//
//Input：["alex","loves","leetcode"]
//Output："alexlovesleetcode"
//Explanation：All permutations of "alex","loves","leetcode" would also be accepted.

//Example 2:
//
//Input：["catg","ctaagt","gcta","ttca","atgcatc"]
//Output："gctaagttcatgcatc"
//Explanation：The substrings that are contained in `A` of "gctaagttcatgcatc" are "gcta","ctaagt","ttca","catg","atgcatc".

//Notice
//1.1 <= A.length <= 12
//2.1 <= A[i].length <= 20






public class Solution {
    // dp (TSP)
    // memoization of the combination and the last node instead of permutation
    // dp[s][i] = min cost to visit modes of s and ends with i
    // s is a binary string
    // dp[14][2] is the min cost to visit node {1, 2, 3} and ends with node 2 (14 = 2^1 + 2^2 + 2^3)
    // dp[s][i] = min {dp[s - 2^i][j] + cost[j][i]}  append A[i] after A[j]
    // Ans: min(dp[2^n - 1][*])
    //
    // Time: O(n^2 * 2^n)
    // Space: O(n * 2^n)
    public String shortestSuperstring(String[] A) {
        int len = A.length;
        int[][] cost = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                cost[i][j] = A[j].length();
                for (int k = Math.min(A[i].length(), A[j].length()); k >= 0; k--) {
                    String sub1 = A[i].substring(A[i].length() - k);
                    String sub2 = A[j].substring(0, k);
                    if (sub1.equals(sub2)) {
                        cost[i][j] = A[j].length() - k;
                        break;
                    }
                }
            }
        }

        int maxLen = 1 << len;
        int[][] dp = new int[maxLen][len];
        int[][] parent = new int[maxLen][len];
        for (int i = 0; i < maxLen; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            Arrays.fill(parent[i], -1);
        }

        for (int i = 0; i < len; i++) {
            dp[1 << i][i] = A[i].length();
        }

        for (int s = 1; s < maxLen; s++) {
            for (int j = 0; j < len; j++) {
                if ((s & (1 << j)) == 0) {
                    continue;
                }
                int ps = s & ~(1 << j);
                for (int i = 0; i < len; i++) {
                    if (dp[ps][i] + cost[i][j] < dp[s][j]) {
                        dp[s][j] = dp[ps][i] + cost[i][j];
                        parent[s][j] = i;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int min = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (min > dp[dp.length - 1][i]) {
                min = dp[dp.length - 1][i];
                j = i;
            }
        }
        int s = maxLen - 1;

        while (s > 0) {
            int i = parent[s][j];
            if (i < 0) {
                sb.insert(0, A[j]);
            } else {
                sb.insert(0, A[j].substring(A[j].length() - cost[i][j]));
            }
            s &= ~(1 << j);
            j = i;
        }
        return sb.toString();
    }      
}





