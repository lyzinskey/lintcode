//Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.

//You can change the order of numbers in array

//Example
//Given N = 3 and the array [0, 1, 3], return 2.

//Challenge
//Do it in-place with O(1) extra memory and O(n) time.


public class Solution {
    public int findMissing(int[] nums) {
        int xor = 0;
        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }

        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        return xor;
    }
}


