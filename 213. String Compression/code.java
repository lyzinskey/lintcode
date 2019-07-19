//Implement a method to perform basic string compression using the counts of repeated characters. 
//For example, the string aabcccccaaa would become a2b1c5a3.

//If the "compressed" string would not become smaller than the original string, 
//your method should return the original string.

//You can assume the string has only upper and lower case letters (a-z).

//Example
//Example 1:
//
//Input: str = "aabcccccaaa"
//Output: "a2b1c5a3"

//Example 2:
//
//Input: str = "aabbcc"
//Output: "aabbcc"




public class Solution {
    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public String compress(String originalString) {
        if (originalString == null || originalString.length() == 0) {
            return "";
        }
        
        int fast = 0;
        int slow = 0;
        StringBuilder sb = new StringBuilder();
        
        while (fast < originalString.length()) {
            char ch = originalString.charAt(fast);
            int count = 0;
            while (fast < originalString.length() && originalString.charAt(fast) == ch) {
                fast++;
                count++;
            }
            sb.append(originalString.charAt(slow));
            String num = String.valueOf(count);
            sb.append(num);
            slow = fast;
        }
        return originalString.length() > sb.length() ? sb.toString() : originalString;
    }
}



