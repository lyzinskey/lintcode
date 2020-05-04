//Given an arbitrary ransom note string and another string containing letters from all the magazines, 
//write a function that will return true if the ransom note can be constructed from the magazines; 
//otherwise, it will return false.

//Each letter in the magazine string can only be used once in your ransom note.

//Example
//Example 1
//
//Input : ransomNote = "aa", magazine = "aab"
//Output : true
//Explanation : the ransom note can be constructed from the magazines.

//Example 2
//
//Input : ransomNote = "aaa", magazine = "aab"
//Output : false
//Explanation : the ransom note can't be constructed from the magazines.

//Notice
//You may assume that both strings contain only lowercase letters.




public class Solution {
    /**
     * @param ransomNote: a string
     * @param magazine: a string
     * @return: whether the ransom note can be constructed from the magazines
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        
        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }
        
        for (char ch : ransomNote.toCharArray()) {
            int index = ch - 'a';
            count[index]--;
            if (count[index] < 0) {
                return false;
            }
        }
        return true;
    }    
}



