//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
//determine if the input string is valid in O(n) time.

//Example
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.




public class Solution {
    public boolean isValidParentheses(String input) {
        if (input == null || input.length() == 0) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(')');
            }
            else if (ch == '[') {
                stack.push(']');
            }
            else if (ch == '{') {
                stack.push('}');
            }
            else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }     
}



