//Implement a stack by two queues. The queue is first in first out (FIFO). 
//That means you can not directly pop the last element in a queue.

//Example
//push(1)
//pop()
//push(2)
//isEmpty() // return false
//top() // return 2
//pop()
//isEmpty() // return true


public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    
    public Queue<Integer> queue1 = new LinkedList<>();
    public Queue<Integer> queue2 = new LinkedList<>();
    
    public void push(int x) {
        queue1.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        if (!queue1.isEmpty()){
            while (queue1.size() != 1){
                queue2.offer(queue1.poll());
            }
            queue1.poll();
            swap();
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        while (queue1.size() != 1){
            queue2.offer(queue1.poll());
        }
        int top = queue1.poll();
        queue2.offer(top);
        swap();
        return top;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
    
    private void swap() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
}

