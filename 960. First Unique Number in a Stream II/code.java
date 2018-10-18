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




public class DataStream {
    static class Node {
        Node prev;
        Node next;
        int key;
        Node (int key) {
            this.key = key;
        }
    }

    private Map<Integer, Node> hashmap;
    private Node head;
    private Node tail;
    
    public DataStream(){
        hashmap = new HashMap<>();
    }

    public void add(int num) {
        if (hashmap.containsKey(num)) {
            Node node = hashmap.get(num);
            if (node != null) {
                hashmap.put(num, null);
                remove(node);
            }
        } else {
            Node node = new Node(num);
            hashmap.put(num, node);
            append(node);
        }        
    }

    public int firstUnique() {
        return head.key;
    }
    
    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (head == node) {
            head = head.next;
        }
        if (tail == node) {
            tail = tail.prev;
        }
        node.prev = node.next = null;
    }

    private void append(Node node) {
        if (head != null) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else {
            head = tail = node;

        }
    }    
}




