//Given a positive integer num, write a function which returns True if num is a perfect square else False.

//Example
//Example1:
//
//Input: num = 16
//Output: True
//Explanation:
//sqrt(16) = 4

//Example2:
//
//Input: num = 15
//Output: False
//Explanation:
//sqrt(15) = 3.87

//Notice
//Do not use any built-in library function such as sqrt.




public class Solution {
    /**
     * @param num: a positive integer
     * @return: if num is a perfect square else False
     */
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;        
    }
}



