//Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

//Example
//Example 1:
//	Input:  nums = [1,0,1,1,0]
//	Output:  4
//	
//	Explanation:
//	Flip the first zero will get the the maximum number of consecutive 1s.
//	After flipping, the maximum number of consecutive 1s is 4.

//Example 2:
//	Input: nums = [1,0,1,0,1]
//	Output:  3
//	
//	Explanation:
//	Flip each zero will get the the maximum number of consecutive 1s.
//	After flipping, the maximum number of consecutive 1s is 3.
	
//Notice
//The input array will only contain 0 and 1.
//The length of input array is a positive integer and will not exceed 10,000.




public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        return longestOnes(nums, 1);
    }
    public int longestOnes(int[] A, int K) {
        int i = 0;
        int j = 0;
        for (; j < A.length; ++j) {
            if (A[j] == 0) {
                K--;
            }
            if (K < 0 && A[i++] == 0) {
                K++;
            }
        }
        return j - i;
    }
}



