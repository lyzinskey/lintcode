//Given an input string, reverse the string word by word.

//For example,
//Given s = "the sky is blue",
//return "blue is sky the".

//Clarification
//What constitutes a word?
//A sequence of non-space characters constitutes a word.
//
//Could the input string contain leading or trailing spaces?
//Yes. However, your reversed string should not contain leading or trailing spaces.
//
//How about multiple spaces between two words?
//Reduce them to a single space in the reversed string.




public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);        
    }
}



