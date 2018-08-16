//Give an integer array，find the longest increasing continuous subsequence in this array.

//An increasing continuous subsequence:

//Can be from right to left or from left to right.
//Indices of the integers in the subsequence should be continuous.

//Example
//For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
//For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.

//Challenge
//O(n) time and O(1) extra space.



public class Solution {
    public int longestIncreasingContinuousSubsequence(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }        
        
        int left = leftToRight(array);
        int right = rightToLeft(array);
        return Math.max(left, right);
    }
    
    private int leftToRight(int[] array) {
        int curr = 1;
        int global_max = 1;
    
        for (int i = 1; i < array.length; i++) {
        if (array[i] > array[i - 1]) {
            curr++;
        }
        else {
            curr = 1;
        }
      
        global_max = Math.max(global_max, curr);
        }
    
        return global_max;         
    }
    
    private int rightToLeft(int[] array) {
        int curr = 1;
        int global_max = 1;
    
        for (int i = 1; i < array.length; i++) {
        if (array[i] < array[i - 1]) {
            curr++;
        }
        else {
            curr = 1;
        }
      
        global_max = Math.max(global_max, curr);
        }
    
        return global_max;         
    }    
}



