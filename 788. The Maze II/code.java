//There is a ball in a maze with empty spaces and walls. 
//The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. 
//When the ball stops, it could choose the next direction.

//Given the ball's start position, the destination and the maze, 
//find the shortest distance for the ball to stop at the destination. 
//The distance is defined by the number of empty spaces traveled by the ball 
//from the start position (excluded) to the destination (included). 
//If the ball cannot stop at the destination, return -1.

//The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. 
//You may assume that the borders of the maze are all walls. 
//The start and destination coordinates are represented by row and column indexes.

//Example
//Example 1:
//	Input:  
//	(rowStart, colStart) = (0,4)
//	(rowDest, colDest)= (4,4)
//	0 0 1 0 0
//	0 0 0 0 0
//	0 0 0 1 0
//	1 1 0 1 1
//	0 0 0 0 0
//
//	Output:  12
//	
//	Explanation:
//	(0,4)->(0,3)->(1,3)->(1,2)->(1,1)->(1,0)->(2,0)->(2,1)->(2,2)->(3,2)->(4,2)->(4,3)->(4,4)

//Example 2:
//	Input:
//	(rowStart, colStart) = (0,4)
//	(rowDest, colDest)= (0,0)
//	0 0 1 0 0
//	0 0 0 0 0
//	0 0 0 1 0
//	1 1 0 1 1
//	0 0 0 0 0
//
//	Output:  6
//	
//	Explanation:
//	(0,4)->(0,3)->(1,3)->(1,2)->(1,1)->(1,0)->(0,0)
	
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
     * @return: the shortest distance for the ball to stop at the destination
     */
    // loop through every node in matrix
    // for every current node chosen, we can travel upto a maximum depth of max(m,n) in any direction
    //
    // Time: O(mn * max(m, n))
    // Space: O(mn)  
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int row = maze.length;
        int col = maze[0].length;
        int[][] distance = new int[row][col];
        for (int[] rows : distance) {
            Arrays.fill(rows, Integer.MAX_VALUE);
        }

        distance[start[0]][start[1]] = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] coor = queue.poll();
            for (int[] dir : dirs) {
                int dx = coor[0];
                int dy = coor[1];
                int count = 0;

                while (isValid(maze, dx + dir[0], dy + dir[1])) {
                    dx += dir[0];
                    dy += dir[1];
                    count++;
                }

                if (distance[coor[0]][coor[1]] + count < distance[dx][dy]) {
                    distance[dx][dy] = distance[coor[0]][coor[1]] + count;
                    queue.add(new int[]{dx, dy});
                }
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }    
}



