//We need to implement a data structure named DataStream. There are two methods required to be implemented:

//  void add(number) // add a new number
//  int firstUnique() // return first unique number
//You can assume that there must be at least one unique number in the stream when calling the firstUnique.

//Example
//add(1)
//add(2)
//firstUnique() => 1
//add(1)
//firstUnique() => 2




class DataStream {
    private ListNode head, tail;
    private Map<Integer, ListNode> numToPrev;
    private Set<Integer> duplicates; 
    
    public DataStream() {
        // dummy
        head = new ListNode(0);
        tail = head;
        
        numToPrev = new HashMap<>();
        duplicates = new HashSet<>();
    }
    
    private void remove(int number) {
        ListNode prev = numToPrev.get(number);
        prev.next = prev.next.next;
        numToPrev.remove(number);
        
        // change tail and prev of next
        if (prev.next != null) {
            numToPrev.put(prev.next.val, prev);
        } else {
            tail = prev;
        }
    }
    
    public void add(int number) {
        if (duplicates.contains(number)) {
            return;
        }
        
        if (numToPrev.containsKey(number)) {
            remove(number);
            duplicates.add(number);
        } else {
            ListNode node = new ListNode(number);
            numToPrev.put(number, tail);
            tail.next = node;
            tail = node;
        }
    }
    
    public int firstUnique() {
        if (head.next != null) {
            return head.next.val;
        }
        return -1;
    } 
}


