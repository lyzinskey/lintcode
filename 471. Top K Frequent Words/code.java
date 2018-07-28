//Given a list of words and an integer k, return the top k frequent words in the list.

//You should order the words by the frequency of them in the return list, 
//the most frequent one comes first. If two words has the same frequency, the one with lower alphabetical order come first.

//Example
//Given
//
//  [
//      "yes", "lint", "code",
//      "yes", "code", "baby",
//      "you", "baby", "chrome",
//      "safari", "lint", "code",
//      "body", "lint", "code"
//  ]
//for k = 3, return ["code", "lint", "baby"].
//for k = 4, return ["code", "lint", "baby", "yes"],

//Challenge
//Do it in O(nlogk) time and O(n) extra space.



public class Solution {
    public String[] topKFrequentWords(String[] combo, int k) {
        if (k == 0) {
            return new String[0];
        }
        
        Map<String, Integer> hashmap = new HashMap<>();

        for (String string : combo) {
            if (hashmap.containsKey(string)) {
                hashmap.put(string, hashmap.get(string) + 1);
            }
            else {
                hashmap.put(string, 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> minheap = new PriorityQueue<>(k, myComparator);
        

        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            minheap.offer(entry);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }

        String[] result = new String[minheap.size()];
        getTopK(result, minheap);

        return result;
    }

    private static void getTopK(String[] result, PriorityQueue<Map.Entry<String, Integer>> minheap) {
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = minheap.poll().getKey();
        }
    }    
    
    private Comparator<Map.Entry<String, Integer>> myComparator = new Comparator<Map.Entry<String, Integer>>() {
        public int compare(Map.Entry<String, Integer> entry1,
                           Map.Entry<String, Integer> entry2) {
            if (entry1.getValue().equals(entry2.getValue())) {
                return -entry1.getKey().compareTo(entry2.getKey());
            }                    
            return entry1.getValue() < entry2.getValue() ? -1 : 1;
        }
    };    
}


