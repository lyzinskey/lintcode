//Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). 
//Originally, the 2D matrix is all 0 which means there is only sea in the matrix. 
//The list pair has k operator and each operator has two integer A[i].x, A[i].y 
//means that you can change the grid matrix[A[i].x][A[i].y] from sea to island. 
//Return how many island are there in the matrix after each operator.

//Example
//Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].
//return [1,1,2,2].

//Notice
//0 is represented as the sea, 1 is represented as the island. 
//If two 1 is adjacent, we consider them in the same island. 
//We only consider up/down/left/right adjacent.





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
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, Point[] operators) {
        List<Integer> result = new ArrayList<>();
        if (m <= 1 || n <= 1 || operators.length == 0) {
            return result;
        }
        
        int counter = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        
        for (int i = 0; i < operators.length; i++) {
            if (i > 0 && operators[i].x == operators[i - 1].x && operators[i].y == operators[i - 1].y) {
                result.add(counter);
                continue;
            }
            
            int root = n * operators[i].x + operators[i].y;
            roots[root] = root;
            counter++;
            
            for (int[] dir : dirs) {
                int x = operators[i].x + dir[0]; 
                int y = operators[i].y + dir[1];
                int nb = n * x + y;
                if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) {
                    continue;
                }
            
                int rootNb = findRoot(roots, nb);
                if(root != rootNb) {
                    roots[root] = rootNb;
                    root = rootNb;
                    counter--;         
                }
            }
            
            result.add(counter);
        }
        return result;
    }
    
    private int findRoot(int[] roots, int id) {
        while (id != roots[id]) {
            id = roots[id];
        }
        return id;
    }    
}



