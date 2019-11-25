//A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), 
//followed by some number of '1's (also possibly 0.)

//We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.

//Return the minimum number of flips to make S monotone increasing.

//Example
//Example 1:
//
//Input: "00110"
//Output: 1
//Explanation: 
//We flip the last digit to get 00111.

//Example 2:
//
//Input: "010110"
//Output: 2
//Explanation: 
//We flip to get 011111, or alternatively 000111.

//Notice
//1 <= S.length <= 20000
//S only consists of '0' and '1' characters.




public class Solution {
    /**
     * @param S: a string
     * @return: the minimum number
     */
    public int minFlipsMonoIncr(String S) {
        int[][] dp = new int[S.length() + 1][2];
        int dp0 = 0;
        int dp1 = 0;
        for (int i = 1; i <= S.length(); i++) {
            int temp0 = 0;
            int temp1 = 0;
            if (S.charAt(i - 1) == '0') {
                temp0 = dp0;
                temp1 = Math.min(dp0, dp1) + 1;
            } else {
                temp0 = dp0 + 1;
                temp1 = Math.min(dp0, dp1);
            }
            dp0 = temp0;
            dp1 = temp1;
        }
        return Math.min(dp0, dp1);
    }
}



