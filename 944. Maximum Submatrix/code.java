//Given an n x n matrix of positive and negative integers, find the submatrix with the largest possible sum.

//Example
//Given matrix = 
//  [
//  [1,3,-1],
//  [2,3,-2],
//  [-1,-2,-3]
//  ]
//return 9.
//Explanation:
//the submatrix with the largest possible sum is:
//  [
//  [1,2],
//  [2,3]
//  ]



//枚举子矩阵的上下边界 up & down, 然后将这之间的数压缩为一个一维数组，剩下的任务就是一维数组如何求 Maximum Subarray 了。
//
public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: the largest possible sum
     */
     
    int m, n;
    
    public int maxSubmatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        n = matrix.length;
        m = matrix[0].length;

        int[][] prefixColSum = getPrefixColSum(matrix);

        int max = Integer.MIN_VALUE;
        for (int up = 0; up < n; up++) {
            for (int down = up; down < n; down++) {
                int[] arr = compression(matrix, up, down, prefixColSum);
                max = Math.max(max, maximumSubarray(arr));
            }
        }

        return max;
    }

    private int maximumSubarray(int[] arr) {
        int min = 0, max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < m; i++) {
            sum += arr[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }

        return max;
    }

    private int[] compression(int[][] matrix, int up, int down, int[][] prefixColSum) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = prefixColSum[down + 1][i] - prefixColSum[up][i];
        }

        return arr;
    }

    private int[][] getPrefixColSum(int[][] matrix) {
        int[][] sum = new int[n + 1][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i + 1][j] = sum[i][j] + matrix[i][j];
            }
        }

        return sum;
    }
}





// solution 2: DP
//
public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: the largest possible sum
     */
    
    public int maxSubmatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int global_max = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            int[] largestSum = new int[col];

            for (int j = i; j < row; j++) {
                compression(largestSum, matrix[j]);
                global_max = Math.max(global_max, largestSum(largestSum));
            }
        }
        return global_max;
    }

    private void compression(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            a[i] += b[i];
        }
    }

    private int largestSum(int[] array) {
        int last = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            last = Math.max(last + array[i], array[i]);
            max = Math.max(max, last);
        }
        return max;
    }
}



