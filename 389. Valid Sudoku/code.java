//Determine whether a Sudoku is valid.

//The Sudoku board could be partially filled, where empty cells are filled with the character ..

//Example
//Example 1:
//
//Input:
//["53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"]
//Output: true

//Example 2:
//
//Input:
//["53..7j...","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"]
//Output: false
//Explanation: 
//It's invaild because there are two '5' in the first row and the sixth line.

//Clarification
//What is Sudoku?
//
//http://sudoku.com.au/TheRules.aspx
//https://zh.wikipedia.org/wiki/數獨
//https://en.wikipedia.org/wiki/Sudoku
//http://baike.baidu.com/subview/961/10842669.htm

//Notice
//A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.




public class Solution {
    //  Collect the set of things we see, encoded as strings. For example:
    //  '4' in row 7 is encoded as "(4)7".
    //  '4' in column 7 is encoded as "7(4)".
    //  '4' in the top-right block is encoded as "0(4)2".
    //  Scream false if we ever fail to add something because it was already added (i.e., seen before). 
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    String num = "(" + board[i][j] + ")";
                    if (!seen.add(num + i) || !seen.add(j + num) || !seen.add(i/3 + num + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}



