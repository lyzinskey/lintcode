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
        
        for (String word : words) {
            if (exist(board, word)) {
                result.add(word);
            }
        }
        return result;
    }
    
    private boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
                
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        board[i][j] = '?';
        boolean result = dfs(board, word, i + 1, j, index + 1) ||
                         dfs(board, word, i - 1, j, index + 1) ||
                         dfs(board, word, i, j + 1, index + 1) ||
                         dfs(board, word, i, j - 1, index + 1);
        board[i][j] = word.charAt(index);
        return result;
    }    
}


