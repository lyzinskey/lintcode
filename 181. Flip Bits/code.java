//Determine the number of bits required to flip if you want to convert integer n to integer m.

//Both n and m are 32-bit integers.

//Example
//Given n = 31 (11111), m = 14 (01110), return 2.





public class Solution {
    public int bitSwapRequired(int a, int b) {
        int bit = 0;
        
        for (int c = a ^ b; c != 0; c >>>= 1) {
            bit += c & 1;
        }
        return bit;
    }
}



