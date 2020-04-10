//X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X. 
//Each digit must be rotated - we cannot choose to leave it alone.

//A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 
//2 and 5 rotate to each other; 6 and 9 rotate to each other, 
//and the rest of the numbers do not rotate to any other number and become invalid.

//Now given a positive number N, how many numbers X from 1 to N are good?

//Example
//Example 1:
//
//Input: 10
//Output: 4
//Explanation: 
//There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
//Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.

//Example 2:
//
//Input: 5
//Output: 2
//Explanation: 
//There are two good numbers in the range [1, 5] : 2, 5.

//Notice
//N will be in range [1, 10000].





public class Solution {
    /**
     * @param N: a positive number
     * @return: how many numbers X from 1 to N are good
     */
    public int rotatedDigits(int N) {
        char[] A = String.valueOf(N).toCharArray();
        int K = A.length;

        int[][][] memo = new int[K+1][2][2];
        memo[K][0][1] = memo[K][1][1] = 1;
        for (int i = K - 1; i >= 0; --i) {
            for (int eqf = 0; eqf <= 1; ++eqf)
                for (int invf = 0; invf <= 1; ++invf) {
                    // We will compute ans = memo[i][eqf][invf],
                    // the number of good numbers with respect to N = A[i:].
                    // If eqf is true, we must stay below N, otherwise
                    // we can use any digits.
                    // Invf becomes true when we write a 2569, and it
                    // must be true by the end of our writing as all
                    // good numbers have a digit in 2569.
                    int ans = 0;
                    for (char d = '0'; d <= (eqf == 1 ? A[i] : '9'); ++d) {
                        if (d == '3' || d == '4' || d == '7') continue;
                        boolean invo = (d == '2' || d == '5' || d == '6' || d == '9');
                        ans += memo[i+1][d == A[i] ? eqf : 0][invo ? 1 : invf];
                    }
                    memo[i][eqf][invf] = ans;
                }
        }

        return memo[0][1][0];
    }
}



