//Given two 1d vectors, implement an iterator to return their elements alternately.

//Example
//Given two 1d vectors:

//v1 = [1, 2]
//v2 = [3, 4, 5, 6]
//By calling next repeatedly until hasNext returns false, 
//the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].





public class ZigzagIterator {
    Queue<Iterator> queue = new LinkedList<>();
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (v1.size() != 0) {
            queue.offer(v1.iterator());        
        }
        if (v2.size() != 0) {
            queue.offer(v2.iterator());        
        }
    }

    public int next() {
        Iterator<Integer> iter = queue.poll();
        int res = iter.next();
        if (iter.hasNext()) {
            queue.offer(iter);
        }
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
 
 
 
 
