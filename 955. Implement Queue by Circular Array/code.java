//Implement queue by circulant array. You need to support the following methods:

//CircularQueue(n): initialize a circular array with size n to store elements
//boolean isFull(): return true if the array is full
//boolean isEmpty(): return true if there is no element in the array
//void enqueue(element): add an element to the queue
//int dequeue(): pop an element from the queue

//it's guaranteed in the test cases we won't call enqueue if it's full and we also won't call dequeue if it's empty. 
//So it's ok to raise exception in scenarios described above.

//Example
//CircularQueue(5)
//isFull()   => false
//isEmpty() => true
//enqueue(1)
//dequeue()  => 1


public class CircularQueue {
    
    public int start;
    public int end;
    public int size;
    public int[] array;
    
    public CircularQueue(int n) {
        // initialize your data structure here
        start = 0;
        end = 0;
        size = 0;
        this.array = new int[n];
    }
    /**
     * @return:  return true if the array is full
     */
    public boolean isFull() {
        return size == array.length;
    }

    /**
     * @return: return true if there is no element in the array
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param element: the element given to be added
     * @return: nothing
     */
    public void enqueue(int element) {
        array[end] = element;
        size++;
        end++;
        if (end == array.length){
            end = 0;
        }
    }

    /**
     * @return: pop an element from the queue
     */
    public int dequeue() {
        int num = array[start];
        start++;
        size--;
        if (start == array.length){
            start = 0;
        }
        return num;
    }
}

