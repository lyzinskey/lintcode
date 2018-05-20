//Write an efficient algorithm that searches for a value in an m x n matrix.

//This matrix has the following properties:

//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
//Example
//Consider the following matrix:
//        [1, 3, 5, 7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 50]
//Given target = 3, return true.


    //    O(log(n) + log(m)) time
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        int end = row * column - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / column][mid % column] == target) {
                return true;
            } else if (matrix[mid / column][mid % column] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        int mid = start + (end - start) / 2;
        if (matrix[mid / column][mid % column] == target) {
            return true;
        }
        return false;
    }
