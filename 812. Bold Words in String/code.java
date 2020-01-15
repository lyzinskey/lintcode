//Given a set of keywords words and a string S, make all appearances of all keywords in S bold. 
//Any letters between <b> and </b> tags become bold.
//The returned string should use the least number of tags possible, and of course the tags should form a valid combination.

//Example
//Example 1:
//
//Input:
//["ab", "bc"]
//"aabcd"
//Output:
//"a<b>abc</b>d"
//
//Explanation:
//Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.

//Example 2:
//
//Input:
//["bcccaeb","b","eedcbda","aeebebebd","ccd","eabbbdcde","deaaea","aea","accebbb","d"]
//"ceaaabbbedabbecbcced"
//Output:
//"ceaaa<b>bbb</b>e<b>d</b>a<b>bb</b>ec<b>b</b>cce<b>d</b>"

//Notice
//words has length in range [0, 50].
//words[i] has length in range [1, 10].
//S has length in range [0, 500].
//All characters in words[i] and S are lowercase letters.




public class Solution {
    /**
     * @param words: the words
     * @param S: the string
     * @return: the string with least number of tags
     */
    // Time: O(n*L^2) L is the max length of word
    // Space: O(n)
    public String boldWords(String[] words, String S) {
        Set<String> dict = new HashSet<>();
        int maxLen = 0;        
        for (String word : words) {
            dict.add(word);
            maxLen = Math.max(maxLen, word.length());
        }
                
        int n = S.length();
        int[] bold = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < Math.min(n, i + maxLen); j++) {
                String subStr = S.substring(i, j + 1);
                if (dict.contains(subStr)) {
                    for (int k = i; k <= j; k++) {
                        bold[k] = 1;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (bold[i] == 1 && (i == 0 || bold[i - 1] == 0)) {
                sb.append("<b>");
            }
            sb.append(S.charAt(i));
            if (bold[i] == 1 && (i == n - 1 || bold[i + 1] == 0)) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }    
}



