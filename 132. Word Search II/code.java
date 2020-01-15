//Given a matrix of lower alphabets and a dictionary. 
//Find all words in the dictionary that can be found in the matrix. 
//A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 
//One character only be used once in one word.

//Example
//Given matrix:
//  [
//    doaf
//    agai
//    dcan
//  ]
//and dictionary:
//
//{"dog", "dad", "dgdg", "can", "again"}
//
//return {"dog", "dad", "can", "again"}





/*
trie: build trie to store every word
do dfs in board, for every path, try to match it in trie

Time: O(k*l + m*n * 4^l)    ->  m * n matrix, average length of word is l, size of words is k
k*l time to build trie, m*n*4^l to do dfs
*/
class Solution {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> wordSearchII(char[][] board, List<String> words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.size() == 0) {
            return result;
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, visited, trie.root, sb, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited, TrieNode root, StringBuilder sb, List<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return;
        }

        char ch = board[i][j];
        int index = ch - 'a';
        if (root.child[index] == null) {
            return;
        }

        root = root.child[index];
        sb.append(ch);
        if (root.isWord) {
            result.add(sb.toString());
            root.isWord = false;
        }

        visited[i][j] = true;
        for (int[] dir : dirs) {
            int dx = i + dir[0];
            int dy = j + dir[1];
            dfs(board, dx, dy, visited, root, sb, result);
        }
        sb.deleteCharAt(sb.length() - 1);
        visited[i][j] = false;
    }

    class TrieNode {
        private TrieNode[] child;
        private boolean isWord;

        public TrieNode() {
            this.child = new TrieNode[26];
            this.isWord = false;
        }
    }
    
    class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.child[index] == null) {
                    node.child[index] = new TrieNode();
                }
                node = node.child[index];
            }
            node.isWord = true;
        }
    }
}




/*
brute force: for every word, use dfs to search every possible path in board

Time: O(k*m*n * 4^l)    ->  m * n matrix, average length of word is l, size of words is k
*/
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0) {
            return result;
        } 
                
        for (int i = 0; i < words.size(); i++) {
            if (exist(board, words.get(i))) {
                result.add(words.get(i));
            }            
        }
        return result;        
    }
    
    private boolean exist(char[][] board, String word) {        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {                
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }                                
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index) || board[i][j] == '#') {
            return false;
        }
        
        char ch = board[i][j];
        board[i][j] = '#';
        boolean result = dfs(board, word, i + 1, j, index + 1) ||
                         dfs(board, word, i - 1, j, index + 1) ||
                         dfs(board, word, i, j + 1, index + 1) ||
                         dfs(board, word, i, j - 1, index + 1);
        board[i][j] = ch;
        return result;
    }
}




