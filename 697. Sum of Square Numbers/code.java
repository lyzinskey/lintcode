//Given a integer c, your task is to decide whether there're two integers a and b such that a^2 + b^2 = c.

//Example
//Given n = 5
//Return true // 1 * 1 + 2 * 2 = 5

//Given n = -5
//Return false




public class Solution {

    public boolean checkSumOfSquareNumbers(int num) {
        if (num < 0) {
            return false;
        }
        
        for (long a = 0; a * a <= num; a++) {
            int b = num - (int) (a * a);
            if (binarySearch(b, 0, b)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean binarySearch(int target, long start, long end) {
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == target) {
                return true;
            }
            else if (mid * mid > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return false;
    }
}


