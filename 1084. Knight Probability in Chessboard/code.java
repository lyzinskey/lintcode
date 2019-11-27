//On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. 
//The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).

//A chess knight has 8 possible moves it can make, as illustrated below. 
//Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
//https://assets.leetcode.com/uploads/2018/10/12/knight.png

//Each time the knight is to move, 
//it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

//The knight continues moving until it has made exactly K moves or has moved off the chessboard. 
//Return the probability that the knight remains on the board after it has stopped moving.

//Example
//Example 1:
//
//Input: 3, 2, 0, 0
//Output: 0.06
//Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
//From each of those positions, there are also two moves that will keep the knight on the board.
//The total probability the knight stays on the board is 0.06.

//Example 2:
//
//Input: 3, 3, 0, 0
//Output: 0.02
//Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
//From each of those positions, there are also two moves that will keep the knight on the board.
//The total probability the knight stays on the board is 0.02.

//Notice
//N will be between 1 and 25.
//K will be between 0 and 100.
//The knight always initially starts on the board.




public class Solution {
    /**
     * @param N: int
     * @param K: int
     * @param r: int
     * @param c: int
     * @return: the probability
     */
    
    /*
    dp[k][i][j]: number of ways to move to (i, j) after k steps
    dp[k][i][j] = sum(dp[k - 1][x][y]) for all (x, y) can move to (i, j)
    ans = sum(dp[k][i][j]) / (8 ^ K)
    
    Time: O(K * N^2)
    Space: O(K * N^2)
    */ 
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[K + 1][N][N];
        dp[0][r][c] = 1.0;
        int[][] dirs = new int[][] {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {1, 2}, {2, 1}};
        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int d = 0; d < 8; d++) {
                        int di = i + dirs[d][0];
                        int dj = j + dirs[d][1];
                        if (di < 0 || di >= N || dj < 0 || dj >= N) {
                            continue;
                        }
                        dp[k][i][j] += dp[k - 1][di][dj];
                    }
                }
            }
        }
        
        double count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += dp[K][i][j];
            }
        }
        
        return count / Math.pow(8, K);
    }
}




