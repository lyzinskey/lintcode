//Implement a basic calculator to evaluate a simple expression string.

//The expression string may contain open ( and closing parentheses ), 
//the plus + or minus sign -, non-negative integers and empty spaces .

//You may assume that the given expression is always valid.

//Example
//"1 + 1" = 2
//" 2-1 + 2 " = 3
//"(1+(4+5+2)-3)+(6+8)" = 23

//Notice
//Do not use the eval built-in library function.



    public int calculate(String input) {
        int num = 0;
        int result = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.offerLast(result);
                stack.offerLast(sign);
                sign = 1;
                result = 0;
            } else if (ch == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pollLast();
                result += stack.pollLast();
            }
        }
        if (num != 0) {
            result += sign * num;
        }
        return result;           
    }
