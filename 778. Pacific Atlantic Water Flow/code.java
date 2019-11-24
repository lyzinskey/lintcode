//Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, 
//the "Pacific ocean" touches the left and top edges of the matrix 
//and the "Atlantic ocean" touches the right and bottom edges.

//Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

//Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

//Example
//Example 1:
//
//Input:
//matrix = 
//[[1,2,2,3,5],
//[3,2,3,4,4],
//[2,4,5,3,1],
//[6,7,1,4,5],
//[5,1,1,2,4]]
//
//Output:
//[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//
//Explanation:
//Pacific ~ ~ ~ ~ ~
//      ~ 1 2 2 3 5 *
//      ~ 3 2 3 4 4 *
//      ~ 2 4 5 3 1 *
//      ~ 6 7 1 4 5 *
//      ~ 5 1 1 2 4 *
//        * * * * * Atlantic

//Example 2:
//
//Input:
//matrix =
//[[1,2],
//[4,3]]
//
//Output:
//[[0,1],[1,0],[1,1]]

//Notice
//1.The order of returned grid coordinates does not matter.
//2.Both m and n are less than 150.




public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: The list of grid coordinates
     */
    
    // Time: O(mn + (m + n))
    // Space: O(mn)
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        Deque<int[]> pacific = new ArrayDeque<>();
        Deque<int[]> atlantic = new ArrayDeque<>();
        boolean[][] visitedP = new boolean[row][col];
        boolean[][] visitedA = new boolean[row][col];
        
        // add border row
        for (int i = 0; i < col; i++) {
            pacific.offerLast(new int[] {0, i});
            visitedP[0][i] = true;
            atlantic.offerLast(new int[] {row - 1, i});
            visitedA[row - 1][i] = true;
        }

        // add border col
        for (int i = 0; i < row; i++) {
            pacific.offerLast(new int[] {i, 0});
            visitedP[i][0] = true;
            atlantic.offerLast(new int[] {i, col - 1});
            visitedA[i][col - 1] = true;
        }

        bfs(pacific, visitedP, matrix, row, col);
        bfs(atlantic, visitedA, matrix, row, col);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visitedA[i][j] && visitedP[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void bfs(Deque<int[]> ocean, boolean[][] visited, int[][] matrix, int row, int col) {
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!ocean.isEmpty()) {
            int[] node = ocean.pollFirst();
            int x = node[0];
            int y = node[1];
            for (int[] dir : dirs) {
                int dx = x + dir[0];
                int dy = y + dir[1];
                if (isValid(dx, dy, row, col) && matrix[dx][dy] >= matrix[x][y] && !visited[dx][dy]) {
                    ocean.offerLast(new int[] {dx, dy});
                    visited[dx][dy] = true;
                }
            }           
        }
    }

    private boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}



