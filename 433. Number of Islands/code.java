//Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. 
//If two 1 is adjacent, we consider them in the same island. 
//We only consider up/down/left/right adjacent.

//Find the number of islands.

//Example
//Given graph:
//
//  [
//    [1, 1, 0, 0, 0],
//    [0, 1, 0, 0, 1],
//    [0, 0, 0, 1, 1],
//    [0, 0, 0, 0, 0],
//    [0, 0, 0, 0, 1]
//  ]
//
//return 3.


public class Solution {
    public int numIslands(boolean[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    grid[i][j] = false;
                    result++;
                    BFS(grid, i, j);
                }
            }
        }
        return result;
    }

    private void BFS(boolean[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] array = queue.poll();
            int x = array[0];
            int y = array[1];

            if (!outOfBound(grid, x + 1, y) && grid[x + 1][y]) {
                grid[x + 1][y] = false;
                queue.offer(new int[]{x + 1, y});
            }
            if (!outOfBound(grid, x - 1, y) && grid[x - 1][y]) {
                grid[x - 1][y] = false;
                queue.offer(new int[]{x - 1, y});
            }
            if (!outOfBound(grid, x, y + 1) && grid[x][y + 1]) {
                grid[x][y + 1] = false;
                queue.offer(new int[]{x, y + 1});
            }
            if (!outOfBound(grid, x, y - 1) && grid[x][y - 1]) {
                grid[x][y - 1] = false;
                queue.offer(new int[]{x, y - 1});
            }

        }
    }

    private boolean outOfBound(boolean[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        return x < 0 || x >= row || y < 0 || y >= col;
    }
}






public class Solution {
    public int numIslands(boolean[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {                    
                    result++;
                    DFS(grid, i, j);
                }
            }
        }
        return result;
    }

    private void DFS(boolean[][] grid, int i, int j) {
        if (outOfBound(grid, i, j) || !grid[i][j]) {            
            return;
        }    
        
        grid[i][j] = false;                    
        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
    }

    private boolean outOfBound(boolean[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        return x < 0 || x >= row || y < 0 || y >= col;
    }

}



