//  A message containing letters from A-Z is being encoded to numbers using the following mapping:

//  'A' -> 1
//  'B' -> 2
//  ...
//  'Z' -> 26
//  Given an encoded message containing digits, determine the total number of ways to decode it.

//  Example
//  Example 1:
//  
//  Input: "12"
//  Output: 2
//  Explanation: It could be decoded as AB (1 2) or L (12).

//  Example 2:
//  
//  Input: "10"
//  Output: 1



public class Solution {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int prev = 1;
        int cur = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int next = 0;
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                next += cur;
            }
            if (second >= 10 && second <= 26) {
                next += prev;
            }            
            prev = cur;
            cur = next;
        }
        return cur;
    }
}



