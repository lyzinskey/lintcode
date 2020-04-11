//Given a string, your task is to count how many palindromic substrings in this string.
//The substrings with different start indexes or end indexes 
//are counted as different substrings even they consist of same characters.

//Example
//Example1
//
//Input: "abc"
//Output: 3
//Explanation:
//3 palindromic strings: "a", "b", "c".

//Example2
//
//Input: "aba"
//Output: 4
//Explanation:
//4 palindromic strings: "a", "b", "a", "aba".

//Notice
//The input string length won't exceed 1000




public class Solution {
    /**
     * @param str: s string
     * @return: return an integer, denote the number of the palindromic substrings
     */
    // loop through every center and expand from center
    // 
    // Time: O(n^2)
    // Space: O(1)
    public int countPalindromicSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            count += extendPalindrome(s, i, i); // odd length;
            count += extendPalindrome(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private int extendPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; 
            left--; 
            right++;
        }
        return count;
    }
}



