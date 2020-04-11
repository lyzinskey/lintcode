//Given a string S, find the length of the longest substring T that contains at most k distinct characters.

//Example
//Example 1:
//
//Input: S = "eceba" and k = 3
//Output: 4
//Explanation: T = "eceb"

//Example 2:
//
//Input: S = "WORLD" and k = 4
//Output: 4
//Explanation: T = "WORL" or "ORLD"

//Challenge
//O(n) time




public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    // Time: O(n)
    // Space: O(1)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0;
        int res = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (count[ch] == 0) {
                num++;
            }
            count[ch]++;
            
            if (num > k) {                
                while (num > k) {                    
                    count[s.charAt(left)]--;
                    if (count[s.charAt(left)] == 0) {
                        num--;
                    }
                    left++;
                }
            }
            res = Math.max(res, right - left + 1);            
        }
        return res;
    }        
}



