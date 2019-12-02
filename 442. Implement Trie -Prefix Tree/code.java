//Implement a trie with insert, search, and startsWith methods.

//You may assume that all inputs are consist of lowercase letters a-z.

//Example
//insert("lintcode")
//search("code")
//>>> false
//startsWith("lint")
//>>> true
//startsWith("linterror")
//>>> false
//insert("linterror")
//search("lintcode)
//>>> true
//startsWith("linterror")
//>>> true




public class Trie {
    class TrieNode {
        private TrieNode[] child;
        private boolean isWord;
        
        public TrieNode() {
            this.child = new TrieNode[26];
            this.isWord = false;
        }
    }
    
    private TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        TrieNode node = root;
        char[] array = word.toCharArray();
        for (char ch : array) {
            int index = ch - 'a';
            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
        }
        node.isWord = true;        
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isWord;        
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }
    
    private TrieNode find(String input) {
        TrieNode node = root;
        char[] array = input.toCharArray();
        for (char ch : array) {
            int index = ch - 'a';
            node = node.child[index];
            if (node == null) {
                return node;
            }
        }
        return node;
    }
}



