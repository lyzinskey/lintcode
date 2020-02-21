//Given a 2D board and a word, find if the word exists in the grid.

//The word can be constructed from letters of sequentially adjacent cell, 
//where "adjacent" cells are those horizontally or vertically neighboring. 
//The same letter cell may not be used more than once.

//Example
//Given board =
//  
//  [
//    "ABCE",
//    "SFCS",
//    "ADEE"
//  ]
//  word = "ABCCED", -> returns true,
//  word = "SEE", -> returns true,
//  word = "ABCB", -> returns false.




public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    // Time: O(m * n * 4^l)
    // Space: O(l)
    public boolean exist(char[][] board, String word) {
        char[] array = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, array, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, char[] array, int index, int x, int y) {
        if (index == array.length) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || array[index] != board[x][y]) {
            return false;
        }
        board[x][y] = '?';
        boolean res = dfs(board, array, index + 1, x + 1, y) ||
            dfs(board, array, index + 1, x - 1, y) ||
            dfs(board, array, index + 1, x, y + 1) ||
            dfs(board, array, index + 1, x, y - 1);
        board[x][y] = array[index];
        return res;
    }
}
    
    


