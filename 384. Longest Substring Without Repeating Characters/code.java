//Given a string, find the length of the longest substring without repeating characters.

//Example
//For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
//
//For "bbbbb" the longest substring is "b", with the length of 1.

//Challenge
//O(n) time



public class Solution {
    public int lengthOfLongestSubstring(String input) {  
        if (input.isEmpty()) {
            return 0;
        }
    
        int slow = 0; 
        int fast = 0;
        int maxLength = 0;
        Set<Character> hashset = new HashSet<>();
    
        while (fast < input.length()) {
            if (!hashset.contains(input.charAt(fast))) {
                hashset.add(input.charAt(fast++));
                maxLength = Math.max(maxLength, fast - slow);
            }
            else {
                hashset.remove(input.charAt(slow++));        
            }
        }
    
        return maxLength;
    }
}



