//Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. 
//Such a word is said to complete the given string licensePlate

//Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

//It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

//The license plate might have the same letter occurring multiple times. 
//For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

//Example
//Example 1:
//	Input:  licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
//	Output:  "steps"
//	
//	Explanation:
//	The smallest length word that contains the letters "S", "P", "S", and "T".
//	Note that the answer is not "step", because the letter "s" must occur in the word twice.
//	Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
	
//Example 2:
//	Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
//	Output:  "pest"
//	
//	Explanation:
//	There are 3 smallest length words that contains the letters "s".
//	We return the one that occurred first.
	
//Notice
//licensePlate will be a string with length in range [1, 7].
//licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
//words will have a length in the range [10, 1000].
//Every words[i] will consist of lowercase letters, and have length in range [1, 15].





public class Solution {
    /**
     * @param licensePlate: a string
     * @param words: List[str]
     * @return: return a string
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] freq = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char ch = licensePlate.charAt(i);
            if (Character.isLetter(ch)) {
                freq[Character.toLowerCase(ch) - 'a']++;
            }
        }
        
        int len = Integer.MAX_VALUE;
        String res = "";
        int[] count = new int[26];
        
        for (String word : words) {
            if (word.length() >= len) {
                continue;
            }
            if (!match(freq, word, count)) {
                continue;
            }
            len = word.length();
            res = word;
        }
        return res;
    }
    
    private boolean match(int[] freq, String word, int[] count) {
        Arrays.fill(count, 0);
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLetter(ch)) {
                count[Character.toLowerCase(ch) - 'a']++;
            }
        }
        
        for (int i = 0; i < count.length; i++) {
            if (freq[i] > count[i]) {
                return false;
            }
        }
        return true;
    }    
}




