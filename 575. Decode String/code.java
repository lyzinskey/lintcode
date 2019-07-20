//Given an expression s contains numbers, letters and brackets. 
//Number represents the number of repetitions inside the brackets(can be a string or another expression)．
//Please expand expression to be a string.

//Example
//Example1
//
//Input: S = abc3[a]
//Output: "abcaaa"

//Example2
//
//Input: S = 3[2[ad]3[pf]]xyz
//Output: "adadpfpfpfadadpfpfpfadadpfpfpfxyz"

//Challenge
//Can you do it without recursion?

//Notice
//Numbers can only appear in front of “[]”.




public class Solution {
    /**
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int slow = 0;
        int fast = 0;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> count = new ArrayDeque<>();
        Deque<String> encoded = new ArrayDeque<>();
        
        while (fast < s.length()) {
            char ch = s.charAt(fast);
            
            if (Character.isDigit(ch)) {
                slow = fast;
                while (fast < s.length() && Character.isDigit(s.charAt(fast))) {
                    fast++;
                }
                int num = Integer.valueOf(s.substring(slow, fast));
                count.push(num);
            } else if (ch == '[') {
                encoded.push(sb.toString());
                sb = new StringBuilder();
                fast++;
            } else if (Character.isLetter(ch)) {
                while (fast < s.length() && Character.isLetter(s.charAt(fast))) {
                    sb.append(s.charAt(fast));
                    fast++;
                }
            } else {
                int repeat = count.pop();
                String str = sb.toString();
                sb = new StringBuilder();
                for (int i = 0; i < repeat; i++) {
                    sb.append(str);
                }
                sb.insert(0, encoded.pop());
                fast++;
            }
        }
        return sb.toString();
    }
}



