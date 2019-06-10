//Given k strings, find the longest common prefix (LCP).

//Example
//Example 1:
//	Input:  "ABCD", "ABEF", "ACEF"
//	Output:  "A"	

//Example 2:
//	Input: "ABCDEFG", "ABCEFG" and "ABCEFA"
//	Output:  "ABC"



public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }                
        return pre;
    }    
}



