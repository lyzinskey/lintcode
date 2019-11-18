//Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, 
//determine if two sentences are similar.

//For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, 
//if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].

//Note that the similarity relation is transitive. 
//For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.
//Similarity is also symmetric. 
//For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
//Also, a word is always similar with itself. 
//For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, 
//even though there are no specified similar word pairs.
//Finally, sentences can only be similar if they have the same number of words. 
//So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

//Example
//Example 1:
//
//Input:
//["7", "5", "4", "11", "13", "15", "19", "12", "0", "10"]
//["16", "1", "7", "3", "15", "10", "13", "2", "19", "8"]
//[["6", "18"], ["8", "17"], ["1", "13"], ["0", "8"], ["9", "14"], ["11", "17"], 
//["11", "19"], ["13", "16"], ["0", "18"], ["3", "11"], ["1", "9"], ["2", "11"], 
//["2", "4"], ["0", "19"], ["8", "12"], ["8", "19"], ["16", "19"], ["1", "11"], 
//["2", "18"], ["0", "16"], ["7", "11"], ["6", "8"], ["9", "17"], ["8", "16"], 
//["3", "13"], ["7", "9"], ["7", "10"], ["3", "6"], ["15", "19"], ["1", "5"], 
//["2", "14"], ["1", "18"], ["8", "15"], ["14", "19"], ["3", "17"], ["6", "10"], 
//["5", "17"], ["10", "15"], ["1", "10"], ["4", "6"]]
//
//Output:
//true

//Example 2:
//
//Input:
//["great","acting","skills"]
//["fine","drama","talent"]
//[["great","good"],["fine","good"],["drama","acting"],["skills","talent"]]
//
//Output:
//true

//Notice
//1.The length of words1 and words2 will not exceed 1000.
//2.The length of pairs will not exceed 2000.
//3.The length of each pairs[i] will be 2.
//4.The length of each words[i] and pairs[i][j] will be in the range [1, 20].




public class Solution {   
    /**
     * @param words1: 
     * @param words2: 
     * @param pairs: 
     * @return: Whether sentences are similary or not?
     */
     
    
    // union-find
    // using string as key of union-find
    // Time: O(|Pairs| + |words1|)
    // Space: O(|Pairs|)
    public boolean areSentencesSimilarTwo(List<String> words1, List<String> words2, List<List<String>> pairs) {
        if (words1.size() != words2.size()) {
            return false;
        }
        
        Map<String, String> hashmap = new HashMap<>();        
        for (List<String> pair : pairs) {
            String parent1 = find(hashmap, pair.get(0));
            String parent2 = find(hashmap, pair.get(1));
            if (!parent1.equals(parent2)) {
                hashmap.put(parent1, parent2);
            }
        }
        for (int i = 0; i < words1.size(); i++) {
            String w1 = words1.get(i);
            String w2 = words2.get(i);
            if (w1.equals(w2)) {
                continue;
            }
            if (!find(hashmap, w1).equals(find(hashmap, w2))) {
                return false;
            }
        }
        return true;
    }
    
    private String find(Map<String, String> hashmap, String word) {
        if (!hashmap.containsKey(word)) {
            hashmap.put(word, word);
        } else if (hashmap.containsKey(hashmap.get(word))) {
            hashmap.put(word, hashmap.get(hashmap.get(word)));
        }
        return word.equals(hashmap.get(word)) ? word : find(hashmap, hashmap.get(word));
    }
}



