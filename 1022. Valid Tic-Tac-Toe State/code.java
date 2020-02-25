//A Tic-Tac-Toe board is given as a string array board. 
//Return true if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.

//The board is a 3 x 3 array, and consists of characters ' ', 'X', and 'O'. The ' ' character represents an empty square.

//Here are the rules of Tic-Tac-Toe:
//Players take turns placing characters into empty squares ' '.
//The first player always places 'X' characters, while the second player always places 'O' characters.
//'X' and 'O' characters are always placed into empty squares, never filled ones.
//The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
//The game also ends if all squares are non-empty.
//No more moves can be played if the game is over.

//Example
//Example 1:
//
//Input: board = ["O  ", "   ", "   "]
//Output: false
//Explanation: The first player always plays "X".

//Example 2:
//
//Input: board = ["XOX", " X ", "   "]
//Output: false
//Explanation: Players take turns making moves.

//Example 3:
//
//Input: board = ["XXX", "   ", "OOO"]
//Output: false

//Example 4:
//
//Input: board = ["XOX", "O O", "XOX"]
//Output: true

//Notice
//board is a length-3 array of strings, where each string board[i] has length 3.
//Each board[i][j] is a character in the set {' ', 'X', 'O'}.




public class Solution {
    /**
     * @param board: the given board
     * @return: True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game
     */
    private char[][] gameBoard = new char[3][3];

    public boolean validTicTacToe(String[] board) {
        unpackBoard(board);
        return gameBoardValidation();
    }

    private void unpackBoard(String[] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.gameBoard[i][j] = board[i].charAt(j);
            }
        }
    }

    private boolean gameBoardValidation() {
        int numX, numO;
        numX = count('X');
        numO = count('O');

        //X goes first
        if (numO > numX) {
            return false;
        }
        //players take turns
        if (numX > numO + 1) {
            return false;
        }
        //both players can't win
        if (winner('X') && winner('O')) {
            return false;
        }
        //game ends when one player wins
        if (winner('X') && numX == numO) {
            return false;
        }
        //game ends when one player wins
        if (winner('O') && numX > numO) {
            return false;
        }
        return true;
    }

    private int count(char player) {
        int num = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == player) num++;
            }
        }
        return num;
    }

    private boolean winner(char player) {
        if (validateRows(player)) {
            return true;
        }
        if (validateColumns(player)) {
            return true;
        }
        if (validateDiagonal(player)) {
            return true;
        }
        return false;
    }

    private boolean validateRows(char player) {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][0] == player && gameBoard[i][1] == player && gameBoard[i][2] == player) {
                return true;
            }
        }
        return false;
    }

    private boolean validateColumns(char player) {
        for (int i = 0; i < 3; i++) {
            if (gameBoard[0][i] == player && gameBoard[1][i] == player && gameBoard[2][i] == player) {
                return true;
            }
        }
        return false;
    }

    private boolean validateDiagonal(char player) {
        if (gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) {
            return true;
        }
        if (gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player) {
            return true;
        }
        return false;
    }
}




