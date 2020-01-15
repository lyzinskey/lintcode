//Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

//A region is captured by flipping all 'O''s into 'X''s in that surrounded region.

//Example
//Example 1:
//
//Input:
//  X X X X
//  X O O X
//  X X O X
//  X O X X
//Output:
//  X X X X
//  X X X X
//  X X X X
//  X O X X

//Example 2:
//
//Input:
//  X X X X
//  X O O X
//  X O O X
//  X O X X
//Output:
//  X X X X
//  X O O X
//  X O O X
//  X O X X





public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    // dfs
    // Time: O(mn)
    // Space: O(mn)
    public void surroundedRegions(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int row = board.length;
        int col = board[0].length;
        
        // check left and right border
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }
        
        // check top and bottom border
        for (int i = 0; i < col; i++) {
            dfs(board, 0, i);
            dfs(board, row - 1, i);
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }        
    }
    
    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'G';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }    
}




