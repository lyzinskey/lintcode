//Given a nested list of integers, implement an iterator to flatten it.

//Each element is either an integer, or a list -- whose elements may also be integers or other lists.

//Example
//Example1
//
//Input: list = [[1,1],2,[1,1]]
//Output: [1,1,2,1,1]

//Example2
//
//Input: list = [1,[4,[6]]]
//Output: [1,4,6]

//Notice
//You don't need to implement the remove method.




/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> queue;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        helper(nestedList);
    }
    
    private void helper(List<NestedInteger> nestedList) {
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                queue.offer(nest.getInteger());
            } else {
                helper(nest.getList());
            }
        }
    }
    
    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        return queue.isEmpty() ? -1 : queue.poll();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */
 
 
 
 
