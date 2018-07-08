//Implement a stack with min() function, which will return the smallest number in the stack.

//It should support push, pop and min operation all in O(1) cost.

//min operation will never be called if there is no number in the stack.

//Example
//push(1)
//pop()   // return 1
//push(2)
//push(3)
//min()   // return 2
//push(1)
//min()   // return 1



public class MinStack {
    
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;    
    
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();  
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int element) {
        if (stack2.empty() || element <= stack2.peek()) {
            stack2.push(element);
        }
        stack1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (stack1.empty()) {
            return -1;
        }
        else {
            int result = stack1.pop();
            if (result == stack2.peek()) {
                stack2.pop();
            }
            return result;
        }
    }

    /*
     * @return: An integer
     */
    public int min() {
        return stack2.empty() ? -1 : stack2.peek();
    }
}


