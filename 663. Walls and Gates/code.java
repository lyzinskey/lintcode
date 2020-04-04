//You are given a m x n 2D grid initialized with these three possible values.

//-1 - A wall or an obstacle.
//0 - A gate.
//INF - Infinity means an empty room. 
//We use the value 2^31 - 1 = 2147483647 to represent INF 
//as you may assume that the distance to a gate is less than 2147483647.
//Fill each empty room with the distance to its nearest gate. 
//If it is impossible to reach a Gate, that room should remain filled with INF

//Example
//Example1
//
//Input:
//[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],
//[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
//Output:
//[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
//
//Explanation:
//the 2D grid is:
//INF  -1  0  INF
//INF INF INF  -1
//INF  -1 INF  -1
//  0  -1 INF INF
//the answer is:
//  3  -1   0   1
//  2   2   1  -1
//  1  -1   2  -1
//  0  -1   3   4

//Example2
//
//Input:
//[[0,-1],[2147483647,2147483647]]
//Output:
//[[0,-1],[1,2]]




public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    // Time: O(mn)
    // Space: O(mn)     
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();    
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                for (int[] dir : dirs) {
                    int dx = node[0] + dir[0];
                    int dy = node[1] + dir[1];
                    if (dx < 0 || dx >= row || dy < 0 || dy >= col || rooms[dx][dy] >= -1 && rooms[dx][dy] != Integer.MAX_VALUE) {
                        continue;
                    }
                    rooms[dx][dy] = step;
                    queue.offer(new int[] {dx, dy});
                }
            }
        }
    }    
}



