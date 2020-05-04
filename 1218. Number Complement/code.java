//Given a positive integer, output its complement number. 
//The complement strategy is to flip the bits of its binary representation.

//Example
//Example 1:
//
//Input: 5
//Output: 2
//Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. 
//So you need to output 2.

//Example 2:
//
//Input: 1
//Output: 0
//Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. 
//So you need to output 0.

//Notice
//1.The given integer is guaranteed to fit within the range of a 32-bit signed integer.
//2.You could assume no leading zero bit in the integer’s binary representation.




public class Solution {
    /**
     * @param num: an integer
     * @return: the complement number
     */
    public int findComplement(int num) {
        int todo = num;
        int bit = 1;
        while (todo != 0) {            
            num = num ^ bit;            
            bit = bit << 1;
            todo = todo >> 1;
        }
        return num;        
    }
}



