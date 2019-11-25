//Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

//B.length >= 3
//There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
//(Note that B could be any subarray of A, including the entire array A.)
//Given an array A of integers, return the length of the longest mountain.

//Return 0 if there is no mountain.

//Example
//Example 1:
//
//Input: [2,1,4,7,3,2,5]
//Output: 5
//Explanation: The largest mountain is [1,4,7,3,2] which has length 5.

//Example 2:
//
//Input: [2,2,2]
//Output: 0
//Explanation: Explanation: There is no mountain.

//Challenge
//Can you solve it using only one pass?
//Can you solve it in O(1) space?

//Notice
//0 <= A.length <= 10000
//0 <= A[i] <= 10000




public class Solution {
    /**
     * @param A: 
     * @return: the length of the longest mountain
     */
    public int longestMountain(int[] A) {
        int left = 0;
        int right = 0;
        int result = 0;
        
        while (right < A.length) {  
            right = left;
            if (right + 1 < A.length && A[right] < A[right + 1]) {
                while (right + 1 < A.length && A[right] < A[right + 1]) {
                    right++;
                }
                if (right + 1 < A.length && A[right] > A[right + 1]) {
                    while (right + 1 < A.length && A[right] > A[right + 1]) {
                        right++;
                    }
                    result = Math.max(result, right - left + 1);    
                }
            }
            left = Math.max(right, left + 1);
        }
        return result;
    }
}



