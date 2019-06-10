//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
//return the length of last word in the string.

//If the last word does not exist, return 0.

//Example
//Example 1:
//
//Input: "Hello World"
//Output: 5

//Example 2:
//
//Input: "Hello LintCode"
//Output: 8

//Notice
//A word is defined as a character sequence consists of non-space characters only.



public class Solution {
    /**
     * @param s: A string
     * @return: the length of last word
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] split = s.split(" ");
        if (split.length == 0) {
            return 0;
        }
        return split[split.length - 1].length();
    }
}



