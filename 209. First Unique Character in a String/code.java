//Find the first unique character in a given string. 
//You can assume that there is at least one unique character in the string.

//Example
//For "abaccdeff", return 'b'.



public class Solution {
    class ListCharNode {
        public char val;
        public ListCharNode next;
        public ListCharNode(char val) {
            this.val = val;
            this.next = null;
        }
    }
    
    class DataStream {
        private Map<Character, ListCharNode> charToPrev;
        private Set<Character> dupChars;
        private ListCharNode dummy, tail;
        
        public DataStream() {
            charToPrev = new HashMap<>();
            dupChars = new HashSet<>();
            dummy = new ListCharNode('.');
            tail = dummy;
        }
        
        public void add(char c) {
            if (dupChars.contains(c)) {
                return;
            }
            
            if (!charToPrev.containsKey(c)) {
                ListCharNode node = new ListCharNode(c);
                charToPrev.put(c, tail);
                tail.next = node;
                tail = node;
                return;
            }
            
            // delete the existing node
            ListCharNode prev = charToPrev.get(c);
            prev.next = prev.next.next;
            if (prev.next == null) {
                // tail node removed
                tail = prev;
            } else {
                charToPrev.put(prev.next.val, prev);
            }
            
            charToPrev.remove(c);
            dupChars.add(c);
        }
        
        public char firstUniqueChar() {
            return dummy.next.val;
        }
    }
    
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        DataStream ds = new DataStream();
        for (int i = 0; i < str.length(); i++) {
            ds.add(str.charAt(i));
        }
        return ds.firstUniqueChar();
    }
}


