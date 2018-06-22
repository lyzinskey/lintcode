//Give a dictionary of words and a sentence with all whitespace removed, 
//return the number of sentences you can form by inserting whitespaces to the sentence 
//so that each word can be found in the dictionary.

//Ignore case

//Example
//Given a String CatMat
//Given a dictionary ["Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"]
//return 3
//
//we can form 3 sentences, as follows:
//CatMat = Cat Mat
//CatMat = Ca tM at
//CatMat = C at Mat



public class Solution {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        Map<String, Integer> memo = new HashMap<>();
        
        Set<String> lowerCaseDict = new HashSet<>();
        for (String word : dict) {
            lowerCaseDict.add(word.toLowerCase());
        }
        
        int result = wordBreakHelper(s.toLowerCase(), lowerCaseDict, memo);
        return result;
    }
    
    private int wordBreakHelper(String s, 
                                Set<String> wordDict, 
                                Map<String, Integer> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        int result = 0;
        
        if (s == null || s.length() == 0) {
            return result;
        }
        
        if (wordDict.contains(s)) {
            result++;
        }
        
        for (int i = 1; i < s.length(); i++) {
            String word = s.substring(0, i);
            if (!wordDict.contains(word)) {
                continue;
            }
            
            String suffix = s.substring(i);
            result += wordBreakHelper(suffix, wordDict, memo);
        }
        
        memo.put(s, result);
        return result;
    }    
}

