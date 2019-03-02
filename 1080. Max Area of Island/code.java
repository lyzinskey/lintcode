//Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
//connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

//Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
//
//Example
//Example 1:
//
//[[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

//Example 2:
//
//[[0,0,0,0,0,0,0,0]]
//Given the above grid, return 0.

//Notice
//The length of each dimension in the given grid does not exceed 50.





public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int[] res = new int[1];
        
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int[] cur = new int[1];                    
                    DFS(grid, i, j, cur);  
                    res[0] = Math.max(cur[0], res[0]);
                }
            }
        }
        return res[0];
    }
    
    private void DFS(int[][] grid, int x, int y, int[] cur) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }
        
        grid[x][y] = 0;
        cur[0]++;
        
        DFS(grid, x + 1, y, cur);
        DFS(grid, x - 1, y, cur);
        DFS(grid, x, y + 1, cur);
        DFS(grid, x, y - 1, cur);
    }    
}


