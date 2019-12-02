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
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {                
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }                                
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }
        
        visited[i][j] = true;
        boolean result = dfs(board, word, i + 1, j, index + 1, visited) ||
                         dfs(board, word, i - 1, j, index + 1, visited) ||
                         dfs(board, word, i, j + 1, index + 1, visited) ||
                         dfs(board, word, i, j - 1, index + 1, visited);
        visited[i][j] = false;
        return result;
    }    
}




