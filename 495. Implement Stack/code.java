//Implement a stack. You can use any data structure inside a stack except stack itself to implement it.

//Example
//push(1)
//pop()
//push(2)
//top()  // return 2
//pop()
//isEmpty() // return true
//push(3)
//isEmpty() // return false


public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    
    int top = 0;
    ArrayList<Integer> stack = new ArrayList<>();
    
    public void push(int x) {
        stack.add(x);
        top++;
    }

    /*
     * @return: nothing
     */
    public void pop() {
        if(!isEmpty()){
            top--;
            stack.remove(top);
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        return stack.get(top - 1);
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return top == 0;
    }
}

