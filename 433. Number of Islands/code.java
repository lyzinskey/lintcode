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
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        int island = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j]){
                    island++;
                    BFS(grid, i, j);
                }
            }
        }
        return island;
    }
    
    private void BFS(boolean[][] grid, int n, int m){
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(n, m));
        grid[n][m] = false;

        while (!queue.isEmpty()){
            Coordinate coor = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate child = new Coordinate(coor.x + x[i], coor.y + y[i]);

                if (OutOfBound(grid, child)){
                    continue;
                }

                if (grid[child.x][child.y]){
                    grid[child.x][child.y] = false;
                    queue.offer(child);
                }
            }
        }
    }

    private boolean OutOfBound(boolean[][] grid, Coordinate coor){
        int row = grid.length;
        int column = grid[0].length;
        return coor.x < 0 || coor.x >= row || coor.y < 0 || coor.y >=column;
    }
    
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

