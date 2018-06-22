//Given a string s and a dictionary of words dict, 
//add spaces in s to construct a sentence where each word is a valid dictionary word.

//Return all such possible sentences.

//Example
//Give s = lintcode,
//dict = ["de", "ding", "co", "code", "lint"].
//
//A solution is ["lint code", "lint co de"].



public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, ArrayList<String>> memo = new HashMap<>();
        return wordBreakHelper(s, wordDict, memo);
    }
    
    private List<String> wordBreakHelper(String s, 
                                         Set<String> wordDict, 
                                         Map<String, ArrayList<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        ArrayList<String> result = new ArrayList<>();
        
        if (s == null || s.length() == 0) {
            return result;
        }
        
        if (wordDict.contains(s)) {
            result.add(s);
        }
        
        for (int i = 1; i < s.length(); i++) {
            String word = s.substring(0, i);
            if (!wordDict.contains(word)) {
                continue;
            }
            
            String suffix = s.substring(i);
            List<String> suffixList = wordBreakHelper(suffix, wordDict, memo);
            
            for (String segment : suffixList) {
                result.add(word + " " + segment);
            }
        }
        
        memo.put(s, result);
        return result;
    }
}

