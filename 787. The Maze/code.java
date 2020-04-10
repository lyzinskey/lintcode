//There is a ball in a maze with empty spaces and walls. 
//The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. 
//When the ball stops, it could choose the next direction.

//Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

//The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. 
//You may assume that the borders of the maze are all walls. 
//The start and destination coordinates are represented by row and column indexes.

//Example
//Example 1:
//
//Input:
//map = 
//  [
//   [0,0,1,0,0],
//   [0,0,0,0,0],
//   [0,0,0,1,0],
//   [1,1,0,1,1],
//   [0,0,0,0,0]
//  ]
//  start = [0,4]
//  end = [3,2]
//Output:
//false

//Example 2:
//
//Input:
//map = 
//  [[0,0,1,0,0],
//   [0,0,0,0,0],
//   [0,0,0,1,0],
//   [1,1,0,1,1],
//   [0,0,0,0,0]
//  ]
//start = [0,4]
//end = [4,4]
//Output:
//true

//Notice
//1.There is only one ball and one destination in the maze.
//2.Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
//3.The given maze does not contain border (like the red rectangle in the example pictures), 
//but you could assume the border of the maze are all walls.
//4.The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.




public class Solution {
    /**
     * @param maze: the maze
     * @param start: the start
     * @param destination: the destination
     * @return: whether the ball could stop at the destination
     */
    // Time: O(mn)
    // Space: O(mn)      
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            
            for (int[] dir : dirs) {
                int dx = curr[0];
                int dy = curr[1];

                while (isValid(maze, dx + dir[0], dy + dir[1])) {
                    dx += dir[0];
                    dy += dir[1];
                }
                
                if (!visited[dx][dy]) {
                    queue.offer(new int[] {dx, dy});
                    visited[dx][dy] = true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }
}



