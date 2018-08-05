//Write a function that takes an unsigned integer 
//and returns the number of ’1' bits it has (also known as the Hamming weight).

//Example
//For example, the 32-bit integer 11 has binary representation 00000000000000000000000000001011, 
//so the function should return 3.



public class Solution {
    public int hammingWeight(int n) {
        int bit = 0;
        
        while (n > 0) {
            bit += (n & 1);
            n >>= 1;
        }
        
        return bit;
    }
}



