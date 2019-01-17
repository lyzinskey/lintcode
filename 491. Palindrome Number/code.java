//Check a positive number is a palindrome or not.

//A palindrome number is that if you reverse the whole number you will get exactly the same number.

//It's guaranteed the input number is a 32-bit integer, but after reversion, the number may exceed the 32-bit integer.

//Example
//11, 121, 1, 12321 are palindrome numbers.
//23, 32, 1232 are not palindrome numbers.




// Solution 1: integer to string
class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);

        int headCount = 0;
        int tailCount = s.length() - 1;
        char head;
        char tail;

        while (headCount <= tailCount){
            head = s.charAt(headCount);
            tail = s.charAt(tailCount);
                
            if (Character.toLowerCase(head) != Character.toLowerCase(tail)){
                return false;
            }
            headCount++;
            tailCount--;
        }
        return true;        
    }
}




// Solution 2: reverse integer
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        
        int result = 0;
        
        while (result < x) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        
        return result == x || result / 10 == x;
    }
}



