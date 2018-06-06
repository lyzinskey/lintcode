//Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, 
//find the shortest path to a destination position, return the length of the route.
//Return -1 if knight can not reached.

//Source and destination must be empty.
//Knight can not enter the barrier.

//Clarification
//If the knight is at (x, y), he can get to the following positions in one step:
//
//(x + 1, y + 2)
//(x + 1, y - 2)
//(x - 1, y + 2)
//(x - 1, y - 2)
//(x + 2, y + 1)
//(x + 2, y - 1)
//(x - 2, y + 1)
//(x - 2, y - 1)

//Example
//  [[0,0,0],
//   [0,0,0],
//   [0,0,0]]
//source = [2, 0] destination = [2, 2] return 2
//
//  [[0,1,0],
//   [0,0,0],
//   [0,0,0]]
//source = [2, 0] destination = [2, 2] return 6
//
//  [[0,1,0],
//   [0,0,1],
//   [0,0,0]]
//source = [2, 0] destination = [2, 2] return -1


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }

        int step = 0;
        int[] xStep = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] yStep = {2, -2, 2, -2, 1, -1, 1, -1};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curr = queue.poll();
                if (curr.x == destination.x && curr.y == destination.y){
                    return step;
                }
                for (int j = 0; j < 8; j++) {
                    Point nextStep = new Point(curr.x + xStep[j], curr.y + yStep[j]);
                    if (validPoint(grid, nextStep)){
                        queue.offer(nextStep);
                        grid[nextStep.x][nextStep.y] = true;
                    }
                }
            }
            step++;
        }

        return -1;
    }
    
    private boolean validPoint(boolean[][] grid, Point point){
        int row = grid.length;
        int column = grid[0].length;

        if (point.x < 0 || point.x >= row){
            return false;
        }
        if (point.y < 0 || point.y >= column){
            return false;
        }
        if (grid[point.x][point.y]){
            return false;
        }
        return true;
    }    
}

