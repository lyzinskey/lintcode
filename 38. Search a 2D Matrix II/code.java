//Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

//This matrix has the following properties:

//Integers in each row are sorted from left to right.
//Integers in each column are sorted from up to bottom.
//No duplicate integers in each row or column.
//Example
//Consider the following matrix:
//        [1, 3, 5, 7],
//        [2, 4, 7, 8],
//        [3, 5, 9, 10]
//Given target = 3, return 2.
    
    
    //    O(m+n) time and O(1) extra space
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }

        // start searching from the left bottom
        int counter = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int x = row - 1;
        int y = 0;

//        Example:
//        [1, 3, 5, 7],
//        [2, 4, 7, 8],
//        [3, 5, 9, 10]
//        start searching 5 from left bottom
        
//        After 1st searching:
//        [3, 5, 7],
//        [4, 7, 8],
//        [5, 9, 10]
//        counter = 0

//        After 2nd searching:
//        [5, 7],
//        [7, 8],
//        counter = 1

//        After 3rd searching:
//        [5, 7],
//        counter = 1  

//        After 4th searching:
//        [7],
//        counter = 2  
        
        while (x >= 0 && y <= column - 1){
            if (matrix[x][y] < target){
                y++;
            }
            else if (matrix[x][y] > target){
                x--;
            }
            else {
                counter++;
                x--;
                y++;
            }
        }
        return counter;
    }
