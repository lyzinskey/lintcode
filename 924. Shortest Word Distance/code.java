//Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

//Example
//Example 1:
//
//Input：["practice", "makes", "perfect", "coding", "makes"],"coding","practice"
//Output：3
//Explanation：index("coding") - index("practice") = 3

//Example 2:
//
//Input：["practice", "makes", "perfect", "coding", "makes"],"makes","coding"
//Output：1
//Explanation：index("makes") - index("coding") = 1

//Notice
//You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.




public class Solution {
    /**
     * @param words: a list of words
     * @param word1: a string
     * @param word2: a string
     * @return: the shortest distance between word1 and word2 in the list
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int p1 = -1;
        int p2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
                if (p2 != -1) {
                    res = Math.min(res, p1 - p2);
                }
            }
            if (words[i].equals(word2)) {
                p2 = i;
                if (p1 != -1) {
                    res = Math.min(res, p2 - p1);
                }
            }
        }
        return res;
    }    
}



