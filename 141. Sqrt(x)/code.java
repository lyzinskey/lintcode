//Implement int sqrt(int x).

//Compute and return the square root of x.

//Example
//Example 1:
//	Input:  0
//	Output: 0

//Example 2:
//	Input:  3
//	Output: 1	
//	Explanation:
//	return the largest integer y that y*y <= x. 
	
//Example 3:
//	Input:  4
//	Output: 2

//Challenge
//O(log(x))



public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        
        int left = 1;
        int right = Integer.MAX_VALUE;
        
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
    }
}



