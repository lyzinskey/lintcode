//The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

//Now your job is to find the total Hamming distance between all pairs of the given numbers.

//Example
//Example 1:
//
//Input: [4, 14, 2]
//Output: 6
//Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
//showing the four bits relevant in this case). So the answer will be:
//HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

//Example 2:
//
//Input: [2, 1, 0]
//Output: 4
//Explanation: In binary representation, the 2 is 10, 1 is 01, and 0 is 00 (just
//showing the four bits relevant in this case). So the answer will be:
//HammingDistance(2, 1) + HammingDistance(1, 0) + HammingDistance(2, 0) = 2 + 1 + 1 = 4.

//Notice
//Elements of the given array are in the range of 0 to 10^9
//Length of the array will not exceed 10^4.




public class Solution {
    /**
     * @param nums: the gievn integers
     * @return: the total Hamming distance between all pairs of the given numbers
     */
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += (nums[j] >> i) & 1;
            }
            result += count * (nums.length - count);
        }
        return result;
    }
}




