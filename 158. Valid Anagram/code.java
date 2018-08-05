//Write a method anagram(s,t) to decide if two strings are anagrams or not.

//Example
//Given s = "abcd", t = "dcab", return true.
//Given s = "ab", t = "ab", return true.
//Given s = "ab", t = "ac", return false.

//Challenge
//O(n) time, O(1) extra space

//Clarification
//What is Anagram?

//Two strings are anagram if they can be the same after change the order of characters.




public class Solution {
    public boolean anagram(String s, String l) {
        if (l == null || s == null || s.length() != l.length()) {
            return false;
        }

        Map<Character, Integer> hashmap = getLetterFrequency(s);
        int matches = hashmap.size();

        for (int i = 0; i < l.length(); i++) {
            char ch = l.charAt(i);
            Integer count = hashmap.get(ch);

            if (count != null) {
                hashmap.put(ch, count - 1);
                if (count == 1) {
                    matches--;
                }
            }
        }

        return matches == 0;
    }

    private Map<Character, Integer> getLetterFrequency(String s) {
        Map<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashmap.containsKey(s.charAt(i))) {
                hashmap.put(s.charAt(i), hashmap.get(s.charAt(i)) + 1);
            }
            else {
                hashmap.put(s.charAt(i), 1);
            }
        }
        return hashmap;
    }    
}



