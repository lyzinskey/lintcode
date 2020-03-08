//Given a string containing only three types of characters: '(', ')' and '*', 
//write a function to check whether this string is valid. We define the validity of a string by these rules:

//Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//Any right parenthesis ')' must have a corresponding left parenthesis '('.
//Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
//An empty string is also valid.

//Example
//Example 1:
//	Input:  "()"
//	Output:  true
	
//Example 2:
//	Input: "(*)"
//	Output:  true
//	
//	Explanation:
//	'*' is empty.
	
//Example 3:
//	Input: "(*))"
//	Output: true
//	
//	Explanation:
//	use '*' as '('.

//Notice
//The string size will be in the range [1, 100].




public class Solution {
    /**
     * @param s: the given string
     * @return: whether this string is valid
     */
    // We count the number of ')' we are waiting for,
    // and it's equal to the number of open parenthesis.
    // This number will be in a range and we count it as [cmin, cmax]
    //
    // cmax counts the maximum open parenthesis,
    // which means the maximum number of unbalanced '(' that COULD be paired.
    // cmin counts the minimum open parenthesis,
    // which means the number of unbalanced '(' that MUST be paired.
    //
    // The string is valid for 2 condition:
    // cmax will never be negative.
    //cmin is 0 at the end.
    // 
    // Time: O(n)
    // Space: O(1)
    public boolean checkValidString(String s) {
        int cmin = 0, cmax = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin = Math.max(cmin - 1, 0);
            } else {
                cmax++;
                cmin = Math.max(cmin - 1, 0);
            }
            if (cmax < 0) return false;
        }
        return cmin == 0;
    }    
}



