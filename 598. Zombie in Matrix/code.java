//Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).
//Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall. 
//How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.

//Example
//Given a matrix:
//
//  0 1 2 0 0
//  1 0 0 2 1
//  0 1 0 0 0
//
//return 2


public class Solution {
    /**
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};

        // initialize the queue & count people
        int people = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 0) {
                    people++;
                } else if (grid[i][j] == 1) {
                    queue.offer(new Coordinate(i, j));
                }
            }
        }

        // corner case
        if (people == 0) {
            return 0;
        }

        // bfs
        int days = 0;
        while (!queue.isEmpty()) {
            days++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate zb = queue.poll();
                for (int direction = 0; direction < 4; direction++) {
                    Coordinate adj = new Coordinate(zb.x + x[direction], zb.y + y[direction]);

                    if (!isPeople(adj, grid)) {
                        continue;
                    }

                    grid[adj.x][adj.y] = 1;
                    people--;
                    
                    if (people == 0) {
                        return days;
                    }
                    
                    queue.offer(adj);
                }
            }
        }

        return -1;
    }

    private boolean isPeople(Coordinate coor, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (coor.x < 0 || coor.x >= n) {
            return false;
        }
        if (coor.y < 0 || coor.y >= m) {
            return false;
        }
        return (grid[coor.x][coor.y] == 0);
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

