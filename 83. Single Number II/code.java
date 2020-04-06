//Given 3*n + 1 non-negative integer, every numbers occurs triple times except one, find it.

//Example
//Example 1:
//
//Input:  [1,1,2,3,3,3,2,2,4,1]
//Output:  4

//Example 2:
//
//Input: [2,1,2,2]
//Output:  1	

//Challenge
//One-pass, constant extra space.




public class Solution {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumberII(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // first appearence: 
            // add num to seen_once 
            // don't add to seen_twice because of presence in seen_once

            // second appearance: 
            // remove num from seen_once 
            // add num to seen_twice

            // third appearance: 
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }    
}



