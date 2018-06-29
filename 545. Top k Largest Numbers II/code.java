//Implement a data structure, provide two interfaces:

//add(number). Add a new number in the data structure.
//topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.

//Example
//s = new Solution(3);
//  >> create a new data structure.
//s.add(3)
//s.add(10)
//s.topk()
//  >> return [10, 3]
//s.add(1000)
//s.add(-99)
//s.topk()
//  >> return [1000, 10, 3]
//s.add(4)
//s.topk()
//  >> return [1000, 10, 4]
//s.add(100)
//s.topk()
//  >> return [1000, 100, 10]



public class Solution {
    
    private int size;
    private Queue<Integer> minheap;
    
    /*
    * @param k: An integer
    */public Solution(int k) {
        size = k;
        minheap = new PriorityQueue<>();
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        if (minheap.size() < size) {
            minheap.offer(num);
            return;
        }
        
        if (minheap.peek() < num) {
            minheap.poll();
            minheap.offer(num);
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        List<Integer> results = new ArrayList<>();
        Iterator iter = minheap.iterator();
        while (iter.hasNext()) {
            results.add((int) iter.next());
        }
        
        Collections.sort(results, Collections.reverseOrder());
        return results;
    }
}


