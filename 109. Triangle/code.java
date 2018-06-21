//Given a triangle, find the minimum path sum from top to bottom. 
//Each step you may move to adjacent numbers on the row below.

//Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

//Example
//Given the following triangle:
//  
//  [
//       [2],
//      [3,4],
//     [6,5,7],
//    [4,1,8,3]
//  ]
//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).



public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    
    private int row; 
    private int[][] minSum;
    private int[][] triangle;
     
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0 || triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        
        this.row = triangle.length;
        this.triangle = triangle;
        this.minSum = new int[row][row];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }
        
        return search(0, 0);
    }
    
    private int search(int x, int y) {
        if (x >= row) {
            return 0;
        }
        
        if (minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }
        
        minSum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1)) + triangle[x][y];
        
        return minSum[x][y];
    }
}

