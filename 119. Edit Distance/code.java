//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
//(each operation is counted as 1 step.)

//You have the following 3 operations permitted on a word:
//
//Insert a character
//Delete a character
//Replace a character

//Example
//Given word1 = "mart" and word2 = "karma", return 3.




public class Solution {
    public int minDistance(String one, String two) {
        int lengthOne = one.length();
        int lengthTwo = two.length();
        if (lengthOne == 0 && lengthTwo == 0) {
            return 0;
        }
        if (lengthOne == 0) {
            return lengthTwo;
        }
        if (lengthTwo == 0) {
            return lengthOne;
        }

        int[][] DP = new int[lengthOne + 1][lengthTwo + 1];
        DP[0][0] = 0;
        for (int i = 0; i < lengthOne + 1; i++) {
            for (int j = 0; j < lengthTwo + 1; j++) {
                if (i == 0) {
                    DP[i][j] = j;
                }
                else if (j == 0) {
                    DP[i][j] = i;
                }
                else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    DP[i][j] = DP[i - 1][j - 1];
                }
                else {
                    DP[i][j] = getMin(DP[i - 1][j - 1], DP[i - 1][j], DP[i][j - 1]) + 1;
                }
            }
        }
        return DP[lengthOne][lengthTwo];
    }

    private int getMin(int a, int b, int c) {
        int temp = Math.min(a, b);
        return Math.min(temp, c);
    }
}



