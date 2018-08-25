//Given an integer n, return a spiral array of n * n sizes.

//Example
//
//Example1:
//Given n = 3
//the spiral array is:
//
//  [
//  [1,2,3]
//  [8,9,4]
//  [7,6,5]
//  ]

//Example2:
//Given n = 5
//the spiral array is:
//
//  [
//   [1,2,3,4,5]
//   [16,17,18,19,6]
//   [15,24,25,20,7]
//   [14,23,22,21,8]
//   [13,12,11,10,9]
//  ]




public class Solution {
    public int[][] spiralArray(int n) {
        int[][] matrix = new int[n][n];
        DFS(matrix, 0, matrix.length, 1);
        return matrix;
    }

    private void DFS(int[][] matrix, int offset, int size, int counter) {
        if (size <= 1) {
            if (size == 1) {
                matrix[offset][offset] = counter;
            }
            return;
        }

        for (int i = 0; i < size; i++) {
            matrix[offset][i + offset] = counter++;
        }
        for (int i = 1; i < size - 1; i++) {
            matrix[offset + i][offset + size - 1] = counter++;
        }
        for (int i = size - 1; i >= 0; i--) {
            matrix[offset + size - 1][i + offset] = counter++;
        }
        for (int i = size - 2; i >= 1; i--) {
            matrix[i + offset][offset] = counter++;
        }

        DFS(matrix, offset + 1, size - 2, counter);
    }    
}



