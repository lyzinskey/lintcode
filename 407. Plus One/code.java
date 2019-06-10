//Given a non-negative number represented as an array of digits, plus one to the number.

//The digits are stored such that the most significant digit is at the head of the list.

//Example
//Example 1:
//
//Input: [1,2,3]
//Output: [1,2,4]

//Example 2:
//
//Input: [9,9,9]
//Output: [1,0,0,0]



public class Solution {
    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {      
            if (i == digits.length - 1) {
                if (digits[i] != 9) {
                    digits[i]++;
                } else {
                    carry = 1;
                    digits[i] = 0;
                }        
            } else {
                digits[i] = digits[i] + carry;
                if (digits[i] == 10) {
                    digits[i] = 0;
                    carry = 1;
                } else {
                    carry = 0;
                }
            }      
        }
        if (carry == 1) {
            return lengthPlus(digits);
        }
        return digits;
    }

    public int[] lengthPlus(int[] digits) {
        int[] longer = new int[digits.length + 1];
        longer[0] = 1;
        return longer;
    }    
}



