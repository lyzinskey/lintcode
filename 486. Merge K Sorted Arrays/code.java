//Given k sorted integer arrays, merge them into one sorted array.

//Example
//Given 3 sorted arrays:

//  [
//    [1, 3, 5, 7],
//    [2, 4, 6],
//    [0, 8, 9, 10, 11]
//  ]
//return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

//Challenge
//Do it in O(N log k).
//
//N is the total number of integers.
//k is the number of arrays.



public class Solution {

    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new int[] {};
        }
        
        int end = arrays.length - 1;
        while (end > 0) {
    		int count = 0, i = 0;
            while (i <= end - 1) {
                arrays[count++] = mergeTwo(arrays[i], arrays[i + 1]);
                i += 2;
            }
            if (i == end) {
                arrays[count++] = arrays[i];
            }
            end = count - 1;
        }
        return arrays[0];
    }
    
    private int[] mergeTwo(int[] a, int[] b) {
        int left = 0;
        int right = 0;
        int[] result = new int[a.length + b.length];
        int index = 0;
        
        while (left < a.length && right < b.length) {
            if (a[left] < b[right]) {
                result[index++] = a[left++];
            }
            else {
                result[index++] = b[right++];
            }
        }
        
        while (left < a.length) {
            result[index++] = a[left++];
        }
        while (right < b.length) {
            result[index++] = b[right++];
        }
        
        return result;
    }    
}


