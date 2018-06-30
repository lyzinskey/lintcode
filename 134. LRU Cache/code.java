//Design and implement a data structure for Least Recently Used (LRU) cache. 
//It should support the following operations: get and set.

//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//set(key, value) - Set or insert the value if the key is not already present. 
//When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.




public class LRUCache {
    /*
    * @param capacity: An integer
    */
    
    private int capacity, size;
    private ListNode dummy, tail;
    private Map<Integer, ListNode> keyToPrev;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.keyToPrev = new HashMap<Integer, ListNode>();
        this.dummy = new ListNode(0, 0);
        this.tail = this.dummy;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        
        moveToTail(key);
        
        return tail.val;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // "get" method will move the key to the end of the linked list
        if (get(key) != -1) {
            ListNode prev = keyToPrev.get(key);
            prev.next.val = value;
            return;
        }
        
        if (size < capacity) {
            size++;
            ListNode curr = new ListNode(key, value);
            tail.next = curr;
            keyToPrev.put(key, tail);
            tail = curr;
            return;
        }
        
        // replace the first node with the new key,value pair
        // after replacement, move the new node to the end of list
        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        
        first.key = key;
        first.val = value;
        keyToPrev.put(key, dummy);
        moveToTail(key);
    }
    
    private void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode curr = prev.next;
        
        if (tail == curr) {
            return;
        }
        
        prev.next = prev.next.next;
        tail.next = curr;
        
        if (prev.next != null) {
            keyToPrev.put(prev.next.key, prev);
        }
        keyToPrev.put(curr.key, tail);
        
        tail = curr;
    }
}

class ListNode {
    public int key, val;
    public ListNode next;
    
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}


