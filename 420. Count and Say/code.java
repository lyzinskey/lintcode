//The count-and-say sequence is the sequence of integers beginning as follows:

//1, 11, 21, 1211, 111221, ...
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.

//Given an integer n, generate the nth sequence.

//Example
//Example 1:
//
//Input: 1
//Output: "1"

//Example 2:
//
//Input: 5
//Output: "111221"

//Notice
//The sequence of integers will be represented as a string.



public class Solution {
    /**
     * @param n: the nth
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = build(result);
        }
        return result;
    }
    
    private String build(String input) {
        int pointer = 0;
        StringBuilder sb = new StringBuilder();
        
        while (pointer < input.length()) {
            int counter = 0;
            char ch = input.charAt(pointer);
            while (pointer < input.length() && input.charAt(pointer) == ch) {
                pointer++;
                counter++;
            }
            sb.append(String.valueOf(counter));
            sb.append(ch);
        }
        return sb.toString();
    }
}



