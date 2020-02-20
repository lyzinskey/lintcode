//On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
//A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
//The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
//Given a puzzle board, return the least number of moves required so that the state of the board is solved. 
//If it is impossible for the state of the board to be solved, return -1.

//Example
//Example 1:
//
//Given board = `[[1,2,3],[4,0,5]]`, return `1`.
//
//Explanation: 
//Swap the 0 and the 5 in one move.

//Example 2：
//
//Given board = `[[1,2,3],[5,4,0]]`, return `-1`.
//
//Explanation: 
//No number of moves will make the board solved.

//Example 3:
//
//Given board = `[[4,1,2],[5,0,3]]`, return `5`.
//
//Explanation: 
//5 is the smallest number of moves that solves the board.
//
//An example path:
//After move 0: [[4,1,2],[5,0,3]]
//After move 1: [[4,1,2],[0,5,3]]
//After move 2: [[0,1,2],[4,5,3]]
//After move 3: [[1,0,2],[4,5,3]]
//After move 4: [[1,2,0],[4,5,3]]
//After move 5: [[1,2,3],[4,5,0]]

//Example 4:
//
//Given board = `[[3,2,4],[1,5,0]]`, return `14`.

//Notice
//board will be a 2 x 3 array as described above.
//board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].




public class Solution {
    /**
     * @param board: the given board
     * @return:  the least number of moves required so that the state of the board is solved
     */
    // Time: O((n*m)!)
    // Space: O((n*m)!)
    public int slidingPuzzle(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String goal = "123450";
        if (start.equals(goal)) {
            return 0;
        }
        
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue.offer(start);                
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int index = curr.indexOf('0');
                int x = index / col;
                int y = index % col;
                
                for (int[] dir : dirs) {
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if (dx < 0 || dx >= row || dy < 0 || dy >= col) {
                        continue;
                    }
                    String temp = swap(curr, index, dx * col + dy);
                    if (visited.contains(temp)) {
                        continue;
                    }
                    if (temp.equals(goal)) {
                        return step;
                    }
                    visited.add(temp);
                    queue.offer(temp);
                }
            }
        }
        return -1;
    }
    
    private String swap(String str, int i, int j) {
        char[] array = str.toCharArray();
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return new String(array);
    }
}



