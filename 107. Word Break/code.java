//Given a string s and a dictionary of words dict, 
//determine if s can be break into a space-separated sequence of one or more dictionary words.

//Example
//Given s = "lintcode", dict = ["lint", "code"].
//
//Return true because "lintcode" can be break as "lint code".



public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int maxLength = getMaxLength(dict);
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            canBreak[i] = false;
            
            for (int j = 1; j <= maxLength && j <= i; j++) {
                if (!canBreak[i - j]) {
                    continue;
                }
                
                String string = s.substring(i - j, i);
                if (dict.contains(string)) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        
        return canBreak[s.length()];
    }
    
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        
        for (String word : dict) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        
        return maxLength;
    }
}

