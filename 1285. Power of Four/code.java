//Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

//Example
//
//Example1:
//Given num = 16, 
//return true.
//
//Example2:
//
//Given num = 5, 
//return false.

//Challenge
//Could you solve it without loops/recursion?



public class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;        
    }    
}



