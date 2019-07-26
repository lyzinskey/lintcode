//Given 2 * n + 1 numbers, every numbers occurs twice except one, find it.

//Example
//Example 1:
//
//Input：[1,1,2,2,3,4,4]
//Output：3
//Explanation:
//Only 3 appears once

//Example 2:
//
//Input：[0,0,1]
//Output：1
//Explanation:
//Only 1 appears once

//Challenge
//One-pass, constant extra space.



public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {
        int result = 0;
        for (int num : A) {
            result ^= num;
        }
        return result;
    }
}



