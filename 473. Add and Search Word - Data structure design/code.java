//Design a data structure that supports the following two operations: addWord(word) and search(word)

//search(word) can search a literal word or a regular expression string containing only letters a-z or ..
//A . means it can represent any one letter.

//Example
//Example 1:
//
//Input:
//  addWord("a")
//  search(".")
//Output:
//  true

//Example 2:
//
//Input:
//  addWord("bad")
//  addWord("dad")
//  addWord("mad")
//  search("pad")  
//  search("bad")  
//  search(".ad")  
//  search("b..")  
//Output:
//  false
//  true
//  true
//  true

//Notice
//You may assume that all words are consist of lowercase letters a-z.




public class WordDictionary {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }
    
    private TrieNode root = new TrieNode();
    
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) {
            return node.isWord;
        }
        if (chs[k] == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && match(chs, k + 1, node.children[i])) {
                    return true;
                }
            }
        } else {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        }
        return false;
    }
}



