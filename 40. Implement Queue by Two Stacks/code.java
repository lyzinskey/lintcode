//As the title described, you should only use two stacks to implement a queue's actions.

//The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.

//Both pop and top methods should return the value of first element.

//Example
//push(1)
//pop()     // return 1
//push(2)
//push(3)
//top()     // return 2
//pop()     // return 2

//Challenge
//implement it by two stacks, do not use any other data structure and push, pop and top should be O(1) by AVERAGE.


public class MyQueue {
    
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        stack2.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (stack1.empty()){
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }
        return stack1.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (stack1.empty()){
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }            
        }
        return stack1.peek();
    }
}

