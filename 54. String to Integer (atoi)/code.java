//Implement function atoi to convert a string to an integer.

//If no valid conversion could be performed, a zero value is returned.

//If the correct value is out of the range of representable values, 
//INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

//Example
//Example 1
//
//Input: "10"
//Output: 10

//Example 2
//
//Input: "1"
//Output: 1

//Example 3
//
//Input: "123123123123123"
//Output: 2147483647
//Explanation: 123123123123123 > INT_MAX, so we return INT_MAX

//Example 4
//
//Input: "1.0"
//Output: 1
//Explanation: We just need to change the first vaild number



public class Solution {
    /**
     * @param str: A string
     * @return: An integer
     */
    public int atoi(String str) {
        int sign = 1, base = 0, i = 0, INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }        
        if (i >= str.length()) {
            return 0;
        }        
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') sign = -1;
            i++;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > INT_MAX / 10 || (base == INT_MAX / 10 && str.charAt(i) - '0' > INT_MAX % 10)) {
                if (sign == -1) {
                    return INT_MIN;
                } else {
                    return INT_MAX;
                }
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }        
        return base * sign;        
    }    
}



