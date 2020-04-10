//Let's play the minesweeper game (Wikipedia, online game)!

//You are given a 2D char matrix representing the game board. 
//'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 
//'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, 
//digit ('1' to '8') represents how many mines are adjacent to this revealed square, 
//and finally 'X' represents a revealed mine.

//Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), 
//return the board after revealing this position according to the following rules:

//If a mine ('M') is revealed, then the game is over - change it to 'X'.
//If an empty square ('E') with no adjacent mines is revealed, 
//then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
//If an empty square ('E') with at least one adjacent mine is revealed, 
//then change it to a digit ('1' to '8') representing the number of adjacent mines.
//Return the board when no more squares will be revealed.

//Example
//Example 1:
//
//Input: board = ["EEEEE","EEMEE","EEEEE","EEEEE"], Click : [3,0]
//Output: ["B1E1B","B1M1B","B111B","BBBBB"]

//Example 2:
//
//Input: board = ["B1E1B","B1M1B", "B111B","BBBBB"], Click : [1,2]
//Output: ["B1E1B","B1X1B","B111B","BBBBB"]

//Notice
//1.The range of the input matrix's height and width is [1,50].
//2.The click position will only be an unrevealed square ('M' or 'E'), 
//which also means the input board contains at least one clickable square.
//3.The input board won't be a stage when game is over (some mines have been revealed).
//4.For simplicity, not mentioned rules should be ignored in this problem. 
//For example, you don't need to reveal all the unrevealed mines when the game is over, 
//consider any cases that you will win the game or flag any squares.





public class Solution {
    /**
     * @param board: a board
     * @param click: the position
     * @return: the new board
     */
    // Time: O(mn)
    // Space: O(mn)     
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = board.length;
        int col = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            if (board[x][y] == 'M') { // Mine
                board[x][y] = 'X';
            } else { // Empty
                // Get number of mines first.
                int count = 0;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int dx = x + i;
                        int dy = y + j;
                        if (dx < 0 || dx >= row || dy < 0 || dy >= col) {
                            continue;
                        }
                        if (board[dx][dy] == 'M' || board[dx][dy] == 'X') {
                            count++;
                        }
                    }
                }

                if (count > 0) { // If it is not a 'B', stop further BFS.
                    board[x][y] = (char) (count + '0');
                } else { // Continue BFS to adjacent cells.
                    board[x][y] = 'B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) {
                                continue;
                            }
                            int dx = x + i, dy = y + j;
                            if (dx < 0 || dx >= row || dy < 0 || dy >= col) {
                                continue;
                            }
                            if (board[dx][dy] == 'E') {
                                queue.add(new int[]{dx, dy});
                                board[dx][dy] = 'B'; // Avoid to be added again.
                            }
                        }
                    }
                }
            }
        }
        return board;
    }    
}




